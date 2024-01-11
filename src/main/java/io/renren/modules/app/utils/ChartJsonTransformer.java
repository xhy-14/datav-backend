package io.renren.modules.app.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;

/**
 * @author xiehanying
 */
@Component
public class ChartJsonTransformer {
    /**
     * 生成图表默认配置
     * @param json
     * @return
     */
    private  Object generateDefaultChart(String json) {
        String result = parseJson(JSON.parseObject(json));
        result = result.substring(0, result.length() - 1);
        result = result.replaceAll("\"\\[\"", "[\"");
        result = result.replaceAll("\"\\]\"", "\"]");
        result = "{\n" + result + "\n}";
        return JSON.parseObject(result);
    }

    private String parseJson(JSONObject jsonObject) {
        String result = "";
        Integer i = 0;

        for (String key : jsonObject.keySet()) {
            i++;
            Object value = jsonObject.get(key);
            if ( value instanceof JSONArray && !parameterKey(key)) {
                // 如果是 JSON 数组,则递归解析
                result += "\"" + key + "\"" + ": [\n" + parseJsonArray((JSONArray) value) + "],\n";
            } else if (!parameterKey(key)) {
                // 如果不是参数定义的key
                //判断该节点是否是参数类型
                JSONObject child = JSON.parseObject(value.toString());
                Set<String> ck = child.keySet();
                Iterator<String> iterator = ck.iterator();

                // 是孩子
                if ( parameterKey(iterator.next()) ) {
                    if (i == jsonObject.keySet().size() - 1 ) {
                        result +=  "\t" + "\"" + key + "\"" + ": " + parseJson((JSONObject) value) + ",\n";
                    } else {
                        result +=  "\t" + "\"" + key + "\"" + ": " + parseJson((JSONObject) value) + "\n";
                    }
                } else {
                    if (i == jsonObject.keySet().size() - 1 ) {
                        result += "\"" + key + "\"" + ": {\n" + parseJson((JSONObject) value) + "},\n";
                    } else {
                        result += "\"" + key + "\"" + ": {\n" + parseJson((JSONObject) value) + "}\n";
                    }
                }

            } else {
                // 如果是其他类型,则将其添加到结果中
                return "\"" + value.toString() + "\"";
            }
        }
        return result;
    }

    private String parseJsonArray(JSONArray jsonArray) {
        String result = "";
        for (int i = 0; i < jsonArray.size(); i++) {
            Object value = jsonArray.get(i);
            if (value instanceof JSONObject) {
                // 如果是 JSON 对象,则递归解析
                String tmp = parseJson((JSONObject) value);
                if (i == jsonArray.size() -1 ) {
                    result += "{\n" + parseJson((JSONObject) value) + "}\n";
                } else {
                    result += "{\n" + parseJson((JSONObject) value) + "},\n";
                }

            } else if (value instanceof JSONArray) {
                // 如果是 JSON 数组,则递归解析
                parseJsonArray((JSONArray) value);
            } else {
                // 如果是其他类型,则将其添加到结果中
            }
        }
        return result;
    }

    /**
     * 判断是不是参数定义的key
     * @return
     */
    private boolean parameterKey(String key) {
        String[] keys = {"pdefault", "ptype", "pvalue"};
        for( String k: keys ) {
            if(k.equals(key)){
                return true;
            }
        }
        return false;
    }
}

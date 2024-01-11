package io.renren.modules.app.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Set;

public class Test {

    private static String json = "{\n" +
            "  \"xAxis\": {\n" +
            "    \"type\": {\n" +
            "      \"pdefault\": \"category\",\n" +
            "      \"pvalue\": \"log,time\",\n" +
            "      \"ptype\": \"select\"\n" +
            "    },\n" +
            "    \"data\": {\n" +
            "      \"pdefault\": [\"Mon\", \"Tue\", \"Wed\", \"Thu\", \"Fri\", \"Sat\", \"Sun\"],\n" +
            "      \"ptype\": \"list\",\n" +
            "      \"value\": \"null\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"title\": {\n" +
            "    \"left\": {\n" +
            "      \"pdefault\": \"center\",\n" +
            "      \"pvalue\": \"left,right\",\n" +
            "      \"ptype\": \"select\"\n" +
            "    },\n" +
            "    \"text\": {\n" +
            "      \"pdefault\": \"Large Area Chart\",\n" +
            "      \"pvalue\": \"left,right\",\n" +
            "      \"ptype\": \"text\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"yAxis\": {\n" +
            "    \"type\": {\n" +
            "      \"pdefault\": \"value\",\n" +
            "      \"pvalue\": \"log,time\",\n" +
            "      \"ptype\": \"select\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"series\": [\n" +
            "    {\n" +
            "      \"data\": {\n" +
            "        \"pdefault\": [820, 932, 901, 934, 1290, 1330, 1320],\n" +
            "        \"ptype\": \"list\",\n" +
            "        \"value\": \"null\"\n" +
            "      },\n" +
            "      \"type\": {\n" +
            "        \"pdefault\": \"line\",\n" +
            "        \"pvalue\": \"log,time\",\n" +
            "        \"ptype\": \"select\"\n" +
            "      },\n" +
            "      \"smooth\": {\n" +
            "        \"pdefault\": true,\n" +
            "        \"pvalue\": \"log,time\",\n" +
            "        \"ptype\": \"bool\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) {
        System.out.println(generateDefaultChart(json));
    }

    private static Object generateDefaultChart(String json) {
        String result = parseJson(JSON.parseObject(json));
        result = result.substring(0, result.length() - 1);
        result = result.replaceAll("\"\\[\"", "[\"");
        result = result.replaceAll("\"\\]\"", "\"]");
        result = "{\n" + result + "\n}";
        System.out.println(result);
        return JSON.parseObject(result);
    }

    private static String parseJson(JSONObject jsonObject) {
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
                        result +=  "\t" + "\"" + key + "\"" + ": " + parseJson((JSONObject) value) + "\n";
                    } else {
                        result +=  "\t" + "\"" + key + "\"" + ": " + parseJson((JSONObject) value) + ",\n";
                    }
                } else {
                    if (i == jsonObject.keySet().size() - 1 ) {
                        result += "\"" + key + "\"" + ": {\n" + parseJson((JSONObject) value) + "}\n";
                    } else {
                        result += "\"" + key + "\"" + ": {\n" + parseJson((JSONObject) value) + "},\n";
                    }
                }

            } else {
                // 如果是其他类型,则将其添加到结果中
                return "\"" + value.toString() + "\"";
            }
        }
        return result;
    }

    private static String parseJsonArray(JSONArray jsonArray) {
        String result = "";
        for (int i = 0; i < jsonArray.size(); i++) {
            Object value = jsonArray.get(i);
            if (value instanceof JSONObject) {
                // 如果是 JSON 对象,则递归解析
                String tmp = parseJson((JSONObject) value);
                if (i == jsonArray.size() - 1 ) {
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
    private static boolean parameterKey(String key) {
        String[] keys = {"pdefault", "ptype", "pvalue"};
        for( String k: keys ) {
            if(k.equals(key)){
                return true;
            }
        }
        return false;
    }

    private static void config() {

    }

    private static String parseConfigJson(JSONObject jsonObject) {
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

    private static String parseConfigJsonArray(JSONArray jsonArray) {
        String result = "";
        for (int i = 0; i < jsonArray.size(); i++) {
            Object value = jsonArray.get(i);
            if (value instanceof JSONObject) {
                // 如果是 JSON 对象,则递归解析
                parseConfigJson((JSONObject) value);
            } else if (value instanceof JSONArray) {
                // 如果是 JSON 数组,则递归解析
                parseConfigJsonArray((JSONArray) value);
            } else {
                // 如果是其他类型,则将其添加到结果中
            }
        }
        return result;
    }
}

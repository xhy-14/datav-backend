/**
 * csv处理工具
 * @author xie
 * @time 2024-1-9
 */
package io.renren.modules.app.utils;

import cn.hutool.http.Header;
import com.opencsv.CSVReader;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.exceptions.CsvException;
import io.renren.common.exception.RRException;
import io.renren.modules.app.entity.CSVEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Component
public class CSVUtils {

    /**
     * 将csv字符串转换为CSV对象
     * @param csvString
     * @return
     */
    public CSVEntity stringToCSV(String csvString) {
        CSVEntity csvEntity = new CSVEntity();

        // 读取每一行
        String[] rows = csvString.split("\r\n");

        // 读取表头
        String[] headers = rows[0].split(",");

        csvEntity.setHeaders(Arrays.asList(headers));

        // 是否有数据
        if(rows.length <= 1) {
            return csvEntity;
        }
        List<Map<Object, Object>> allData = new ArrayList<>();
        // 读取数据
        for (int i = 1; i<rows.length; i++) {
            String[] rowData = rows[i].split(",");
            Map<Object, Object> map = new HashMap<>(10);
            int j = 0;
            for(String s: rowData) {
                map.put(headers[j], s);
                j++;
            }
            allData.add(map);
        }

        csvEntity.setRows(allData);

        return csvEntity;
    }

    /**
     * 通过url读取csv文件
     * @param csvUrl
     * @return
     */
    public CSVEntity getCSVByUrl(String csvUrl) {
        try {
            URL url = new URL(csvUrl);
            InputStream inputStream = url.openConnection().getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\r\n");
            }
            CSVEntity csvEntity = stringToCSV(stringBuilder.toString());
            return csvEntity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("获取数据失败");
        }
    }

    /**
     * csv对象转为字符串
     * @param csv
     * @return
     */
    public String CSVToString(CSVEntity csv) {
        StringBuilder stringBuilder = new StringBuilder();

        // 构建表头
        for(int i=0; i<csv.getHeaders().size(); i++) {
            if(i != csv.getHeaders().size()-1) {
                stringBuilder.append(csv.getHeaders().get(i) + ",");
            } else {
                stringBuilder.append(csv.getHeaders().get(i) + "\r\n");
            }
        }

        // 构建数据列
        for (int i=0; i<csv.getRows().size(); i++) {
            for(int j=0; j<csv.getHeaders().size(); j++) {
                if(j != csv.getHeaders().size()-1) {
                    stringBuilder.append(csv.getRows().get(i).get(csv.getHeaders().get(j)) + ",");
                } else {
                    stringBuilder.append(csv.getRows().get(i).get(csv.getHeaders().get(j)) + "\r\n");
                }
            }
        }
        return stringBuilder.toString();
    }

}

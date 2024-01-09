/**
 * csv处理工具
 * @author xie
 * @time 2024-1-9
 */
package io.renren.modules.app.utils;

import cn.hutool.http.Header;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.renren.common.exception.RRException;
import io.renren.modules.app.entity.CSVEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<List<String>> allData = new ArrayList<>();
        // 读取数据
        for (int i = 1; i<rows.length; i++) {
            String[] rowData = rows[i].split(",");
            List<String> data = new ArrayList<>();
            for(String s: rowData) {
                data.add(s);
            }
            allData.add(data);
        }

        csvEntity.setRows(allData);

        return csvEntity;
    }

    /**
     * 通过url读取csv文件
     * @param url
     * @return
     */
    public CSVEntity getCSVByUrl(String url) {
        BufferedReader reader = null;
        CSVEntity csvEntity = new CSVEntity();
        csvEntity.setRows(new ArrayList<>());
        try {
            reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            CSVReader csvReader = new CSVReader(reader);

            // 读取数据
            try {
                List<String[]> rows = csvReader.readAll();
                // 插入数据表头
                csvEntity.setHeaders(Arrays.asList(rows.get(0)));

                // 加入数据
                for(int i = 1; i<rows.size(); i++) {
                    csvEntity.getRows().add(Arrays.asList(rows.get(i)));
                }

            } catch (CsvException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RRException("系统异常");
        }

        return csvEntity;
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
                    stringBuilder.append(csv.getRows().get(i).get(j) + ",");
                } else {
                    stringBuilder.append(csv.getRows().get(i).get(j) + "\r\n");
                }
            }
        }
        return stringBuilder.toString();
    }

}
/**
 * csv处理工具
 * @author xie
 * @time 2024-1-9
 */
package io.renren.modules.app.utils;

import io.renren.modules.app.entity.CSVEntity;
import org.springframework.stereotype.Component;

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

}

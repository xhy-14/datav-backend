package io.renren.modules.app.entity;

import lombok.Data;

import java.util.List;

@Data
public class CSVEntity {
    /**
     * 数据表头
     */
    private List<String> headers;

    /**
     * 数据表行
     */
    private List<List<String>> rows;
}

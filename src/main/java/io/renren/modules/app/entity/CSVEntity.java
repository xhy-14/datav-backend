package io.renren.modules.app.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author xiehanying
 */
@Data
public class CSVEntity {
    /**
     * 数据表头
     */
    private List<Object> headers;

    /**
     * 数据表行
     */
    private List<Map<Object, Object>> rows;
}

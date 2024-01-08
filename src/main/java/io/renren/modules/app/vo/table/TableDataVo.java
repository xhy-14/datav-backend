package io.renren.modules.app.vo.table;

import io.renren.modules.app.entity.CSVEntity;
import lombok.Data;

import java.util.List;

@Data
public class TableDataVo {
    /**
     * 数据表名
     */
    private String name;

    /**
     * csv
     */
    private CSVEntity data;

    /**
     * 总行数
     */
    private long rowSum;

}

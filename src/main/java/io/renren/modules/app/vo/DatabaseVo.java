package io.renren.modules.app.vo;

import lombok.Data;

import java.util.List;

/**
 * @author xiehanying
 */
@Data
public class DatabaseVo {
    private long id;
    private String name;
    private List<String> tables;
}

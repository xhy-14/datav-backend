package io.renren.modules.app.vo;

import lombok.Data;

import java.util.List;

/**
 * @author xiehanying
 */
@Data
public class DatabaseVo {
    private String name;
    private List<String> tables;
}

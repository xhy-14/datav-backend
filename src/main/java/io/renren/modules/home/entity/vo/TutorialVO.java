package io.renren.modules.home.entity.vo;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

@Data
public class TutorialVO {
    private Long id;
    private Long fileId;
    private String content;
    private String path;
    private Integer isDelete;
    private Date createTime;
    private Date updateTime;


}

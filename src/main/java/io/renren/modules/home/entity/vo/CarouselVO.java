package io.renren.modules.home.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CarouselVO {

    private Long id;

    private Long fileId;

    private String content;

    private String path;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

}

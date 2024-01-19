package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.renren.modules.table.entity.GeneratedChartEntity;
import lombok.Data;

import java.util.Date;

@Data
public class GeneratedChartVo {
    /**
     * 已生成图表ID
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 图表类型id
     */
    private Long chartTypeId;
    /**
     * 元数据id
     */
    private Long metadataId;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String depiction;
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 参数配置
     */
    private Object option;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public GeneratedChartVo(GeneratedChartEntity generatedChartEntity) {
        this.id = generatedChartEntity.getId();
        this.userId = generatedChartEntity.getUserId();
        this.chartTypeId = generatedChartEntity.getChartTypeId();
        this.metadataId = generatedChartEntity.getMetadataId();
        this.name = generatedChartEntity.getName();
        this.depiction = generatedChartEntity.getDepiction();
        this.isDelete = generatedChartEntity.getIsDelete();
        this.createTime = generatedChartEntity.getCreateTime();
        this.updateTime = generatedChartEntity.getUpdateTime();

        ObjectMapper objectMapper = new ObjectMapper();
        Object option = null;
        try {
            option = objectMapper.readValue(generatedChartEntity.getConfig(), Object.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        this.option = option;
    }


}

package io.renren.modules.home.entity.dto;

import lombok.Data;

@Data
public class TutorialSaveDTO {
    private String title;
    private String content;
    private Integer step;
    private String url;
}

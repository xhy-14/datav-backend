package io.renren.modules.home.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.home.entity.TutorialEntity;
import io.renren.modules.home.entity.dto.TutorialSaveDTO;

import java.util.Map;

/**
 * 教程表
 *
 * @author xie
 * @email sunlightcs@gmail.com
 * @date 2024-01-03 11:43:50
 */
public interface TutorialService extends IService<TutorialEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Boolean tutorialSave(TutorialSaveDTO tutorialSaveDTO);
}


package io.renren.modules.app.service.impl.data;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.modules.app.dto.GeneratedParameterDTO;
import io.renren.modules.app.service.data.GeneratedChartService;
import io.renren.modules.app.service.data.GeneratedParameterService;
import io.renren.modules.table.dao.GeneratedChartParameterRelationDao;
import io.renren.modules.table.entity.GeneratedChartParameterRelationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GeneratedParameterServiceImpl extends ServiceImpl<GeneratedChartParameterRelationDao, GeneratedChartParameterRelationEntity> implements GeneratedParameterService {

    @Autowired
    private GeneratedChartService generatedChartService;

    @Override
    public Boolean saveGeneratedParameters(List<GeneratedParameterDTO> parameters, Long generatedChartId) {

        if (!generatedChartService.existsChartId(generatedChartId)) {
            throw new RRException("不存在的已生成图表ID");
        }

        for (GeneratedParameterDTO p :parameters) {

            GeneratedChartParameterRelationEntity generatedChartParameterRelationEntity = new GeneratedChartParameterRelationEntity();
            generatedChartParameterRelationEntity.setGeneratedChartId(generatedChartId);
            generatedChartParameterRelationEntity.setParameterId(p.getParameterId());
            generatedChartParameterRelationEntity.setContent(p.getContent());
            generatedChartParameterRelationEntity.setIsDelete(0);
            generatedChartParameterRelationEntity.setCreateTime(new Date());
            generatedChartParameterRelationEntity.setUpdateTime(new Date());

            this.save(generatedChartParameterRelationEntity);

        }

        return true;
    }
}

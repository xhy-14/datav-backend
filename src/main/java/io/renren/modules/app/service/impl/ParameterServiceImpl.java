package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.R;
import io.renren.modules.app.service.ParameterChartTypeRelationService;
import io.renren.modules.app.service.ParameterService;
import io.renren.modules.app.service.chart.ParameterTypeService;
import io.renren.modules.app.vo.ParameterVO;
import io.renren.modules.chart.dao.ParameterDao;
import io.renren.modules.chart.entity.ParameterChartTypeRelationEntity;
import io.renren.modules.chart.entity.ParameterEntity;
import io.renren.modules.chart.entity.ParameterTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ParameterServiceImpl extends ServiceImpl<ParameterDao, ParameterEntity> implements ParameterService {

    @Autowired
    private ParameterChartTypeRelationService parameterChartTypeRelationService;

    @Autowired
    private ParameterTypeService parameterTypeService;

    /**
     * 根据chart_type获取参数
     * @return R
     */
    @Override
    public R getParametersByChartType(Long chartTypeId) {

        //用模板id查询所有关联
        List<ParameterChartTypeRelationEntity> relationEntities = parameterChartTypeRelationService.getListByChartTypeId(chartTypeId);

        //查询所有参数实体
        List<ParameterEntity> parameterEntityList = new ArrayList<>();

        for (ParameterChartTypeRelationEntity p : relationEntities) {
            Long parameterId = p.getParameterId();
            QueryWrapper<ParameterEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", parameterId);
            parameterEntityList.add(baseMapper.selectOne(queryWrapper));
        }

        //生成vo类list
        List<ParameterVO> parameterVOList = new ArrayList<>();

        for (ParameterEntity p : parameterEntityList) {
            ParameterVO parameterVO = new ParameterVO();
            parameterVO.setId(p.getId());
            parameterVO.setName(p.getParameterName());
            parameterVOList.add(parameterVO);

            ParameterTypeEntity parameterTypeEntity = parameterTypeService.getEntityByTypeId(p.getParameterTypeId());
            //此处typeId和typeName是参数的类型
            parameterVO.setTypeId(parameterTypeEntity.getId());
            parameterVO.setTypeName(parameterTypeEntity.getTypeName());
            parameterVO.setAnalyse(parameterTypeEntity.getAnalyse());

            ParameterChartTypeRelationEntity entityByRelation = parameterChartTypeRelationService.getEntityByRelation(parameterVO.getId(), chartTypeId);
            System.out.println(parameterVO.getId());
            System.out.println(parameterVO.getTypeId());
            parameterVO.setDefaultValue(entityByRelation.getDefaultValue());
        }

        return R.success(parameterVOList);
    }

}

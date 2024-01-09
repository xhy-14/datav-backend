package io.renren.modules.app.service.impl.data;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveGeneratedChartDTO;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.service.data.GeneratedChartService;
import io.renren.modules.table.dao.GeneratedChartDao;
import io.renren.modules.table.entity.GeneratedChartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class GeneratedChartServiceImpl extends ServiceImpl<GeneratedChartDao, GeneratedChartEntity> implements GeneratedChartService {

    @Autowired
    private UserService userService;

    @Override
    public R saveGeneratedChart(HttpServletRequest request, SaveGeneratedChartDTO dto) {

        GeneratedChartEntity generatedChartEntity = new GeneratedChartEntity();

        //用户id，此处预留
        generatedChartEntity.setUserId(userService.currentUser(request).getUserId());

        generatedChartEntity.setIsDelete(0);
        generatedChartEntity.setCreateTime(new Date());
        generatedChartEntity.setUpdateTime(new Date());

        generatedChartEntity.setName(dto.getName());
        generatedChartEntity.setChartTypeId(dto.getChartTypeId());
        generatedChartEntity.setDepiction(dto.getDepicition());
        generatedChartEntity.setMetadataId(dto.getMetadataId());

        this.save(generatedChartEntity);

        return R.success(generatedChartEntity);
    }

    @Override
    public Boolean existsChartId(Long chartId) {

        GeneratedChartEntity generatedChartEntity = baseMapper.selectById(chartId);
        return generatedChartEntity != null;

    }
}

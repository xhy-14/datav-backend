package io.renren.modules.app.service.impl.data;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveGeneratedChartDTO;
import io.renren.modules.app.dto.UpdateGeneratedChartDTO;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.service.data.GeneratedChartService;
import io.renren.modules.table.dao.GeneratedChartDao;
import io.renren.modules.table.entity.GeneratedChartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class GeneratedChartServiceImpl extends ServiceImpl<GeneratedChartDao, GeneratedChartEntity> implements GeneratedChartService {

    @Autowired
    private UserService userService;

    @Override
    public R saveGeneratedChart(HttpServletRequest request, SaveGeneratedChartDTO saveGeneratedChartDTO) {

        UserEntity userEntity = userService.currentUser(request);
        GeneratedChartEntity generatedChartEntity = new GeneratedChartEntity();
        generatedChartEntity.setUserId(userEntity.getUserId());
        generatedChartEntity.setChartTypeId(saveGeneratedChartDTO.getChartTypeId());
        generatedChartEntity.setMetadataId(saveGeneratedChartDTO.getMetadataId());
        generatedChartEntity.setName(saveGeneratedChartDTO.getName());
        generatedChartEntity.setDepiction(saveGeneratedChartDTO.getDepicition());
        generatedChartEntity.setIsDelete(0);
        generatedChartEntity.setUpdateTime(new Date());
        generatedChartEntity.setCreateTime(new Date());

        try {
            save(generatedChartEntity);
        } catch (Exception e) {
            throw new RRException("数据库错误");
        }

        return R.success(generatedChartEntity);
    }

    @Override
    public R deleteGeneratedChart(HttpServletRequest request, Long generatedChartId) {

        UserEntity userEntity = userService.currentUser(request);

        GeneratedChartEntity generatedChartEntity = baseMapper.selectById(generatedChartId);

        if (!userEntity.getUserId().equals(generatedChartEntity.getUserId())) {
            throw new RRException("权限不足");
        }

        try {
            baseMapper.deleteById(generatedChartId);
        } catch (Exception e) {
            throw new RRException("数据库错误");
        }

        return R.success();
    }

    @Override
    public R updateGeneratedChart(HttpServletRequest request, UpdateGeneratedChartDTO updateGeneratedChartDTO) {
        UserEntity userEntity = userService.currentUser(request);

        GeneratedChartEntity generatedChartEntity = baseMapper.selectById(updateGeneratedChartDTO.getGeneratedChartId());

        if (!userEntity.getUserId().equals(generatedChartEntity.getUserId())) {
            throw new RRException("权限不足");
        }

        generatedChartEntity.setChartTypeId(updateGeneratedChartDTO.getChartTypeId());
        generatedChartEntity.setMetadataId(updateGeneratedChartDTO.getMetadataId());
        generatedChartEntity.setName(updateGeneratedChartDTO.getName());
        generatedChartEntity.setDepiction(updateGeneratedChartDTO.getDepicition());
        generatedChartEntity.setUpdateTime(new Date());

        try {
            baseMapper.updateById(generatedChartEntity);
        } catch (Exception e) {
            throw new RRException("数据库错误");
        }

        return R.success(generatedChartEntity);
    }

    @Override
    public R listMyGeneratedChart(HttpServletRequest request) {

        UserEntity userEntity = userService.currentUser(request);
        Long userId = userEntity.getUserId();
        QueryWrapper<GeneratedChartEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<GeneratedChartEntity> generatedChartEntities = null;
        try {
            generatedChartEntities = baseMapper.selectList(queryWrapper);
        } catch (Exception e) {
            throw new RRException("数据库错误");
        }

        return R.success(generatedChartEntities);
    }
}

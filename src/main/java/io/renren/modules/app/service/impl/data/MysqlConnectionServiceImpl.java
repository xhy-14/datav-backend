package io.renren.modules.app.service.impl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveMysqlConnectionDTO;
import io.renren.modules.app.dto.UpdateMysqlConnectionDTO;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.service.data.MysqlConnectionService;
import io.renren.modules.table.dao.MysqlConnectionDao;
import io.renren.modules.table.entity.MysqlConnectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class MysqlConnectionServiceImpl extends ServiceImpl<MysqlConnectionDao, MysqlConnectionEntity> implements MysqlConnectionService {

    @Autowired
    private UserService userService;

    @Override
    public R saveMysqlConnection(HttpServletRequest request, SaveMysqlConnectionDTO saveMysqlConnectionDTO) {

        UserEntity userEntity = userService.currentUser(request);

        MysqlConnectionEntity mysqlConnectionEntity = new MysqlConnectionEntity();
        mysqlConnectionEntity.setUserId(userEntity.getUserId());
        mysqlConnectionEntity.setUserName(userEntity.getUsername());
        mysqlConnectionEntity.setHost(saveMysqlConnectionDTO.getHost());
        mysqlConnectionEntity.setPort(saveMysqlConnectionDTO.getPort());
        mysqlConnectionEntity.setPassword(saveMysqlConnectionDTO.getPassword());
        mysqlConnectionEntity.setDatabaseName(saveMysqlConnectionDTO.getDatabaseName());
        mysqlConnectionEntity.setIsDelete(0);
        mysqlConnectionEntity.setCreateTime(new Date());
        mysqlConnectionEntity.setUpdateTime(new Date());

        try {
            save(mysqlConnectionEntity);
        } catch (Exception e) {
            throw new RRException("数据库插入错误，请检查参数");
        }
        mysqlConnectionEntity.setPassword("******");
        return R.success(mysqlConnectionEntity);
    }

    @Override
    public R deleteMysqlConnection(HttpServletRequest request, Long mysqlConnectionId) {

        UserEntity userEntity = userService.currentUser(request);

        MysqlConnectionEntity mysqlConnectionEntity = baseMapper.selectById(mysqlConnectionId);

        if (!mysqlConnectionEntity.getUserId().equals(userEntity.getUserId())) {
            throw new RRException("权限不足");
        }

        try {
            baseMapper.deleteById(mysqlConnectionId);
        } catch (Exception e) {
            throw new RRException("数据库错误");
        }

        return R.success();
    }

    @Override
    public R updateMysqlConnection(HttpServletRequest request, UpdateMysqlConnectionDTO updateMysqlConnectionDTO) {

        UserEntity userEntity = userService.currentUser(request);

        MysqlConnectionEntity mysqlConnectionEntity = baseMapper.selectById(updateMysqlConnectionDTO.getMysqlConnectionId());
        if (mysqlConnectionEntity == null) {
            throw new RRException("数据库连接不存在");
        }

        if (!mysqlConnectionEntity.getUserId().equals(userEntity.getUserId())) {
            throw new RRException("权限不足");
        }

        mysqlConnectionEntity.setUserId(userEntity.getUserId());
        mysqlConnectionEntity.setUserName(userEntity.getUsername());
        mysqlConnectionEntity.setHost(updateMysqlConnectionDTO.getHost());
        mysqlConnectionEntity.setPort(updateMysqlConnectionDTO.getPort());
        mysqlConnectionEntity.setPassword(updateMysqlConnectionDTO.getPassword());
        mysqlConnectionEntity.setDatabaseName(updateMysqlConnectionDTO.getDatabaseName());
        mysqlConnectionEntity.setIsDelete(0);
        mysqlConnectionEntity.setCreateTime(new Date());
        mysqlConnectionEntity.setUpdateTime(new Date());

        try {
            baseMapper.updateById(mysqlConnectionEntity);
        } catch (Exception e) {
            throw new RRException("数据库错误");
        }

        return R.success();
    }

    @Override
    public R listMysqlConnection(HttpServletRequest request) {

        UserEntity userEntity = userService.currentUser(request);
        Long userId = userEntity.getUserId();

        QueryWrapper<MysqlConnectionEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        List<MysqlConnectionEntity> mysqlConnectionEntities = baseMapper.selectList(queryWrapper);

        return R.success(mysqlConnectionEntities);
    }
}

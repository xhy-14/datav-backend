package io.renren.modules.app.service.impl.file;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.ResponseCode.FileCode;
import io.renren.modules.app.dto.ProjectDTO;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.service.file.ProjectService;
import io.renren.modules.file.dao.ProjectDao;
import io.renren.modules.file.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, ProjectEntity> implements ProjectService {

    @Autowired
    private UserService userService;


    @Override
    public R saveProject(HttpServletRequest request, ProjectDTO projectDTO) {

        ProjectEntity projectEntity = new ProjectEntity();

        UserEntity userEntity = userService.currentUser(request);
        projectEntity.setUserId(userEntity.getUserId());
        if (projectDTO.getName() == null) {
            return R.fail(FileCode.PROJECT_NAME_NULL.getCode(),
                    FileCode.PROJECT_NAME_NULL.getMsg());
        }
        projectEntity.setName(projectDTO.getName());
        projectEntity.setDepiction(projectDTO.getDepicition());
        projectEntity.setIsDelete(0);
        projectEntity.setCreateTime(new Date());
        projectEntity.setUpdateTime(new Date());

        boolean saved = this.save(projectEntity);
        if (saved) {
            return R.ok();
        } else {
            return R.fail(FileCode.MYSQL_ERROR.getCode(),
                    FileCode.MYSQL_ERROR.getMsg());
        }


    }

    @Override
    public R deleteProject(HttpServletRequest request, Long projectId) {

        UserEntity userEntity = userService.currentUser(request);

        ProjectEntity projectEntity = baseMapper.selectById(projectId);

        if (projectEntity == null) {
            throw new RRException("该文件夹不存在");
        }

        if (projectEntity.getUserId().equals(userEntity.getUserId())) {
            baseMapper.deleteById(projectEntity.getId());
        } else {
            throw new RRException("权限不足");
        }

        return R.ok();
    }

    @Override
    public R updateProject(HttpServletRequest request, ProjectDTO projectDTO) {

        UserEntity userEntity = userService.currentUser(request);

        if (projectDTO.getProjectId() == null) {
            throw new RRException("项目id不能为空");
        }

        ProjectEntity projectEntity = baseMapper.selectById(projectDTO.getProjectId());

        if (!userEntity.getUserId().equals(projectEntity.getUserId())) {
            throw new RRException("权限不足");
        }

        projectEntity.setName(projectDTO.getName());
        projectEntity.setDepiction(projectDTO.getDepicition());
        projectEntity.setUpdateTime(new Date());

        boolean updated = this.updateById(projectEntity);
        if (updated) {
            return R.ok();
        } else {
            throw new RRException("数据库错误");
        }
    }

    @Override
    public R getProjectList(HttpServletRequest request) {

        UserEntity userEntity = userService.currentUser(request);

        QueryWrapper<ProjectEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userEntity.getUserId());

        List<ProjectEntity> projectEntities = baseMapper.selectList(queryWrapper);

        return R.success(projectEntities);
    }
}

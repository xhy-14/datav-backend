package io.renren.modules.app.service.file;

import io.renren.common.utils.R;
import io.renren.modules.app.dto.ProjectDTO;

import javax.servlet.http.HttpServletRequest;

public interface ProjectService {

    /**
     * 创建项目（文件）
     * @param request
     * @param projectDTO
     * @return
     */
    R saveProject(HttpServletRequest request, ProjectDTO projectDTO);

    /**
     * 删除文件夹
     * @param request
     * @param projectId
     * @return
     */
    R deleteProject(HttpServletRequest request, Long projectId);

    /**
     * 修改文件夹信息
     * @param request
     * @param projectDTO
     * @return
     */
    R updateProject(HttpServletRequest request, ProjectDTO projectDTO);
    /**
     * 查询用户文件夹
     * @param request
     * @return
     */
    R getProjectList(HttpServletRequest request);

}

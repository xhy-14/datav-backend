package io.renren.modules.app.controller.file;


import io.renren.common.utils.R;
import io.renren.modules.app.dto.ProjectDTO;
import io.renren.modules.app.service.file.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/common/file")
@Api(tags = "文件项目（文件夹）", description = "文件夹")
public class AppProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/save_project")
    @ApiOperation("保存文件夹(创建项目)")
    public R saveProject(HttpServletRequest request,
                         @RequestBody ProjectDTO projectDTO) {
        return projectService.saveProject(request, projectDTO);
    }

    @GetMapping("/delete_project")
    @ApiOperation("删除文件夹")
    public R deleteProject(HttpServletRequest request,
                           @ApiParam(value = "文件夹id", name = "projectId", required = true)
                           @RequestParam("projectId") Long projectId) {
        return projectService.deleteProject(request, projectId);
    }

    @PostMapping("/update_project")
    @ApiOperation("修改文件夹信息")
    public R updateProject(HttpServletRequest request, @RequestBody ProjectDTO projectDTO) {
        return projectService.updateProject(request, projectDTO);
    }

    @GetMapping("/my_project_list")
    @ApiOperation("获取我的文件夹列表")
    public R myProjectList(HttpServletRequest request) {
        return projectService.getProjectList(request);
    }


    @GetMapping("/get_files_by_project")
    @ApiOperation("获取某一文件夹的文件列表")
    public R getFilesByProject(HttpServletRequest request,
                               @ApiParam(value = "文件夹id", name = "projectId", required = true)
                               @RequestParam("projectId") Long projectId) {
        return projectService.getFilesByProject(request, projectId);
    }

}

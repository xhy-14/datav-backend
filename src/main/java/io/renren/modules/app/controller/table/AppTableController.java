/**
 * @author 谢寒应
 * @time 2024-1-9
 */

package io.renren.modules.app.controller.table;

import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.TableDto;
import io.renren.modules.app.dto.TableUpdateDTO;
import io.renren.modules.app.service.TableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/app/table")
@Api(tags = "数据模块", description = "数据信息")
public class AppTableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/info")
    @ApiOperation("获取数据表")
    public R getTableByID(@ApiParam(name = "id", required = true, type = "long")
                          @RequestParam("id") Long id) {
        if(id == null) {
            throw new RRException("缺少参数");
        }
        return tableService.getTableByID(id);
    }

    @GetMapping("/data/metadata/{id}")
    @ApiOperation("获取数据表数据")
    public R getTableDataByID(@ApiParam(name = "id", value = "数据表id",required = true, type = "long")
                              @PathVariable Long id) {
        return tableService.getTableDataByID(id);
    }

    @GetMapping("/data/file/{id}")
    @ApiOperation("已上传文件生成对应table")
    public R generateTableByFileID(@ApiParam(name = "id", value = "文件id",required = true, type = "long")
                               @PathVariable Long id){
        return tableService.generateTableByFileID(id);
    }

    @PostMapping("/data/file")
    @ApiOperation("上传文件生成对应table")
    public R generateTableByFile(@RequestParam("file")MultipartFile file) {
        return tableService.generateTableByFile(file);
    }

    @PostMapping("/data/save")
    @ApiOperation("选择对应字段后保存在系统中")
    public R saveTable(@ApiParam(value = "数据表", required = true, type = "TableDto")
                       @RequestBody TableDto tableDto,
                       HttpServletRequest httpServletRequest) {
        return tableService.saveTable(tableDto, httpServletRequest);
    }

    @PostMapping("/data/update")
    @ApiOperation("修改数据集")
    public R updateTable(@ApiParam(value = "数据表", required = true, type = "TableUpdateDTO")
                         @RequestBody TableUpdateDTO tableUpdateDTO) {
        return tableService.updateTable(tableUpdateDTO);
    }

    @GetMapping("/data/my")
    @ApiOperation("获取我的所有数据集")
    public R datasetList(HttpServletRequest httpServletRequest) {
        return tableService.datasetList(httpServletRequest);
    }
}

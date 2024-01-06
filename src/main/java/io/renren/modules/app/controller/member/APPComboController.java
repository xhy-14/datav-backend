package io.renren.modules.app.controller.member;

import io.renren.common.utils.R;
import io.renren.modules.app.service.ComboService;
import io.renren.modules.app.vo.ComboInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member/combo")
@Api(tags = "套餐模块", description = "套餐")
public class APPComboController {

    @Autowired
    private ComboService comboService;

    @GetMapping("/list")
    @ApiOperation("获取套餐列表")
    public R getComboList() {
        List<ComboInfoVo> comboList = comboService.getComboList();
        return R.ok().put("comboList", comboList);
    }

}

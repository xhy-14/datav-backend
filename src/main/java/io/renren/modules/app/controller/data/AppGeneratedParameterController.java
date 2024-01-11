package io.renren.modules.app.controller.data;


import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.ResponseCode.GeneratedParameterCode;
import io.renren.modules.app.dto.GeneratedParameterDTO;
import io.renren.modules.app.service.data.GeneratedParameterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common/generated_parameter")
@Api(tags = "已生成参数", description = "已生成参数")
public class AppGeneratedParameterController {

    @Autowired
    private GeneratedParameterService generatedParameterService;


}

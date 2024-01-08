package io.renren.modules.app.controller.user;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/app/user")
@Api(tags = "用户模块", description = "用户信息")
public class AppUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/info")
    @ApiOperation("用户信息")
    public R currentUserInfo(HttpServletRequest httpServletRequest) {
        UserEntity userEntity = userService.currentUser(httpServletRequest);
        UserVo userVo = new UserVo();
        userVo.setName(userEntity.getUsername());
        userVo.setMobile(userEntity.getMobile());
        return R.success(userVo);
    }
}

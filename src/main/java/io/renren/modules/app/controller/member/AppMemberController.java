package io.renren.modules.app.controller.member;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.MemberService;
import io.renren.modules.app.service.UserService;
import io.renren.modules.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/member/member")
@Api(tags = "会员模块", description = "会员")
public class AppMemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserService userService;

    @GetMapping("/memberidentify")
    @ApiOperation("查询当前用户是否会员")
    public R memberIdentify(HttpServletRequest request) {
        UserEntity userEntity = userService.currentUser(request);
        Boolean isMember = memberService.memberIdentify(userEntity.getUserId());
        return R.success();
    }

}

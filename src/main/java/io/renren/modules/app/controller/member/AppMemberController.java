package io.renren.modules.app.controller.member;

import io.renren.common.utils.R;
import io.renren.modules.app.service.MemberService;
import io.renren.modules.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/member")
@Api(tags = "会员模块", description = "会员")
public class AppMemberController extends AbstractController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/memberidentify")
    @ApiOperation("查询当前用户是否会员")
    public R memberIdentify() {
        Long userId = getUserId();
        Boolean isMember = memberService.memberIdentify(userId);
        return R.ok().put("isMember", isMember);
    }

}

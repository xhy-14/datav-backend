/**
 *
 * @author xhy
 * @time 2024-1-6
 *
 */
package io.renren.modules.app.ResponseCode;

import java.util.HashMap;
import java.util.Map;

public enum UserResponseCode {
    USER_RESPONSE_ERROR("A0210", "用户密码错误"),
    USER_NOT_EXISTS("A0201", "用户账户不存在"),
    PASSWORD_ERROR("A0120", "密码必须在8-16位之间"),
    MOBILE_ERROR("A0151", "手机格式校验失败"),
    USER_EXISTS("A0111", "手机号已被注册"),
    USER_REGISTER_ERROR("A0100", "用户注册失败");

    private String code;
    private String msg;

    UserResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

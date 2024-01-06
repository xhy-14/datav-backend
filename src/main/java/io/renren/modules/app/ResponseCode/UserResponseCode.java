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

    public Map<String, String> codeMap() {
        Map<String, String> map = new HashMap<>();
        map.put();
        map.put();
        return this.
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

package io.renren.modules.app.ResponseCode;

public enum UserResponseCode {
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

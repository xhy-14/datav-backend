package io.renren.modules.app.ResponseCode;

public enum  SuccessResponseCode {
    REQUEST_SUCCESS("00000", "请求成功");

    private String code;
    private String msg;

    SuccessResponseCode(String code, String msg) {
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

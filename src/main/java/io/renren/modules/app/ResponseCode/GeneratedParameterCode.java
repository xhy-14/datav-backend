package io.renren.modules.app.ResponseCode;

public enum GeneratedParameterCode {

    MYSQL_ERROR("C0300", "数据库服务出错");

    private String code;
    private String msg;

    GeneratedParameterCode(String code, String msg) {
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

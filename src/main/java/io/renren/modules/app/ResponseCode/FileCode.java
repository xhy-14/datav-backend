package io.renren.modules.app.ResponseCode;

public enum FileCode {

    MYSQL_ERROR("C0300", "数据库服务出错"),
    PROJECT_NAME_NULL("C0300", "文件夹名称不能为空");

    private String code;
    private String msg;

    FileCode(String code, String msg) {
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

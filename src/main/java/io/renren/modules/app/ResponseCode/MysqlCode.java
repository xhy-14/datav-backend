package io.renren.modules.app.ResponseCode;

/**
 * @author xiehanying
 */
public enum  MysqlCode {
    TEST_FAIL("FFFFF", "连接失败");

    private String code;
    private String msg;

    MysqlCode(String code, String msg) {
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

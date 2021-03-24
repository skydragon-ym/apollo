package com.skydragon.common.constant;

@SuppressWarnings("all")
public enum CommonStatusEnum {

    /*短信验证码服务 */
    VERIFICATION_CODE_ERROR(10002, "短息验证码验证失败"),
    VERIFICATION_ONE_MIN_ERROR(10003, "您同一个错误验证码点击登录的次数过多，请1分钟之后再重试"),
    VERIFICATION_TEN_MIN_ERROR(10004, "您登录失败的次数过多，请10分钟后再重试"),

    /*系统错误*/
    INTERNAL_SERVER_EXCEPTION(-1, "exception"),

    /*操作成功*/
    SUCCESS(0, "success"),

    /*操作失败*/
    FAIL(1,"fail");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    int code;
    String description;

    private CommonStatusEnum(int code, String description){
        this.code = code;
        this.description = description;
    }

}

package com.silklee.common.enums;

public enum RedisHeaderEnum {

    /**
     * redis 头部枚举
     */
    SMS_REGISTOR("SMS_REGISTOR:", "短信注册"),
    SMS_PASSWORD("SMS_PASSWORD:", "短信修改密码"),
    TOKEN("TOKEN:", "token"),
    TOKEN_REFRESH("TOKEN_REFRESH:", "token刷新"),

    CLINIC_IM_USER("CLINIC_IM_USER:", "门诊IM导入用户"),
    CLINIC_CLOSE_ID("CLINIC_CLOSE_ID:", "门诊关闭问题id"),

    CLINIC_INNER_EXPORT_TEMP_REPLY("CLINIC_INNER_EXPORT_TEMP_REPLY:", "环保管家问诊回复草稿"),
    CLINIC_HOT_INQUIRY("CLINIC_HOT_INQUIRY:", "我的门诊热门"),
    CLINIC_TPLUSONE_JOB_IM_ID("CLINIC_TPLUSONE_JOB_IM_ID:", "T+1 job同步im消息到MongoDB"),
    CLINIC_USER_ROLE("CLINIC_USER_ROLE", "门诊用户角色"),

    ;

    private String code;
    private String desc;

    RedisHeaderEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static RedisHeaderEnum getByCode(String code) {
        RedisHeaderEnum[] values = values();
        for (RedisHeaderEnum sw : values) {
            if (sw.code.equals(code)) {
                return sw;
            }
        }
        return null;
    }


    public static Boolean checkCode(String code) {
        RedisHeaderEnum[] values = values();
        for (RedisHeaderEnum sw : values) {
            if (sw.code.equals(code)) {
                return true;
            }
        }
        return false;
    }
}

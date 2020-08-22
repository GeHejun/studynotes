package core;

public enum BizErrorE implements BizErrorI {
    ERROR_UNKNOWN("-1", "未知错误"),
    ERROR_SUCCESS("0", "成功"),
    ;
    private String code;
    private String desc;

    BizErrorE(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}

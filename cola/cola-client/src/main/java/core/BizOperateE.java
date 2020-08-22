package core;

public enum BizOperateE {
    BIZ_CONTINUE("continue", "继续"),
    BIZ_BREAK("break", "终止"),
    BIZ_ROLLBACK("rollback", "回滚"),
    ;

    private String code;
    private String desc;

    BizOperateE(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

package core;

import java.util.HashMap;

public class BizParam extends HashMap<String, Object> {
    private String bizType;

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}

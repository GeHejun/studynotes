package com.ghj.serializable;

import java.util.Map;

public class Simple {

    public Simple(String param1, Integer param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public Simple() {
    }

    private String param1;

    private Integer param2;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public Integer getParam2() {
        return param2;
    }

    public void setParam2(Integer param2) {
        this.param2 = param2;
    }

}

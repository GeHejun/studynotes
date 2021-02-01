package com.ghj.jsr269;

@Getter
public class JSRTest {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "JSRTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

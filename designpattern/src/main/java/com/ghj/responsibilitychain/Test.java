package com.ghj.responsibilitychain;

/**
 * @author gehj
 * @date 2019/6/2715:33
 */
public class Test {
    public static void main(String[] args) {
        Input input = new Input();
        input.setName("input start");
        input.setState(0);

        Output output = new Output();
        output.setName("output start");
        output.setState(0);

        ChainFilter chainFilter = new ChainFilter();
        ChainFilter chainFilter1 = chainFilter.addFilter(new FirstFilter()).addFilter(new SecondFilter());
        chainFilter1.doFilter(input, output, chainFilter1);

    }
}

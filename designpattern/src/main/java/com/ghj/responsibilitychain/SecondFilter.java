package com.ghj.responsibilitychain;

/**
 * @author gehj
 * @date 2019/6/2714:57
 */
public class SecondFilter implements Filter {
    @Override
    public void doFilter(Input input, Output output, ChainFilter filter) {
        input.setName(input.getName() + "-- in -- secondFilter");
        input.setState(input.getState() + 1);
        filter.doFilter(input, output, filter);
        output.setName(output.getName() + "-- in -- secondFilter");
        output.setState(output.getState() + 1);
    }
}

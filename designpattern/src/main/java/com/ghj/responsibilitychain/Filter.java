package com.ghj.responsibilitychain;

/**
 * @author gehj
 * @date 2019/6/2714:55
 */
public interface Filter {
    void doFilter(Input input, Output output, ChainFilter chainFilter);
}

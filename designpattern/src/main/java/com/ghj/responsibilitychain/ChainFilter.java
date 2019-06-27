package com.ghj.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gehj
 * @date 2019/6/2715:20
 */
public class ChainFilter implements Filter {

    int index = 0;

    List<Filter> filters = new ArrayList<>();

    public ChainFilter addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Input input, Output output, ChainFilter chainFilter) {
        //index初始化为0,filters.size()为3，不会执行return操作
        if (index == filters.size()) {
            return;
        }
        //每添加一个过滤规则，index自增1
        Filter f = filters.get(index);
        index++;
        //根据索引值获取对应的规律规则对字符串进行处理
        f.doFilter(input, output, chainFilter);
    }
}

package com.ghj.template;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gehj
 * @version 1.0
 * @description 处理结果集
 * @date 2019/8/7 10:08
 */
public interface RowMapper<T> {

    /**
     * 处理查询结果
     * @param resultSet
     * @return
     * @throws SQLException
     */
    T parseQueryResult(ResultSet resultSet) throws SQLException;
}

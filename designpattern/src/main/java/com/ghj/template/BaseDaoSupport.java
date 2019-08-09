package com.ghj.template;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author gehj
 * @version 1.0
 * @description dao基类
 * @date 2019/8/7 10:14
 */
public class BaseDaoSupport<T> {

    DataSource dataSource = null;

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    RowMapper rowMapper = (rs) -> {
        ResultSetMetaData rsMetaData = rs.getMetaData();
        for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
            switch (rsMetaData.getColumnType(i)) {
                case Types.ARRAY:
                    Array array = rs.getArray(i);
                    break;
                case Types.BIGINT:
                    long resultLong = rs.getLong(i);
                    break;

            }
        }
        return null;
    };

    public void executeQuery(String querySql) throws SQLException {
        jdbcTemplate.executeQuery("", rowMapper);
    }
}

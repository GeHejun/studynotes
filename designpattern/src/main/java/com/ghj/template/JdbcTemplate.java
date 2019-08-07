package com.ghj.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gehj
 * @version 1.0
 * @description 模板模式  -- jdbcTemplate
 * @date 2019/8/7 9:48
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps;
    }

    public List<Object> processResult(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        List<Object> objects = new ArrayList<>(16);
        while (resultSet.next()) {
            Object object = rowMapper.parseQueryResult(resultSet);
            objects.add(object);
        }
        return objects;

    }

    /**
     * 执行查询
     * @return
     */
    public List<Object> executeQuery(String sql, RowMapper rowMapper) throws SQLException {
        //1.获取连接
        Connection connection = this.getConnection(dataSource);
        //2.创建PreparedStatement
        PreparedStatement ps = this.createPreparedStatement(connection, sql);
        //3.执行查询
        ResultSet resultSet = ps.executeQuery();
        //4.处理结果集
        List<Object> objects = this.processResult(resultSet, rowMapper);
        //5.返回结果
        return objects;
    }
}

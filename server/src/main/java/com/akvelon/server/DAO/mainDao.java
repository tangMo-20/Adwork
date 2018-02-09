package com.akvelon.server.DAO;

import com.akvelon.server.DAO.API.dao;
import com.akvelon.server.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public abstract class mainDao<V extends Entity<Integer>> implements dao<Integer, V> {
    private V obj;

    @Autowired
    protected JdbcTemplate jdbcTemplate;
    private static final String SQL_GET_BY = "SELECT * FROM %s WHERE %s = ?";

    public mainDao(V obj) {
        this.obj = obj;
    }

    @Override
    public Integer addNewProduct(V value) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((con) -> createInsertStatement(con, value), keyHolder);
        int id = keyHolder.getKey().intValue();
        value.setId(id);
        return id;
    }

    @Override
    public String deleteItem(String itemNumber) {
        String SQL_DELETE = "DELETE FROM product WHERE ProductNumber = %s";
        String sql = String.format(SQL_DELETE, itemNumber);
        jdbcTemplate.update(sql);
        return "Done";
    }

    @Override
    public V read(Integer key) {
        return readBy(obj.getClass().getSimpleName() + "ID", key);
    }

    @Override
    public <T> V readBy(String fieldName, T value) {
        List<V> result = readAllBy(fieldName, value);
        if (result == null) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public <T> List<V> readAllBy(String fieldName, T value) {
        String sql = String.format(SQL_GET_BY, obj.getClass().getSimpleName().toLowerCase(), fieldName);
        return jdbcTemplate.query(sql, new Object[]{value}, getRowMapper());
    }

    protected abstract RowMapper getRowMapper();
    protected abstract PreparedStatement createInsertStatement(Connection connection, V value) throws SQLException;
}

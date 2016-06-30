package com.epam.training.spring.core.practical.dao.impl.mappers;

import com.epam.training.spring.core.practical.basic.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        Date date = java.sql.Date.valueOf(resultSet.getDate("birthday").toLocalDate());
        User user = new User(resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("email"),
            date);
        user.setRegistered(resultSet.getBoolean("isRegistered"));
        return user;
    }
}

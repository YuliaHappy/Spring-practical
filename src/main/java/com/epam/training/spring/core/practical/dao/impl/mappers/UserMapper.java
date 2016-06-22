package com.epam.training.spring.core.practical.dao.impl.mappers;

import com.epam.training.spring.core.practical.basic.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            Date date = df.parse(resultSet.getString("birthday"));
            User user = new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    date);
            user.setRegistered(resultSet.getBoolean("isRegistered"));
            return user;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

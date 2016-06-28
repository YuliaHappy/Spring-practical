package com.epam.training.spring.core.practical.dao.impl.mappers;

import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.basic.Rating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Event(
                resultSet.getString("name"),
                resultSet.getTimestamp("datetime").toLocalDateTime(),
                resultSet.getString("rating"),
                resultSet.getInt("basePrice"),
                resultSet.getInt("vipPrice"));

    }
}

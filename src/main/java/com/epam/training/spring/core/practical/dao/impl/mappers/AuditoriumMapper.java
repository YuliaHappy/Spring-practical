package com.epam.training.spring.core.practical.dao.impl.mappers;

import com.epam.training.spring.core.practical.basic.Auditorium;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditoriumMapper implements RowMapper<Auditorium> {
    @Override
    public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Auditorium(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("countOfSeats"));

    }
}
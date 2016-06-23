package com.epam.training.spring.core.practical.dao.impl.mappers;

import com.epam.training.spring.core.practical.basic.VipSeat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VipSeatsMapper implements RowMapper<VipSeat> {
    @Override
    public VipSeat mapRow(ResultSet resultSet, int i) throws SQLException {
        return new VipSeat(
                resultSet.getInt("id"),
                resultSet.getInt("idAuditorium"),
                resultSet.getInt("numberSeat"));
    }
}

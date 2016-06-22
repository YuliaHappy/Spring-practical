package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.dao.impl.mappers.AuditoriumMapper;
import com.epam.training.spring.core.practical.dao.interfaces.AuditoriumDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Set;

public class DatabaseAuditoriumDaoImpl implements AuditoriumDao{
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void add(Auditorium auditorium) {
        jdbcTemplate.update("INSERT INTO bookingservice.auditorium VALUES (?, ?, ?)",
                null,
                auditorium.getName(),
                auditorium.getCountOfSeats());
        auditorium.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium " +
                        "WHERE name = ?",
                new Object[] {auditorium.getName()},
                new AuditoriumMapper()).getId());
        //TODO add vip-seats
    }

    @Override
    public void remove(Auditorium auditorium) {

    }

    @Override
    public Auditorium getById(int id) {
        return null;
    }

    @Override
    public Set<Integer> getSeatsNumber(Auditorium auditorium) {
        return null;
    }

    @Override
    public Set<Integer> getVipSeats(Auditorium auditorium) {
        return null;
    }

    @Override
    public List<Auditorium> getAll() {
        return null;
    }
}

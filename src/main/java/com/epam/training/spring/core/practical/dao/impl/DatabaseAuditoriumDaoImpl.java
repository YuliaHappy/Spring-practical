package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.basic.VipSeat;
import com.epam.training.spring.core.practical.dao.impl.mappers.AuditoriumMapper;
import com.epam.training.spring.core.practical.dao.impl.mappers.VipSeatsMapper;
import com.epam.training.spring.core.practical.dao.interfaces.AuditoriumDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatabaseAuditoriumDaoImpl implements AuditoriumDao{
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Auditorium auditorium) {
        jdbcTemplate.update("INSERT INTO bookingservice.auditorium (name, countofseats) VALUES (?, ?)",
                auditorium.getName(),
                auditorium.getCountOfSeats());
        auditorium.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium " +
                        "WHERE name = ?",
                new Object[] {auditorium.getName()},
                new AuditoriumMapper()).getId());
        for (VipSeat vipSeat :
                auditorium.getVipSeats()) {
            jdbcTemplate.update("INSERT INTO bookingservice.vipseats (idauditorium, numberseat) VALUES(?, ?)",
                    vipSeat.getIdAuditorium(),
                    vipSeat.getNumberSeat());
            vipSeat.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.vipseats " +
                            "WHERE idauditorium = ? and numberseat = ?",
                    new Object[] {vipSeat.getIdAuditorium(), vipSeat.getNumberSeat()},
                    new VipSeatsMapper()).getId());
        }
    }

    @Override
    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM bookingservice.auditorium " +
                        "WHERE id = ?",
                id);
    }

    @Override
    public Auditorium getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium " +
                        "WHERE id = ?",
                new Object[] {id},
                new AuditoriumMapper());
    }

    @Override
    public Set<Integer> getSeatsNumber(Auditorium auditorium) {
        int countOfSeats = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium " +
                        "WHERE id = ?",
                new Object[] {auditorium.getId()},
                new AuditoriumMapper()).getCountOfSeats();
        return IntStream.range(1, countOfSeats + 1).boxed()
                .collect(Collectors.toSet());
    }

    @Override
    public Set<VipSeat> getVipSeats(Auditorium auditorium) {
        return new HashSet<>(jdbcTemplate.query("SELECT * FROM bookingservice.vipSeats " +
                        "WHERE idAuditorium = ?",
                new Object[] {auditorium.getId()},
                new VipSeatsMapper()));
    }

    @Override
    public List<Auditorium> getAll() {
        return jdbcTemplate.query("SELECT * FROM bookingservice.auditorium ",
                new AuditoriumMapper());
    }
}

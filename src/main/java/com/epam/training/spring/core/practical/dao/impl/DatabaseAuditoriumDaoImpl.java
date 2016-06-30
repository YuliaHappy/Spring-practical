package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.basic.VipSeat;
import com.epam.training.spring.core.practical.dao.impl.mappers.AuditoriumMapper;
import com.epam.training.spring.core.practical.dao.impl.mappers.VipSeatsMapper;
import com.epam.training.spring.core.practical.dao.interfaces.AuditoriumDao;
import org.postgresql.core.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatabaseAuditoriumDaoImpl implements AuditoriumDao{
    private JdbcTemplate jdbcTemplate;
    private Logger logger = new Logger();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Auditorium auditorium) {
        try {
            jdbcTemplate.update("INSERT INTO bookingservice.auditorium (name, countofseats) VALUES (?, ?)",
                    auditorium.getName(),
                    auditorium.getCountOfSeats());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        int idAuditorium = -1;
        try {
            idAuditorium = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium " +
                            "WHERE name = ?",
                    new Object[] {auditorium.getName()},
                    new AuditoriumMapper()).getId();
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        auditorium.setId(idAuditorium);
        for (VipSeat vipSeat :
                auditorium.getVipSeats()) {
            try {
                jdbcTemplate.update("INSERT INTO bookingservice.vipseats (idauditorium, numberseat) VALUES(?, ?)",
                        vipSeat.getIdAuditorium(),
                        vipSeat.getNumberSeat());
            } catch (DataAccessException e) {
                logger.debug(e.getMessage(), e.fillInStackTrace());
            }
            int idVipSeat = -1;
            try {
                idVipSeat = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.vipseats " +
                                "WHERE idauditorium = ? and numberseat = ?",
                        new Object[] {vipSeat.getIdAuditorium(), vipSeat.getNumberSeat()},
                        new VipSeatsMapper()).getId();
            } catch (DataAccessException e) {
                logger.debug(e.getMessage(), e.fillInStackTrace());
            }
            vipSeat.setId(idVipSeat);
        }
    }

    @Override
    public void remove(int id) {
        try {
            jdbcTemplate.update("DELETE FROM bookingservice.auditorium " +
                            "WHERE id = ?",
                    id);
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public Auditorium getById(int id) {
        Auditorium auditorium = null;
        try {
            auditorium = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium " +
                            "WHERE id = ?",
                    new Object[] {id},
                    new AuditoriumMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return auditorium;
    }

    @Override
    public Set<Integer> getSeatsNumber(Auditorium auditorium) {
        int countOfSeats = 0;
        try {
            countOfSeats = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium " +
                            "WHERE id = ?",
                    new Object[] {auditorium.getId()},
                    new AuditoriumMapper()).getCountOfSeats();
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return IntStream.range(1, countOfSeats + 1).boxed()
                .collect(Collectors.toSet());
    }

    @Override
    public Set<VipSeat> getVipSeats(Auditorium auditorium) {
        Set<VipSeat> vipSeats = null;
        try {
            vipSeats = new HashSet<>(jdbcTemplate.query("SELECT * FROM bookingservice.vipSeats " +
                            "WHERE idAuditorium = ?",
                    new Object[] {auditorium.getId()},
                    new VipSeatsMapper()));
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return vipSeats;
    }

    @Override
    public List<Auditorium> getAll() {
        List<Auditorium> auditoriums = null;
        try {
            auditoriums = jdbcTemplate.query("SELECT * FROM bookingservice.auditorium ",
                    new AuditoriumMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return auditoriums;
    }
}

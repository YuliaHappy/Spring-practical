package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.dao.impl.mappers.EventMapper;
import com.epam.training.spring.core.practical.dao.interfaces.EventDao;
import org.postgresql.core.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

public class DatabaseEventDaoImpl implements EventDao {
    private JdbcTemplate jdbcTemplate;
    private Logger logger = new Logger();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Event event) {
        try {
            jdbcTemplate.update("INSERT INTO bookingservice.event VALUES (?, ?, ?, ?, ?, ?)",
                    event.getName(),
                    event.getRating().toString(),
                    event.getBasePriceTicket(),
                    event.getVipPriceTicket(),
                    event.getDateTime(),
                    event.getAuditorium().getId());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public void remove(Event event) {
        try {
            jdbcTemplate.update("DELETE FROM bookingservice.event " +
                            "WHERE name = ?",
                    event.getName());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public Event getByName(String name) {
        Event event = null;
        try {
            event = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.event " +
                            "WHERE name = ?",
                    new Object[] {name},
                    new EventMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return event;
    }

    @Override
    public List<Event> getAll() {
        List<Event> events = null;
        try {
            events = jdbcTemplate.query("SELECT * FROM bookingservice.event ",
                    new EventMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return events;
    }

    @Override
    public List<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {
        List<Event> events = null;
        try {
            events = jdbcTemplate.query("SELECT * FROM bookingservice.event " +
                            "WHERE datetime < ? AND  datetime > ?",
                    new Object[] {to, from},
                    new EventMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return events;
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime to) {
        return getForDateRange(LocalDateTime.now(), to);
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, LocalDateTime dateTime) {
        event.setAuditorium(auditorium);
        event.setDateTime(dateTime);
    }
}

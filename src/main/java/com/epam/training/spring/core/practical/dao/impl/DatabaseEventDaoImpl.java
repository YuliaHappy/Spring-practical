package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.basic.Event;
import com.epam.training.spring.core.practical.dao.impl.mappers.EventMapper;
import com.epam.training.spring.core.practical.dao.interfaces.EventDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

public class DatabaseEventDaoImpl implements EventDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Event event) {
        jdbcTemplate.update("INSERT INTO bookingservice.event VALUES (?, ?, ?, ?, ?, ?)",
                event.getName(),
                event.getRating().toString(),
                event.getBasePriceTicket(),
                event.getVipPriceTicket(),
                event.getDateTime(),
                event.getAuditorium().getId());
    }

    @Override
    public void remove(Event event) {
        jdbcTemplate.update("DELETE FROM bookingservice.event " +
                        "WHERE name = ?",
                event.getName());
    }

    @Override
    public Event getByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.event " +
                        "WHERE name = ?",
                new Object[] {name},
                new EventMapper());
    }

    @Override
    public List<Event> getAll() {
        return jdbcTemplate.query("SELECT * FROM bookingservice.event ",
                new EventMapper());
    }

    @Override
    public List<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {
        return jdbcTemplate.query("SELECT * FROM bookingservice.event " +
                "WHERE datetime < ? AND  datetime > ?",
                new Object[] {to, from},
                new EventMapper());
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

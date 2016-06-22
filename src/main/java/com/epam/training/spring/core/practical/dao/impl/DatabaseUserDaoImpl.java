package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.dao.impl.mappers.TicketMapper;
import com.epam.training.spring.core.practical.dao.impl.mappers.UserMapper;
import com.epam.training.spring.core.practical.dao.interfaces.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DatabaseUserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void register(User user) {
        jdbcTemplate.update("INSERT INTO bookingservice.user VALUES (?, ?, ?, ?)",
                null,
                user.getName(),
                user.getEmail(),
                user.getBirthday().toString());
        user.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user " +
                "WHERE email = ?",
                new Object[] {user.getEmail()},
                new UserMapper()).getId());
    }

    @Override
    public void remove(User user) {
        jdbcTemplate.update("DELETE FROM bookingservice.user " +
                "WHERE id = ?",
                user.getId());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE bookingservice.user SET name = ?, email = ?, birthday = ?," +
                "WHERE id = ?",
                user.getName(),
                user.getEmail(),
                user.getBirthday().toString(),
                user.getId());
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user " +
                        "WHERE id = ?",
                new Object[] {id},
                new UserMapper());
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user " +
                        "WHERE email = ?",
                new Object[] {email},
                new UserMapper());
    }

    @Override
    public List<User> getUsersByName(String name) {
        return jdbcTemplate.query("SELECT * FROM bookingservice.user " +
                        "WHERE name = ?",
                new Object[] {name},
                new UserMapper());
    }

    @Override
    public Set<Ticket> getBookedTickets(User user) {
        return new HashSet<>(jdbcTemplate.query("SELECT * FROM bookingservice.bookedticket " +
                        "WHERE idUser = ?",
                new Object[] {user.getId()},
                new TicketMapper()));
    }

    @Override
    public boolean isRegistered(User user) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user " +
                        "WHERE id = ?",
                new Object[] {user.getId()},
                new UserMapper()).isRegistered();
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM bookingservice.user ",
                new UserMapper());
    }
}

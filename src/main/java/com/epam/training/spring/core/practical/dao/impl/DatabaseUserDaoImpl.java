package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.dao.impl.mappers.TicketMapper;
import com.epam.training.spring.core.practical.dao.impl.mappers.UserMapper;
import com.epam.training.spring.core.practical.dao.interfaces.UserDao;
import org.postgresql.core.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DatabaseUserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    private Logger logger = new Logger();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void register(User user) {
        try {
            jdbcTemplate.update("INSERT INTO bookingservice.user (name, email, birthday) VALUES (?, ?, ?)",
                    user.getName(),
                    user.getEmail(),
                    new java.sql.Date(user.getBirthday().getTime()));
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        int idUser = -1;
        try {
            idUser = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user " +
                            "WHERE email = ?",
                    new Object[] {user.getEmail()},
                    new UserMapper()).getId();
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        user.setId(idUser);
    }

    @Override
    public void remove(int idUser) {
        try {
            jdbcTemplate.update("DELETE FROM bookingservice.user " +
                            "WHERE id = ?",
                    idUser);
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public void update(User user) {
        try {
            jdbcTemplate.update("UPDATE bookingservice.user SET name = ?, email = ?, birthday = ?," +
                            "WHERE id = ?",
                    user.getName(),
                    user.getEmail(),
                    user.getBirthday().toString(),
                    user.getId());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public User getById(int id) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user " +
                            "WHERE id = ?",
                    new Object[] {id},
                    new UserMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user " +
                            "WHERE email = ?",
                    new Object[] {email},
                    new UserMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return user;
    }

    @Override
    public List<User> getUsersByName(String name) {
        List<User> users = null;
        try {
            users = jdbcTemplate.query("SELECT * FROM bookingservice.user " +
                            "WHERE name = ?",
                    new Object[] {name},
                    new UserMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return users;
    }

    @Override
    public Set<Ticket> getBookedTickets(User user) {
        Set<Ticket> tickets = null;
        try {
            tickets = new HashSet<>(jdbcTemplate.query("SELECT * FROM bookingservice.bookedticket " +
                            "WHERE idUser = ?",
                    new Object[] {user.getId()},
                    new TicketMapper()));
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return tickets;
    }

    @Override
    public boolean isRegistered(User user) {
        boolean isRegistered = false;
        try {
            isRegistered = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user " +
                            "WHERE id = ?",
                    new Object[] {user.getId()},
                    new UserMapper()).isRegistered();
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return isRegistered;
    }

    @Override
    public List<User> getAll() {
        List<User> users = null;
        try {
            users = jdbcTemplate.query("SELECT * FROM bookingservice.user ",
                    new UserMapper());
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.fillInStackTrace());
        }
        return users;
    }
}

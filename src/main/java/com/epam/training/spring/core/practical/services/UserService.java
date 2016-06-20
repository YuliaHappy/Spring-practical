package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.dao.interfaces.UserDao;

import java.util.List;

/**
 * Created by Iuliia_Savich on 6/20/2016.
 */
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(User user) {
        userDao.register(user);
    }

    public void remove(User user) {
        userDao.remove(user);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }

    public List<Ticket> getBookedTickets(User user) {
        return userDao.getBookedTickets(user);
    }

    public boolean isRegistered(User user) {
        return userDao.isRegistered(user);
    }
}

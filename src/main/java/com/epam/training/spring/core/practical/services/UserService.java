package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.dao.interfaces.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(User user) {
        userDao.register(user);
    }

    public void remove(int idUser) {
        userDao.remove(idUser);
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

    public Set<Ticket> getBookedTickets(User user) {
        return userDao.getBookedTickets(user);
    }

    public boolean isRegistered(User user) {
        return userDao.isRegistered(user);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public void registerUsers(List<User> users) {
        for (User user :
                users) {
            userDao.register(user);
        }
    }
}

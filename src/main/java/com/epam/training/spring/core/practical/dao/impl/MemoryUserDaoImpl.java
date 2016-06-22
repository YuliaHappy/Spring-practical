package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.dao.interfaces.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MemoryUserDaoImpl implements UserDao{
    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void register(User user) {
        user.setRegistered(true);
        users.add(user);
    }

    public void remove(User user) {
        users.remove(user);
    }

    public void update(User user) {
        if (user == null) {
            throw new NullPointerException("User for update is empty!");
        }
        for (User u :
                users) {
            if (u.getId() == user.getId()) {
                u.update(user.getName(), user.getEmail(), user.getBookedTickets(),
                        user.isRegistered());
            }
        }
    }

    public User getById(int id) {
        for (User u :
                users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for (User u :
                users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public List<User> getUsersByName(String name) {
        List<User> usersByName = new ArrayList<>();
        for (User u :
                users) {
            if (u.getName().equals(name)) {
                usersByName.add(u);
            }
        }
        return usersByName;
    }

    public Set<Ticket> getBookedTickets(User user) {
        return user.getBookedTickets();
    }

    public boolean isRegistered(User user) {
        return user.isRegistered();
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}

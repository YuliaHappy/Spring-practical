package com.epam.training.spring.core.practical.dao.interfaces;

import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    void register(User user);
    void remove(User user);
    void update(User user);
    User getById(int id);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    Set<Ticket> getBookedTickets(User user);
    boolean isRegistered(User user);
    List<User> getAll();
}

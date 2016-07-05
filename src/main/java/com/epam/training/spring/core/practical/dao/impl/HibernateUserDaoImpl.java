package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Ticket;
import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.dao.interfaces.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class HibernateUserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void register(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void remove(int idUser) {
        entityManager.remove(getById(idUser));
    }

    @Transactional
    @Override
    public void update(User user) {
        User updatableUser = getById(user.getId());
        updatableUser.setName(user.getName());
        updatableUser.setEmail(user.getEmail());
        updatableUser.setBirthday(user.getBirthday());
        updatableUser.setRegistered(user.isRegistered());
    }

    @Transactional
    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        return null;
    }

    @Override
    public Set<Ticket> getBookedTickets(User user) {
        return null;
    }

    @Override
    public boolean isRegistered(User user) {
        return user.isRegistered();
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }
}

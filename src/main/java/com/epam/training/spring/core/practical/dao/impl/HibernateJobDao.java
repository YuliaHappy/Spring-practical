package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Employee;
import com.epam.training.spring.core.practical.basic.Job;
import com.epam.training.spring.core.practical.dao.interfaces.JobDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateJobDao implements JobDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(Job job) {
        entityManager.persist(job);
    }

    @Transactional
    @Override
    public void remove(int idJob) {
        entityManager.remove(getById(idJob));
    }

    @Transactional
    @Override
    public List<Job> getAll() {
        return entityManager.createQuery("SELECT u FROM Job u").getResultList();
    }

    @Transactional
    @Override
    public Job getById(int idJob) {
        return entityManager.find(Job.class, idJob);
    }

    @Transactional
    @Override
    public void appointEmployee(int idJob, Employee employee) {
        getById(idJob).setEmployee(employee);
    }
}

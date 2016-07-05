package com.epam.training.spring.core.practical.dao.impl;

import com.epam.training.spring.core.practical.basic.Employee;
import com.epam.training.spring.core.practical.basic.Job;
import com.epam.training.spring.core.practical.dao.interfaces.EmployeeDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class HibernateEmployeeDao implements EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    @Transactional
    @Override
    public void remove(int idEmployee) {
        entityManager.remove(getById(idEmployee));
    }

    @Transactional
    @Override
    public List<Employee> getAll() {
        return entityManager.createQuery("SELECT u FROM Employee u").getResultList();
    }

    @Transactional
    @Override
    public Employee getById(int idEmployee) {
        return entityManager.find(Employee.class, idEmployee);
    }

    @Transactional
    @Override
    public List<Job> getJobsById(int idEmployee) {
        return getById(idEmployee).getJobs();
    }
}

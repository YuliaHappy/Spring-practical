package com.epam.training.spring.core.practical.dao.interfaces;

import com.epam.training.spring.core.practical.basic.Employee;
import com.epam.training.spring.core.practical.basic.Job;

import java.util.List;

public interface JobDao {
    void create(Job job);
    void remove(int idJob);
    List<Job> getAll();
    Job getById(int idJob);
    void appointEmployee(int idJob, Employee employee);
}

package com.epam.training.spring.core.practical.dao.interfaces;

import com.epam.training.spring.core.practical.basic.Employee;
import com.epam.training.spring.core.practical.basic.Job;

import java.util.List;
import java.util.Set;

public interface EmployeeDao {
    void create(Employee employee);
    void remove(int idEmployee);
    List<Employee> getAll();
    Employee getById(int idEmployee);
    List<Job> getJobsById(int idEmployee);
}

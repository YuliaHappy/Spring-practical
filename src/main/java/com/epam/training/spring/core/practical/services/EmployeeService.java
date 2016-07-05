package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Employee;
import com.epam.training.spring.core.practical.basic.Job;
import com.epam.training.spring.core.practical.dao.interfaces.EmployeeDao;

import java.util.List;
import java.util.Set;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void register(Employee employee) {
        employeeDao.create(employee);
    }

    public void remove(int idEmployee) {
        employeeDao.remove(idEmployee);
    }

    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    public List<Job> getAllJobs(int idEmployee) {
        return employeeDao.getJobsById(idEmployee);
    }
}

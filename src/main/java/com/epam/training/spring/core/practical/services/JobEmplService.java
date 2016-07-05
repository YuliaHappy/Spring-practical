package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Employee;
import com.epam.training.spring.core.practical.dao.interfaces.EmployeeDao;
import com.epam.training.spring.core.practical.dao.interfaces.JobDao;

import java.util.List;

public class JobEmplService {
    private JobDao jobDao;
    private EmployeeDao employeeDao;

    public JobEmplService(JobDao jobDao, EmployeeDao employeeDao) {
        this.jobDao = jobDao;
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    public Employee getEmployeeById(int idEmployee) {
        return employeeDao.getById(idEmployee);
    }

//    public void appointEmployee(int idJob, Employee employee) {
//        jobDao.appointEmployee(idJob, employee);
//        employeeDao.addJob(employee.getId(), jobDao.getById(idJob));
//    }
}

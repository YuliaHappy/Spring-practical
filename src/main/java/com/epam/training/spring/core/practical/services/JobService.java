package com.epam.training.spring.core.practical.services;

import com.epam.training.spring.core.practical.basic.Employee;
import com.epam.training.spring.core.practical.basic.Job;
import com.epam.training.spring.core.practical.dao.interfaces.JobDao;

import java.util.List;

public class JobService {
    private JobDao jobDao;

    public JobService(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    public void register(Job job) {
        jobDao.create(job);
    }

    public void remove(int idJob) {
        jobDao.remove(idJob);
    }

    public Job getById(int id) {
        return jobDao.getById(id);
    }

    public List<Job> getAll() {
        return jobDao.getAll();
    }

    public void appointEmployee(int idJob, Employee employee) {
        jobDao.appointEmployee(idJob, employee);
    }
}

package com.epam.training.spring.core.practical.basic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Employee")
@Table(name = "employee", schema = "job_empl")
public class Employee {
    @Id
    @SequenceGenerator(name = "empl_seq", sequenceName = "job_empl.employee_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "empl_seq")
    private int id;
    private String name;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<Job> jobs;

    public Employee() {

    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Employee(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobs=" + jobs +
                '}';
    }
}

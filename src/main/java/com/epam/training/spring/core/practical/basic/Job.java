package com.epam.training.spring.core.practical.basic;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Job")
@Table(name = "job", schema = "job_empl")
public class Job {
    @Id
    @SequenceGenerator(name = "job_seq", sequenceName = "job_empl.job_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "job_seq")
    private int id;

    @Temporal(TemporalType.DATE)
    private Date deadline;
    private String description;

    @ManyToOne
    @JoinColumn(name = "idemployee")
    private Employee employee;

    public Job() {

    }

    public Job(int id, Date deadline, String description) {
        this.id = id;
        this.deadline = deadline;
        this.description = description;
    }

    public Job(Date deadline, String description) {
        this.deadline = deadline;
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", description='" + description + '\'' +
                ", employee=" + employee +
                '}';
    }
}

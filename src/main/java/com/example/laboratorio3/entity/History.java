package com.example.laboratorio3.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="job_history")
public class History {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int job_history_id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employees;

    @Id
    @Column(nullable = false)
    private String start_date;


    @Column(nullable = false)
    private String end_date;


    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    public int getJob_history_id() {
        return job_history_id;
    }

    public void setJob_history_id(int job_history_id) {
        this.job_history_id = job_history_id;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}



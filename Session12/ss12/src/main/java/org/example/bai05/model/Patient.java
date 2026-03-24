package org.example.bai05.model;

import java.util.Date;

public class Patient {
    private String id;
    private String name;
    private int age;
    private String department;
    private Date admissionDate;

    public Patient(String id, String name, int age, String department, Date admissionDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.admissionDate = admissionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-5d | %-20s |", id, name, age, department);
    }
}

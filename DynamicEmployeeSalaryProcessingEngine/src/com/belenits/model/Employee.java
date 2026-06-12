package com.belenits.model;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private String department;
    private String role;
    private Integer experience;
    private Double salary;
    private Double performanceRating;

    public Employee(Integer employeeId, String employeeName, String department, String role, Integer experience, Double salary, Double performanceRating) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.role = role;
        this.experience = experience;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getRole() {
        return role;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getPerformanceRating() {
        return performanceRating;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPerformanceRating(Double performanceRating) {
        this.performanceRating = performanceRating;
    }
}

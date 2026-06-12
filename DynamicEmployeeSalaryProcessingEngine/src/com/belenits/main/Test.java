package com.belenits.main;

import com.belenits.model.Employee;
import com.belenits.service.impl.SalaryService;

public class Test {

    public static void main(String[] args) {

        Employee employee = new Employee(101, "John", "IT", "Developer", 2, 45000.0, 4.3);

        SalaryService salaryService = new SalaryService();
        salaryService.processSalary(employee);
    }
}

package com.belenits.service.impl;

import com.belenits.model.Employee;
import com.belenits.service.SalaryProcessor;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SalaryService {

    private final Predicate<Employee> highRating =
            e -> e.getPerformanceRating() >= 4.5;

    private final Predicate<Employee> experienced =
            e -> e.getExperience() >= 5;

    private final Predicate<Employee> lowRating =
            e -> e.getPerformanceRating() < 3;

    private final Function<Employee, Double> hikePercentage = e -> {

        if (lowRating.test(e))
            return 0.0;
        else if (highRating.test(e))
            return 20.0;
        else if (experienced.test(e))
            return 15.0;
        else if (e.getRole().equalsIgnoreCase("Developer"))
            return 10.0;
        else if (e.getRole().equalsIgnoreCase("Tester"))
            return 8.0;

        return 0.0;
    };

    private final SalaryProcessor processor = e -> {
        double hike = hikePercentage.apply(e);
        return e.getSalary() + (e.getSalary() * hike / 100);
    };

    private final Comparator<Employee> comparator =
            Comparator.comparing(Employee::getSalary);

    public void processSalary(Employee employee) {

        double oldSalary = employee.getSalary();
        double hike = hikePercentage.apply(employee);
        double finalSalary = processor.process(employee);

        Consumer<Employee> consumer = e -> {
            System.out.println("Employee: " + e.getEmployeeName());
            System.out.println("Role: " + e.getRole());
            System.out.println("Old Salary: " + oldSalary);
            System.out.println("Hike Applied: " + hike + "%");
            System.out.println("Final Salary: " + finalSalary);
        };

        consumer.accept(employee);
    }
}
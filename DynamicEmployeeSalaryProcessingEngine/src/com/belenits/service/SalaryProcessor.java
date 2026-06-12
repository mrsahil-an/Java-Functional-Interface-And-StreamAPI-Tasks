package com.belenits.service;

import com.belenits.model.Employee;

@FunctionalInterface
public interface SalaryProcessor  {

    double process(Employee employee);

}

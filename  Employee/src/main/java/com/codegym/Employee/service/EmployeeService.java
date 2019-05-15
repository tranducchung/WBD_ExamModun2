package com.codegym.Employee.service;

import com.codegym.Employee.model.Depart;
import com.codegym.Employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService  {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(int id);

    void save(Employee employee);

    void remove(Employee employee);

    Page<Employee> findAllByNameContainingOrCodeContaining(String name, String code, Pageable pageable);

    Page<Employee> findAllByDepart(Depart depart, Pageable pageable);
}

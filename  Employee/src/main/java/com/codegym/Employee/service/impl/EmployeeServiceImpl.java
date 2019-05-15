package com.codegym.Employee.service.impl;

import com.codegym.Employee.model.Depart;
import com.codegym.Employee.model.Employee;
import com.codegym.Employee.repository.EmployRepository;
import com.codegym.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployRepository employRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employRepository.findAll(pageable);
    }

    @Override
    public Employee findById(int id) {
        return employRepository.findById(id).get();
    }

    @Override
    public void save(Employee employee) {
        employRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        employRepository.delete(employee);
    }

    @Override
    public Page<Employee> findAllByNameContainingOrCodeContaining(String name, String code, Pageable pageable) {
        return employRepository.findAllByNameContainingOrCodeContaining(name, code, pageable);
    }

    @Override
    public Page<Employee> findAllByDepart(Depart depart, Pageable pageable) {
        return employRepository.findAllByDepart(depart, pageable);
    }
}

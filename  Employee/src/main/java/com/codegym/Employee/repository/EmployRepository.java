package com.codegym.Employee.repository;

import com.codegym.Employee.model.Depart;
import com.codegym.Employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployRepository extends PagingAndSortingRepository<Employee,Integer> {
    Page<Employee> findAllByNameContainingOrCodeContaining(String name, String code, Pageable pageable);

    Page<Employee> findAllByDepart(Depart depart,Pageable pageable);
}

package com.codegym.Employee.repository;

import com.codegym.Employee.model.Depart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartRepository extends PagingAndSortingRepository<Depart,Integer> {
}

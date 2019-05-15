package com.codegym.Employee.service;

import com.codegym.Employee.model.Depart;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartService
{
    Page<Depart> findAll(Pageable pageable);

    Depart findById(int id);

    void save(Depart depart);

    void remove(Depart depart);
}

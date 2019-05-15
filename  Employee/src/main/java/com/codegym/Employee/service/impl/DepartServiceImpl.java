package com.codegym.Employee.service.impl;

import com.codegym.Employee.model.Depart;
import com.codegym.Employee.repository.DepartRepository;
import com.codegym.Employee.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository departRepository;
    @Override
    public Page<Depart> findAll(Pageable pageable) {
        return departRepository.findAll(pageable);
    }

    @Override
    public Depart findById(int id) {
        return departRepository.findById(id).get();
    }

    @Override
    public void save(Depart depart) {
        departRepository.save(depart);
    }

    @Override
    public void remove(Depart depart) {
        departRepository.delete(depart);
    }
}

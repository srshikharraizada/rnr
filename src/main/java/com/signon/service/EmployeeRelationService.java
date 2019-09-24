package com.signon.service;

import com.signon.model.EmployeeRelation;

import java.util.List;
import java.util.Optional;

public interface EmployeeRelationService {

    Optional<EmployeeRelation> findById(Long id);

    EmployeeRelation save(EmployeeRelation employeeRelation);

    List<EmployeeRelation> findAll();

    void deleteById(long id);

}

package com.signon.service.impl;

import com.signon.model.EmployeeRelation;
import com.signon.model.Rewards;
import com.signon.repository.EmployeeRelationRepository;
import com.signon.service.EmployeeRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EmployeeRelationServiceImpl implements EmployeeRelationService {

    EmployeeRelationRepository employeeRelationRepository;

    @Override
    public EmployeeRelation save(EmployeeRelation employeeRelation) {
        return employeeRelationRepository.save(employeeRelation);
    }

    @Override
    public List<EmployeeRelation> findAll() {
        return (List<EmployeeRelation>) employeeRelationRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

        employeeRelationRepository.deleteById(id);
    }

    @Override
    public Optional<EmployeeRelation> findById(Long id) {
        return employeeRelationRepository.findById(id);
    }
}

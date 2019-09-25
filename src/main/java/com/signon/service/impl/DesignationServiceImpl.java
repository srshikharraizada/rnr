package com.signon.service.impl;


import com.signon.model.Designation;
import com.signon.model.EmployeeRelation;
import com.signon.repository.DesignationRepository;
import com.signon.service.DesignationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DesignationServiceImpl implements DesignationService {

    DesignationRepository designationRepository;


    @Override
    public Designation save(Designation designation) {
        return designationRepository.save(designation);
    }

    @Override
    public List<Designation> findAll() {
        return (List<Designation>) designationRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

        designationRepository.deleteById(id);
    }

    @Override
    public Optional<Designation> findById(Long id) {
        return designationRepository.findById(id);
    }


}

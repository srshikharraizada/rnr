package com.signon.service;

import com.signon.model.Designation;

import java.util.List;
import java.util.Optional;


public interface DesignationService {


    Optional<Designation> findById(Long id);

    Designation save(Designation designation);

    List<Designation> findAll();

    void deleteById(long id);

}

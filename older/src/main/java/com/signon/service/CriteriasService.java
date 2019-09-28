package com.signon.service;

import com.signon.model.Criterias;

import java.util.List;
import java.util.Optional;

public interface CriteriasService {


    Optional<Criterias> findById(Long id);

    Criterias saveCriteria(Criterias criterias);


    List<Criterias> findAll();

    void deleteById(long id);
}

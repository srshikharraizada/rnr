package com.signon.service;

import com.signon.model.Nominations;

import java.util.List;
import java.util.Optional;

public interface NominationsService {

    Optional<Nominations> findById(Long id);

    Nominations save(Nominations nominations);


    List<Nominations> findAll();

    void deleteById(long id);



}



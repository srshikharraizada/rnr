package com.signon.service;

import com.signon.model.Designation;
import com.signon.model.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesService {


    Optional<Roles> findById(Long id);

    Roles save(Roles roles);

    List<Roles> findAll();

    void deleteById(long id);
}

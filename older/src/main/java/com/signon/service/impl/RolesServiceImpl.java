package com.signon.service.impl;


import com.signon.model.Roles;
import com.signon.repository.RolesRepository;
import com.signon.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {

    @Autowired
    RolesRepository rolesRepository;


    @Override
    public Roles save(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public List<Roles> findAll() {
        return (List<Roles>) rolesRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return rolesRepository.findById(id);
    }
}

package com.signon.controller;


import com.signon.model.Criterias;
import com.signon.service.CriteriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CriteriasController {

    @Autowired
    private CriteriasService criteriasService;

    @PostMapping("/saveCriterias")
    public Criterias save(@RequestHeader(value = "Authorization") String token, @RequestBody Criterias criterias){
        return criteriasService.save(criterias);
    }

    @GetMapping("/listCriterias")
    public List<Criterias> list(@RequestHeader(value = "Authorization") String token){
        return criteriasService.findAll();
    }

    @DeleteMapping("/deleteCriterias/{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable long id){
        criteriasService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/listCriterias/{id}")
    public Optional<Criterias> getById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){

        return criteriasService.findById(id);
    }

}


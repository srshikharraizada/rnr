package com.signon.controller;


import com.signon.model.Nominations;
import com.signon.service.NominationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class NominationsController {

    @Autowired
    private NominationsService nominationsService;


    @PostMapping("/saveNominations")
    public Nominations save(@RequestHeader(value = "Authorization") String token, @RequestBody Nominations nominations){
        return nominationsService.save(nominations);
    }

    @GetMapping("/listNominations")
    public List<Nominations> list(@RequestHeader(value = "Authorization") String token){
        return nominationsService.findAll();
    }

    @DeleteMapping("/deleteNominations/{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable long id){
        nominationsService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/listNominations/{id}")
    public Optional<Nominations> getById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){

        return nominationsService.findById(id);
    }
}

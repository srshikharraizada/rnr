package com.signon.controller;

import com.signon.model.Rewards;
import com.signon.service.RewardsService;
import com.signon.utils.CheckValidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @Autowired
    private CheckValidity validity;


    @PostMapping("/save")
    public Rewards save(@RequestHeader(value = "Authorization") String token , @RequestBody Rewards rewards) throws Exception{

        String email=validity.check(token);

        rewardsService.save(rewards);

        return rewards;
    }


    @GetMapping("/listrewards")
    public List<Rewards> list(@RequestHeader(value = "Authorization") String token){

        String email=validity.check(token);

        return rewardsService.findAll();
    }

    @GetMapping("/listrewards/{id}")
    public Optional<Rewards> getById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){

        String email=validity.check(token);

        return rewardsService.findById(id);
    }


    @DeleteMapping("/deleterewards/{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable long id){

        String email=validity.check(token);

        rewardsService.deleteById(id);
        return "Deleted Successfully";
    }
}

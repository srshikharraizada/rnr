package com.signon.controller;

import com.signon.model.Rewards;
import com.signon.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;


    @PostMapping("/save")
    public ResponseEntity<?> rewardsSave(@RequestHeader(value = "Authorization") String token, @RequestBody Rewards rewards){
        return rewardsService.rewardsSave(rewards);
    }
    @GetMapping("/listrewards")
    public List<Rewards> list(@RequestHeader(value = "Authorization") String token){
        return rewardsService.findAll();
    }

    @GetMapping("/listrewards/{id}")
    public Optional<Rewards> getById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){

        return rewardsService.findById(id);
    }


    @DeleteMapping("/deleterewards/{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable long id){
        rewardsService.deleteById(id);
        return "Deleted Successfully";
    }
}

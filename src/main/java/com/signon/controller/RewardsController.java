package com.signon.controller;

import com.signon.model.Rewards;
import com.signon.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @PostMapping("/save")
    public Rewards save(@RequestHeader(value = "Authorization") String token, @RequestBody Rewards rewards){
        return rewardsService.save(rewards);
    }

    @GetMapping("/list")
    public List<Rewards> list(@RequestHeader(value = "Authorization") String token){
        return rewardsService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable long id){
        rewardsService.deleteById(id);
        return "Deleted Successfully";
    }
}

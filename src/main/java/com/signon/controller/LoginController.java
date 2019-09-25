package com.signon.controller;

import com.signon.model.Rewards;
import com.signon.model.UserInfo;
import com.signon.utils.CheckValidity;
import com.signon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CheckValidity validity;


    @PostMapping(value = "/login")
    public Object getToken(@RequestHeader(value = "Authorization") String token) throws Exception {
        String jwtToken = loginService.login(token);
        return ResponseEntity.ok("" + jwtToken);
    }

    @PostMapping("/saveUsers")
    public UserInfo saveLogin(@RequestHeader(value = "Authorization") String token, @RequestBody UserInfo users){
        return loginService.saveLogin(users);
    }


    @GetMapping("/listUsers")
    public List<UserInfo> listUser(@RequestHeader(value = "Authorization") String token){
        return loginService.findAll();
    }

    @GetMapping("/listUsers/{id}")
    public Optional<UserInfo> getById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){

        return loginService.findById(id);
    }


    @DeleteMapping("/deleteUsers/{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable long id){
        loginService.deleteById(id);
        return "Deleted Successfully";
    }


    @GetMapping("/hey")
    public String hey(@RequestHeader(value = "Authorization") String token) throws Exception {

        String email=validity.check(token);
        return "Hii, You have successfully logged in..!!";


    }

}
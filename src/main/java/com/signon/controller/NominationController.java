package com.signon.controller;

import com.signon.dto.NominationPojo;
import com.signon.service.NominationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/trail")
public class NominationController {

    @Autowired
    NominationsService nominationsService;


    @PostMapping("/save")
    public ResponseEntity<?> nominationsave(@RequestBody NominationPojo nominationPojo) {
         nominationsService.nominationsave(nominationPojo);
         return ResponseEntity.ok(nominationPojo);
    }
}

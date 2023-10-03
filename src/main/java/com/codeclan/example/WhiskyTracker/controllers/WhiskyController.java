package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

//    @GetMapping(name = "/whiskies")
//    public ResponseEntity<List<Whisky>> getWhiskies(){
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }
// /whiskies?distillery=3&
    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskies(
            @RequestParam(name = "year", required = false)Integer year) {
        if (year == null) {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
    }
    @GetMapping(value = "/whiskiesByDistillery={distillery}")
    public ResponseEntity<List<Whisky>> getWhiskiesByDistillery(@PathVariable Long distillery, @RequestParam(name="age", required = false) Integer age){
        if (age == null) {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryId(distillery), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryIdAndAge(distillery, age), HttpStatus.OK);
        }
    }

}

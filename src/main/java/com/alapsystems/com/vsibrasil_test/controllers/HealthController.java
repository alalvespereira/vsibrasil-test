package com.alapsystems.com.vsibrasil_test.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("health")
public class HealthController {

    @GetMapping("")
    public ResponseEntity<Object> healthCheck(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "OK");
        map.put("message", "API working");
        log.info("/health -> ".concat(map!=null ? map.toString() : "null"));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}

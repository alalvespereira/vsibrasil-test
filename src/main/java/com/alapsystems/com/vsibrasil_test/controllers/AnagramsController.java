package com.alapsystems.com.vsibrasil_test.controllers;

import com.alapsystems.com.vsibrasil_test.services.AnagramsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/anagrams")
public class AnagramsController {

    @Autowired
    private AnagramsService anagramsService;

    @GetMapping("/{text}")
    public ResponseEntity<Object> getAnagrams(@PathVariable("text") String text){
        Map<String, Object> anagrams = anagramsService.anagramGenerator(text);
        HttpStatus httpStatus = HttpStatus.OK;
        if (anagrams.get("message") != null)
            httpStatus = HttpStatus.BAD_REQUEST;
        log.info("/anagrams -> ".concat(anagrams != null ? anagrams.toString() : "null"));
        return new ResponseEntity<>(anagrams, httpStatus);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAnagrams(){
        Map<String, Object> anagrams = anagramsService.anagramGenerator(null);
        HttpStatus httpStatus = HttpStatus.OK;
        if (anagrams.get("message") != null)
            httpStatus = HttpStatus.BAD_REQUEST;
        log.info("/anagrams -> ".concat(anagrams != null ? anagrams.toString() : "null"));
        return new ResponseEntity<>(anagrams, httpStatus);
    }

}

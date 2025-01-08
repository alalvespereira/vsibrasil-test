package com.alapsystems.com.vsibrasil_test.controllers;

import com.alapsystems.com.vsibrasil_test.services.AnagramsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/anagrams")
public class AnagramsController {

    @Autowired
    private AnagramsService anagramsService;

    @GetMapping("/{text}")
    public ResponseEntity<List<String>> getAnagrams(@PathVariable("text") String text){
        List<String> anagrams = anagramsService.anagramsGenerate(text);
        return new ResponseEntity<>(anagrams, HttpStatus.OK);
    }

}

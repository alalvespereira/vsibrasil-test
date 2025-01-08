package com.alapsystems.com.vsibrasil_test.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AnagramsService {
    public List<String> anagramsGenerate(String text){
        List<String> anagrams = new ArrayList<>();
        return anagrams;
    }
}

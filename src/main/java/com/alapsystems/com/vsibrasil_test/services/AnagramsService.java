package com.alapsystems.com.vsibrasil_test.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AnagramsService {

    public Map<String, Object> anagramGenerator(String text){
        Map<String, Object> anagramsResponse = new HashMap<String, Object>();
        anagramsResponse.put("text", text);

        if (text == null || text.isEmpty() || text.length() == 1 || !text.matches("[a-zA-Z]+")) {
            anagramsResponse.put("generated", "Fail");
            anagramsResponse.put("message", "ERROR - The text cannot be null or blank, must have two or more characters and must contain only letters");
            return anagramsResponse;
        }

        List<String> anagramList = new ArrayList<>();
        char[] chars = text.toCharArray();
        transposition(anagramList, 0, chars);

        anagramsResponse.put("generated", "Success");
        anagramsResponse.put("anagrams", anagramList);
        anagramsResponse.put("qty_words ", anagramList.size());
        return anagramsResponse;
    }

    private void transposition(List<String> anagramList, int idx, char[] chars) {

        if (idx == chars.length - 1) {
            // Adiciona a palavra anagrama na lista de anagramas
            anagramList.add(new String(chars));
            return;
        }

        int i = idx;
        while (i < chars.length){
            characterSwap(chars, idx, i); // Faz a troca dos caracteres das posições idx e i
            transposition(anagramList, idx + 1, chars); // Chama esse mesmo método para gerar outras palavras
            characterSwap(chars, idx, i);
            i++;
        }

    }

    private void characterSwap(char[] chars, int i, int j) { // Faz a troca dos caracteres de 2 indices
        char auxChar = chars[i];
        chars[i] = chars[j];
        chars[j] = auxChar;
    }

}

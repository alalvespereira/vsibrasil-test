package com.alapsystems.com.vsibrasil_test.anagrams;

import com.alapsystems.com.vsibrasil_test.services.AnagramsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class AnagramsTests {

    @Autowired
    private AnagramsService anagramsService;

    @Test
    void successSixLetters() throws Exception {

        try {

            String objectStringExpected = "{\"generated\":\"Success\",\"text\":\"XYW\",\"qty_words \":6,\"anagrams\":[\"XYW\",\"XWY\",\"YXW\",\"YWX\",\"WYX\",\"WXY\"]}";
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> objectMapExpected = objectMapper.readValue(objectStringExpected, new TypeReference<Map<String, Object>>() {});

            String text = "XYW";
            Map<String, Object> objectMapResult = anagramsService.anagramGenerator(text);
            Assert.assertEquals(objectMapExpected, objectMapResult);

            log.info("Expected Map: {}", objectMapExpected);
            log.info("Received Map: {}", objectMapExpected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    Resultado
    Expected Map: {generated=Success, text=XYW, qty_words =6, anagrams=[XYW, XWY, YXW, YWX, WYX, WXY]}
    Received Map: {generated=Success, text=XYW, qty_words =6, anagrams=[XYW, XWY, YXW, YWX, WYX, WXY]}
     */


    @Test
    void FailNullLetters() throws Exception {

        try {

            String objectStringExpected = "{\"generated\":\"Fail\",\"text\":null,\"message\":\"ERROR - The text cannot be null or blank, must have two or more characters and must contain only letters\"}";
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> objectMapExpected = objectMapper.readValue(objectStringExpected, new TypeReference<Map<String, Object>>() {});

            String text = null;
            Map<String, Object> objectMapResult = anagramsService.anagramGenerator(text);
            Assert.assertEquals(objectMapExpected, objectMapResult);

            log.info("Expected Map: {}", objectMapExpected);
            log.info("Received Map: {}", objectMapExpected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    Resultado
    Expected Map: {generated=Fail, text=null, message=ERROR - The text cannot be null or blank, must have two or more characters and must contain only letters}
    Received Map: {generated=Fail, text=null, message=ERROR - The text cannot be null or blank, must have two or more characters and must contain only letters}
    */


    @Test
    void FailOneLetter() throws Exception {

        try {

            String objectStringExpected = "{\"generated\":\"Fail\",\"text\":\"X\",\"message\":\"ERROR - The text cannot be null or blank, must have two or more characters and must contain only letters\"}";
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> objectMapExpected = objectMapper.readValue(objectStringExpected, new TypeReference<Map<String, Object>>() {});

            String text = "X";
            Map<String, Object> objectMapResult = anagramsService.anagramGenerator(text);
            Assert.assertEquals(objectMapExpected, objectMapResult);

            log.info("Expected Map: {}", objectMapExpected);
            log.info("Received Map: {}", objectMapExpected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    Resultado
    Expected Map: {generated=Fail, text=X, message=ERROR - The text cannot be null or blank, must have two or more characters and must contain only letters}
    Received Map: {generated=Fail, text=X, message=ERROR - The text cannot be null or blank, must have two or more characters and must contain only letters}
    */
}

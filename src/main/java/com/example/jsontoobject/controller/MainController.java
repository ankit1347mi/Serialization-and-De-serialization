package com.example.jsontoobject.controller;

import com.example.jsontoobject.dto.Person;
import com.example.jsontoobject.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Slf4j
public class MainController {


    private PersonService personService;

    private ObjectMapper objectMapper;

    @Autowired
    public MainController(PersonService personService, ObjectMapper objectMapper) {

        this.personService = personService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public String StringToObject(@RequestBody String data) {
        try {
            Person person = objectMapper.readValue(data, Person.class);
            log.info("Object mapper " + person);
            return personService.ObjectToJson(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/")
    public String objectToString(@RequestBody Person person) {
        try {
            String string = objectMapper.writeValueAsString(person);
            log.info("Object mapper " + string);
            return personService.JsonToObject(string).toString();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}

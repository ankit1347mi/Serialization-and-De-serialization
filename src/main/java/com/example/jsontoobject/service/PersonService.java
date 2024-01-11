package com.example.jsontoobject.service;

import com.example.jsontoobject.dto.Person;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService {

    private Gson gson;

    public PersonService(Gson gson) {
        this.gson = gson;
    }

    public Person JsonToObject(String value) {
        Person person = gson.fromJson(value, Person.class);
        log.info("person value in object " + person);
        return person;
    }

    public String ObjectToJson(Person person) {
        String json = gson.toJson(person);
        log.info("person value in Json is " + json);
        return json;
    }
}

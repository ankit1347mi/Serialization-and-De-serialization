package com.example.jsontoobject.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Person {

    private String name;
    private  int age;
    private String city;
}

package com.saurabhAPIAuto.utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    Faker faker = new Faker();

    public String getFirstname(){
        return faker.name().firstName();
    }

    public String getLastname(){
        return faker.name().lastName();
    }
}

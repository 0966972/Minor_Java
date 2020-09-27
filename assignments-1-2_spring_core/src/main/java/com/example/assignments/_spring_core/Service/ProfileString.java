package com.example.assignments._spring_core.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public class ProfileString {

    @Value("${spring.message}")
    private String message;

    public String getActiveProfiles() {

        return message;
    }
}

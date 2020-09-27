package com.example.assignments._spring_core.Service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class StringServiceProd implements StringService{
    public String Revert(String input)
    {
        return input.toUpperCase();
    }
}

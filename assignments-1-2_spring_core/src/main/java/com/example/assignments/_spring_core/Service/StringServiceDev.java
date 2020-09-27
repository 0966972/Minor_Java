package com.example.assignments._spring_core.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class StringServiceDev implements StringService{


    public String Revert(String input)
    {
        StringBuilder output = new StringBuilder(input);
        output.reverse();
        return output.toString();
    }
}

package com.example.assignments._spring_core.Service;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service("CountWords")
public class CountString {
    public CountString()
    {
    }
    static final HashMap<String, Integer> inputs = new HashMap<String, Integer>();

    public Integer Count(String input)
    {
        if(inputs.get(input) == null)
        {
            String[] words = input.split("\\s+");
            inputs.put(input,words.length);
            return words.length;
        }
        return inputs.get(input);
    }
}

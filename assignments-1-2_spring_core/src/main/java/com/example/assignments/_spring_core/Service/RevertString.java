package com.example.assignments._spring_core.Service;

import org.springframework.stereotype.Service;

@Service("StringRevert")
public class RevertString {

    public String Revert(String input){
        StringBuilder output = new StringBuilder(input);
        output.reverse();
        return output.toString();
    }


}

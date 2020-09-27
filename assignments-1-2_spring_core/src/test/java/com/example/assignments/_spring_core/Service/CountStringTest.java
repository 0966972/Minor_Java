package com.example.assignments._spring_core.Service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountStringTest {

    @Test
    public void CountStringTest()
    {
        //GIVEN
        CountString countString = new CountString();
        String input = "Hello Hello";

        //WHEN
        Integer Result = countString.Count(input);

        //THEN
        assertEquals(2, Result);
    }

}
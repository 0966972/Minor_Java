package com.example.assignments._spring_core.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RevertStringTest {
    @Test
    public void testRevertString()
    {
        //GIVEN
        RevertString revertString = new RevertString();
        String input = "Hello";

        //WHEN
        String Result = revertString.Revert(input);

        //THEN
        assertEquals("olleH",Result);
    }

}

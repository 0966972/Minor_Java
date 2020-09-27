package com.example.assignments._spring_core;

import com.example.assignments._spring_core.Controller.StringController;
import com.example.assignments._spring_core.Service.StringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringControllerTest {
    @Test
    public void TestStringController()
    {
        //GIVEN
        StringController stringController = new StringController();
        String input = "Test";

        //WHEN
        String Result = stringController.revert(input);

        //THEN
        assertEquals("tseT",Result);
    }
    @Test
    public void TestStringController2()
    {
        //GIVEN
        StringController stringController = new StringController();
        String input = "Test";

        //WHEN
        Integer Result = stringController.count(input);

        //THEN
        assertEquals(1,Result);
    }
    @Test
    public void TestStringController3()
    {
        //GIVEN
        StringController stringController = new StringController();
        String input = "Test";

        //WHEN
        String Result = stringController.Upper(input);

        //THEN
        assertEquals("TEST",Result);
    }

}

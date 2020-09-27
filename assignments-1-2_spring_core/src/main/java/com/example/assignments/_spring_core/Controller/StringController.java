package com.example.assignments._spring_core.Controller;
import com.example.assignments._spring_core.Service.RevertString;
import com.example.assignments._spring_core.Service.CountString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@Repository
@RestController
@RequestMapping("/api")
public class StringController {

    @GetMapping("/Revert/{input}")
    @ResponseBody
    public String revert(@PathVariable String input)

    {
        RevertString revertString = new RevertString();
        String Result = revertString.Revert(input);
        return Result;
    }

    @GetMapping("/Upper/{input}")
    @ResponseBody
    public String Upper(@PathVariable String input)
    {
        return input.toUpperCase();
    }

    @GetMapping("/Count/{input}")
    @ResponseBody
    public Integer count(@PathVariable String input)
    {
        CountString countString = new CountString();
        System.out.println(input);
        return countString.Count(input);
    }


    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @GetMapping("/Profile/{input}")
    @ResponseBody
    public String profile(@PathVariable String input)
    {
        if (activeProfile.equals("dev"))
        {
            return input.toUpperCase();
        }
        RevertString revertString = new RevertString();
        String Result = revertString.Revert(input);
        return Result;
    }

}

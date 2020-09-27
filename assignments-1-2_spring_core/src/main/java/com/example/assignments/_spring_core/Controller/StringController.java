package com.example.assignments._spring_core.Controller;
import com.example.assignments._spring_core.Service.ProfileString;
import com.example.assignments._spring_core.Service.RevertString;
import com.example.assignments._spring_core.Service.CountString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.*;


@Repository
@RestController
@RequestMapping("/api")
public class StringController {
    @PostMapping("/Revert")
    public String revert(@RequestBody String input)

    {
        RevertString revertString = new RevertString();
        String Result = revertString.Revert(input);
        return Result;
    }

    @PostMapping("/Upper")
    public String Upper(@RequestBody String input)
    {
        return input.toUpperCase();
    }

    @PostMapping("/Count")
    public Integer count(@RequestBody String input)
    {
        CountString countString = new CountString();
        return countString.Count(input);
    }

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @PostMapping("/Profile")
    public String profile(@RequestBody String input)
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

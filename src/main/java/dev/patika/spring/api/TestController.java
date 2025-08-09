package dev.patika.spring.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/tr")
public class TestController {

    @GetMapping("/")

    public String home(){
        return "Anasayfa";
    }

    @GetMapping("/about")
    //@RequestMapping(value = "/about",method = RequestMethod.GET)
    //@RequestMapping(value = "/about",method= RequestMethod.POST)
    public String about(){
        return "Hakkımızda";
    }
    @GetMapping("/user/{userId}")
    public String getUserOnlyId(@PathVariable int userId){
        return "User id: "+userId;
    }
    @GetMapping("/user/{userId}/{userName}")
    public String getUser(@PathVariable int userId,@PathVariable String userName){
        return "User id: "+userId+"---"+"User name: "+userName ;
    }
}

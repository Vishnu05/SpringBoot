package com.postgre.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/postgresql")
    public String hello(){
        return "hello world from the postgresl";
    }
}

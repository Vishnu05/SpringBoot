package com.boot.springboot.RestController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorld {

    // to use custom property this annotation helps
    @Value("${name.yo}")
    String name;


    @GetMapping("/")
    public String hello() {
        System.out.println("Custom property name works fine :::  " + name);
        return "Hello world! spring boot applications " + LocalDateTime.now();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "yo!! whats app";
    }
}

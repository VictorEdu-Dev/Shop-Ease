package com.controller.servlets.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/greet")
    public String greet() {
        return "greet"; // Isso retornará o nome de uma view chamada "greet"
    }
}

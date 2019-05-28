package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${memberName}")
    private String memberName;

    @RequestMapping(value = "/")
    public String index() {
        return "hello world, i like coding";
    }

    @RequestMapping("/getMemberName")
    public String getMemberName(){
        return memberName;
    }
}

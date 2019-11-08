package com.my.springbootadmin.controller;

import com.my.springbootadmin.model.CoreTimer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @RequestMapping("/test")
    public String test(){
        return "test11";
    }

    @RequestMapping("/say")
    public String say(){
        return "ni hao";
    }
}

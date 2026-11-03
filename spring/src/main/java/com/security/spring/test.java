package com.security.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/hello")
    public String helllo(){
        return "Hello  Anish";
    }

    @GetMapping("/hi")
    public String hi(){
        return "Hi Anish";
    }

    @GetMapping("/hallo")
    public String hallo(){
        return "Hallo Anish, wie geht es dir?";
    }




}

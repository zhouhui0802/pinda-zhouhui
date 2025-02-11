package com.zh.myapp.controller;

import com.zh.log.MyLog;
import com.zh.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    HelloService helloService;

    @MyLog(desc = "sayHello Method")
    @GetMapping("/say")
    public String sayHello(){
        return helloService.sayHello();
    }
}

package com.app.microservice1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {

    @GetMapping("/service/one")
    public String hello(){
        return "Hello from microservice 1";
    }

    @GetMapping("/service/one/from/two")
    public String hello2(){
        return "Hello from microservice 1 but requested from microservice 2";
    }
}

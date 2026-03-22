package com.embarkx.FirstSpring;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}/show")
    public String helloParam(@PathVariable String name){
        return "Hello World bro :-"+name;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/hello")
    public HelloResponse helloPost(@RequestBody String name){
        return new HelloResponse("Hello " +name+" world");
    }

}

package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/greeting")
    public @ResponseBody String greeting(){
        return "Hello";
    }

    public static void main(String []args ){

    }


}

package com.example.firstProject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String sayHello(Model model){

       model.addAttribute("username", "Mina");
        return "greetings";
    }
    @GetMapping("/bye")
    public String sayBye(Model model){
        model.addAttribute("nickname", "Mina");
       return "goodbye";
    }

}

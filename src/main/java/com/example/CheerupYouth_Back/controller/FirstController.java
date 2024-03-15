package com.example.CheerupYouth_Back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "승희");
        return "greetings"; // templates/greetings.mustache 파일 > /hello로 접근가능
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "승희");
        return "goodbye";
    }
}
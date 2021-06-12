package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * "/" で呼び出されるメソッド
     * @return home.html
     */

    @GetMapping("/")
    public String home() {
        return "home";
    }
}

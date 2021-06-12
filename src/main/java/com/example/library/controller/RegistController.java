package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.library.form.BookForm;

@Controller
public class RegistController {

    /**
     * "/regist" で呼び出されるメソッド
     * @return regist.html
     */
    @GetMapping("/regist")
    public String regist(Model model) {
        model.addAttribute("bookForm", new BookForm());
        return "regist";
    }
}

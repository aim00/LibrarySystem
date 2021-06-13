package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.library.entity.Book;
import com.example.library.service.BookService;

@Controller
public class EditController {

    @Autowired
    BookService bookService;

    /**
     * "/edit" で呼び出されるメソッド
     * @return edit.html
     */
    @PostMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("nowBook", bookService.findOneBook(id));
        model.addAttribute("newBook", new Book());
        return "edit";
    }
}

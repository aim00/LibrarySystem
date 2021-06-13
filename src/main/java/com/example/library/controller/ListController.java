package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.library.entity.Book;
import com.example.library.form.BookForm;
import com.example.library.service.BookService;

@Controller
public class ListController {

    @Autowired
    BookService bookService;

    /**
     * "/list" で呼び出されるメソッド
     * @return list.html
     */
    @PostMapping("/list")
    public String postList(@ModelAttribute BookForm bookForm, Model model) {
        Book book = new Book();
        book.setName(bookForm.getName());
        book.setPrice(bookForm.getPrice());
        bookService.registerBook(book);

        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "list";
    }
}

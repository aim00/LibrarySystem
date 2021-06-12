package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entity.Book;
import com.example.library.mapper.BookMapper;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public void registBook(Book book) {
        bookMapper.regist(book);
    }

    public List<Book> findAllBooks() {
        List<Book> bookList = bookMapper.findAll();
        return bookList;
    }
}

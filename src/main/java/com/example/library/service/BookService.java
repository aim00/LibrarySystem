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

    /**
     * BookMapperインターフェースのregisterメソッド
     * @param book
     */
    public void registerBook(Book book) {
        bookMapper.register(book);
    }

    /**
     * BookMapperインターフェースのfindAllメソッド
     * @return
     */
    public List<Book> findAllBooks() {
        List<Book> bookList = bookMapper.findAll();
        return bookList;
    }

    /**
     * BookMapperインターフェースのfindOneメソッド
     * @param  id
     * @return
     */
    public Book findOneBook(int id) {
        Book book = bookMapper.findOne(id);
        return book;
    }

    /**
     * BookMapperインターフェースのdeleteメソッド
     * @param id
     */
    public void deleteBook(int id) {
        bookMapper.delete(id);
    }
}

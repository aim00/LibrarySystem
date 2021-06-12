package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.library.entity.Book;

@Mapper
public interface BookMapper {

    /**
     * 書籍登録メソッド
     * @param book 登録したい書籍のオブジェクト
     */
    public void regist(Book book);

    /**
     * 書籍全検索メソッド
     * @return bookテーブルにある全書籍
     */
    public List<Book> findAll();

}

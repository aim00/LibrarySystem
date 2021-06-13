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
    public void register(Book book);

    /**
     * 書籍全検索メソッド
     * @return bookテーブルにある全書籍
     */
    public List<Book> findAll();

    /**
     * idから書籍を検索するメソッド
     * @param  id
     * @return    idが一致した書籍
     */
    public Book findOne(int id);

    /**
     * idから書籍を削除するメソッド
     * @param id
     */
    public void delete(int id);
}

package com.jk.dao;

import com.jk.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BookDao {
    List<Book> queryBook();

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(@Param("ids") String ids);
}

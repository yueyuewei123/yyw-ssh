package com.jk.service;

import com.jk.model.Book;

import java.util.List;

public interface BookService {
    List<Book> queryBook();

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(String ids);
}

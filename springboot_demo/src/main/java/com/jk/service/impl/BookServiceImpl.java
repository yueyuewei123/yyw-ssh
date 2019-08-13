package com.jk.service.impl;

import com.jk.dao.BookDao;
import com.jk.model.Book;
import com.jk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public List<Book> queryBook() {

        return bookDao.queryBook();
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBook(String ids) {
        bookDao.deleteBook(ids);
    }
}

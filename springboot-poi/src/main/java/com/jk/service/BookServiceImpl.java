package com.jk.service;

import com.jk.dao.BookDao;
import com.jk.model.Bok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;


    @Override
    public List<Bok> queryBook() {
        return bookDao.queryBook();
    }

    @Override
    public void addBook(List<Bok> list) {
        bookDao.addBook(list);
    }

    @Override
    public Integer selCount(Map map) {
        return   bookDao.selCount(map);
    }

    @Override
    public List<Bok> queryBookList(Map map) {
        return  bookDao.queryBookList(map);
    }


}

package com.jk.service;

import com.jk.model.Bok;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Bok> queryBook();

    void addBook(List<Bok> list);

    Integer selCount(Map map);

    List<Bok> queryBookList(Map map);
}

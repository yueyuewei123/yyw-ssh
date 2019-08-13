package com.jk.dao;

import com.jk.model.Bok;

import java.util.List;
import java.util.Map;

public interface BookDao {

    List<Bok> queryBook();

    void addBook(List<Bok> list);

    Integer selCount(Map map);

    List<Bok> queryBookList(Map map);
}

package com.jk.controller;

import com.jk.model.Book;
import com.jk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private BookService bService;

    @RequestMapping("queryBook")
    public String queryBook(Model model){
        List<Book> list = bService.queryBook();
        model.addAttribute("list",list);
        return "addBook";
    }

    @RequestMapping("toshow")
    public String toshow(){
        return "show";
    }

    @RequestMapping("queryBookList")
    @ResponseBody
    public List<Book> queryBookList(){
        List<Book> list = bService.queryBook();
        return list;
    }

    @RequestMapping("addBook")
    @ResponseBody
    public void addBook(Book book){
        if (book.getId()==null){
            bService.addBook(book);
        }else{
            bService.updateBook(book);
        }

    }

    @RequestMapping("deleteBook")
    @ResponseBody
    public void deleteBook(String ids){
        bService.deleteBook(ids);
    }











}

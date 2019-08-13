package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class TestController {


    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("userList")
    public String userList(){
        return "userList";
    }

    @RequestMapping("roleList")
    public String roleList(){
        return "roleList";
    }


    @RequestMapping("treeList")
    public String treeList(){
        return "treeList";
    }

    @RequestMapping("loglist")
    public String loglist(){
        return "loglist";
    }


}

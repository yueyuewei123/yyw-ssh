package com.jk.controller;

import com.jk.model.Music;
import com.jk.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RequestMapping("/music")
@Controller
public class MusicController {

    @Autowired
    private MusicService musicService;

    @RequestMapping("toMain")
    public String toMain(){
        return "main";
    }
    @RequestMapping("toList")
    public String toList(){
        return "list";
    }

    @RequestMapping("queryMusic")
    @ResponseBody
    public List<Music> queryMusic(){
        return musicService.queryMusic();
    }

    @RequestMapping("addMusic")
    @ResponseBody
    public void addMusic(Music music) {
        if (music.getId() == null) {
            musicService.addMusic(music);
        } else {
            musicService.updateMusic(music);
        }

    }

    @RequestMapping("deleteMusic")
    @ResponseBody
    public void deleteBook(String ids){
        musicService.deleteMusic(ids);
    }





}

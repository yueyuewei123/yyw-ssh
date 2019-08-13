package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Music;
import com.jk.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Reference
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

    @RequestMapping("queryMusicList")
    @ResponseBody
    public Map<String,Object> queryBookList(Integer page, Integer rows, Music music){
        Map map=new HashMap();
        map.put("start", (page-1)*rows);//起始页
        map.put("end", rows);//每页条数
        Integer count=musicService.selCount(map);
        List<Music> list = musicService.queryBookList(map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("total",count);
        map1.put("rows",list);
        return map1;
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

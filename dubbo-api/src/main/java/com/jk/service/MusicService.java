package com.jk.service;

import com.jk.model.Music;

import java.util.List;
import java.util.Map;

public interface MusicService {

    List<Music> queryMusic();

    void addMusic(Music music);

    void updateMusic(Music music);

    void deleteMusic(String ids);

    Integer selCount(Map map);

    List<Music> queryBookList(Map map);
}

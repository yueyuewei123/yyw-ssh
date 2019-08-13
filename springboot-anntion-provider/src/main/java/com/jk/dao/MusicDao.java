package com.jk.dao;

import com.jk.model.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MusicDao {
    List<Music> queryMusic();

    void addMusic(Music music);

    void updateMusic(Music music);

    void deleteMusic(@Param("ids") String ids);

    Integer selCount(Map map);

    List<Music> queryBookList(Map map);
}

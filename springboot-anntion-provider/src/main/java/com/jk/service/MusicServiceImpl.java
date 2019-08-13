package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.MusicDao;
import com.jk.model.Music;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicDao musicDao;


    @Override
    public List<Music> queryMusic() {
        return musicDao.queryMusic();
    }

    @Override
    public void addMusic(Music music) {
        musicDao.addMusic(music);
    }

    @Override
    public void updateMusic(Music music) {
        musicDao.updateMusic(music);
    }

    @Override
    public void deleteMusic(String ids) {
        musicDao.deleteMusic(ids);
    }

    @Override
    public Integer selCount(Map map) {
        return musicDao.selCount(map);
    }

    @Override
    public List<Music> queryBookList(Map map) {
        return musicDao.queryBookList(map);
    }
}

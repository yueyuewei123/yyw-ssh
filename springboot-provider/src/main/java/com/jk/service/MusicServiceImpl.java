package com.jk.service;

import com.jk.dao.MusicDao;
import com.jk.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "musicService")
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
}

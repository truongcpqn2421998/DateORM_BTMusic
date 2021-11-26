package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAllSong();
    Song findById(int id);
    void remove(int id);
    void save(Song Song);
}

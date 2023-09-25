package com.example.exercise2.service;

import com.example.exercise2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    boolean create(Song song);
    boolean update(Song song);
    Song findById(int id);
}

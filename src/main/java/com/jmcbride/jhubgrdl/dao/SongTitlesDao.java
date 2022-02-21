package com.jmcbride.jhubgrdl.dao;

import com.jmcbride.jhubgrdl.model.SongTitles;

import java.util.List;

public interface SongTitlesDao {

    void insertSongtitles(SongTitles songTitles);
    void insertSongtitles(List<SongTitles> SongTitless);
    List<SongTitles> getAllSongtitless();
    void getSongtitlesById(String songTitles);
}

package com.jmcbride.jhubgrdl.service;

import com.jmcbride.jhubgrdl.model.SongTitles;

import java.util.List;

public interface SongTitlesService {
    void insertSongtitles(SongTitles songTitles);
    void insertSongtitles(List<SongTitles> SongTitless);
    List<SongTitles> getAllSongtitless();
    void getSongtitlesById(String empid);
}

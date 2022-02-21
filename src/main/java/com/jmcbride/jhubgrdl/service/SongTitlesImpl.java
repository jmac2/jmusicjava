package com.jmcbride.jhubgrdl.service;

import com.jmcbride.jhubgrdl.dao.SongTitlesDao;
import com.jmcbride.jhubgrdl.model.SongTitles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongTitlesImpl implements SongTitlesService{

    @Autowired
    SongTitlesDao songTitlesDao;

    @Override
    public void insertSongtitles(SongTitles songTitles){

    }
    @Override
    public void insertSongtitles(List<SongTitles> SongTitless){

    }
    @Override
    public List<SongTitles> getAllSongtitless(){
        List<SongTitles> songtitles = songTitlesDao.getAllSongtitless();
        return songtitles;
    }
    @Override
    public void getSongtitlesById(String empid){

    }
}

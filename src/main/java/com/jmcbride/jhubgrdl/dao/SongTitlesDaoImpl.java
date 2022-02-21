package com.jmcbride.jhubgrdl.dao;

import com.jmcbride.jhubgrdl.model.SongTitles;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SongTitlesDaoImpl extends JdbcDaoSupport implements SongTitlesDao{

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insertSongtitles(SongTitles songTitles){

    }
    @Override
    public void insertSongtitles(List<SongTitles> SongTitless){

    }
    @Override
    public List<SongTitles> getAllSongtitless(){

        String sql = "SELECT * FROM songtitles";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<SongTitles> result = new ArrayList<SongTitles>();
        for(Map<String, Object> row:rows){
            SongTitles songTitles = new SongTitles();
            songTitles.setSongtitle((String)row.get("songtitle"));
            songTitles.setSongfilename((String)row.get("songfilename"));
            result.add(songTitles);
        }

        return result;

    }
    @Override
    public void getSongtitlesById(String songTitles){

    }
}

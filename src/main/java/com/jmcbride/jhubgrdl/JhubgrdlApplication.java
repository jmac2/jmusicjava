package com.jmcbride.jhubgrdl;

import com.jmcbride.jhubgrdl.model.SongTitles;
import com.jmcbride.jhubgrdl.service.SongTitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JhubgrdlApplication {

	@Autowired
	SongTitlesService songTitlesService;

	public void getData(){
		List<SongTitles>  songs =  songTitlesService.getAllSongtitless();;
	}

	public static void main(String[] args) {


		SpringApplication.run(JhubgrdlApplication.class, args);

	}

}

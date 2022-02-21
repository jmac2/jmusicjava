package com.jmcbride.jhubgrdl.tunehandler;

import com.jmcbride.jhubgrdl.model.SongTitles;
import com.jmcbride.jhubgrdl.service.SongTitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;




@Component
public class PropertiesHandler {


	@Autowired
	SongTitlesService songTitlesService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public String getProperties() {
		String ret ="";
		SongTitles songTitles = new SongTitles();
		List<SongTitles> songs =  songTitlesService.getAllSongtitless();
		for(SongTitles st:songs){
			ret+= st.getSongtitle()+"*" + st.getSongtitle() + ",";
		}
		ret= ret.substring(0,ret.length()-1);
	/*	List<DAOBase> songs = songTitles.retriveDataMany();
		Gson gson = new Gson();
		json = gson.toJson(songs);	
		System.out.println(json);

		for(DAOBase dAOBase:songs) {
			System.out.println(dAOBase.getStringValue() + " dao\n");
			if(dAOBase.getStringValue().length()<3) {
				continue;
			}
			System.out.println("full line: "+ ret);
			ret+= dAOBase.getStringValue() + ",";
		}
		System.out.println("full line at end: "+ ret);
		ret= ret.substring(0,ret.length()-1);
	   */
		//ret = json;
		return ret;
	}
	
	public String writeProperties(String payload) { 
		String ret = "";
		return ret;
		
	}
}

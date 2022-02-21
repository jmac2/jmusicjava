package com.jmcbride.jhubgrdl.tunehandler;

import com.jmcbride.jhubgrdl.jsonobjects.GlobalManager;
import com.jmcbride.jhubgrdl.model.SongTitles;

import java.util.List;


public class HandleDDList {

	public static void main(String[] args) {
		GlobalManager globalManager = new GlobalManager();
		globalManager.setEnvironment();
		HandleDDList handleDDList = new HandleDDList();
		handleDDList.doGet();
	//	handleDDList.addTitle();

	}
	
	public void doGet() {
		SongTitles songTitles = new SongTitles();
		String json="";

		/* JJM List<DAOBase> songs = songTitles.retriveDataMany();
		Gson gson = new Gson();
		json = gson.toJson(songs);	
		System.out.println(json);

		 */
		return;
		
	}
	
	public void addTitle() {
		SongTitles songTitles = new SongTitles();
		String json="";

		songTitles.setSongtitle("song3");
		songTitles.setSongfilename("song3filename");
	//IMMED	songTitles.insert();
;	
		System.out.println(json);
		return;
		
	}


}

package com.jmcbride.jhubgrdl.jsonobjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GlobalManager {

	public static boolean isLocal = true;
	public static String connectionString;
	public static String SceneManagentRoot;
	public static String MusicRoot;
	public static String MusicFlicRoot;
	public static String BodyTrackingRoot;
	public static String TarkLangRoot;
	public static String PitchMatcherRoot;
	public static boolean isInitted = false;
	
	public static String LogRoot = "/Users/josephmcbride/Documents/Tarkovsky/logs/";
                                	
	public static String movieName = "somethinghappened";
	
	public void setEnvironment(){
		if(!isInitted){
		isInitted = true;
		BufferedReader br=null;
		System.out.println("checking for local");
		String theFile = "/Users/josephmcbride/Documents/platform/local.txt";
		try {
			br = new BufferedReader(new FileReader(theFile));
			System.out.println("local");
			if(br==null){
				System.out.println("local");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			isLocal = false;                                    
			System.out.println("not local");
		} finally{
			if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            // This is unrecoverable. Just report it and move on
		            e.printStackTrace();
		        }
			}
		}
	
	
		
		
		if(isLocal){
			connectionString = "jdbc:mysql://localhost/mydb?user=root&password=Pogues32";
			SceneManagentRoot = "/Users/josephmcbride/Documents/movies/";
			MusicRoot = "/Users/josephmcbride/Documents/data/tracks/";
			MusicFlicRoot = "/Users/josephmcbride/Documents/data/flic/";
			BodyTrackingRoot = "/Users/josephmcbride/Documents/data/bodytracking/";
			TarkLangRoot = "/Users/josephmcbride/Documents/data/tarklang/";
			LogRoot = "/Users/josephmcbride/Documents/Tarkovsky/logs/";
			PitchMatcherRoot ="/Users/josephmcbride/Documents/data/tunes/";

		}else{
			connectionString = "jdbc:mysql://localhost/windycit_stagedirections?user=windycit_root&password=pogues32";
			//connectionString = "jdbc:mysql://localhost/windycit_mydb?user=windycit_root&password=pogues32";
			SceneManagentRoot = "/home/windycityar/data/";
			MusicRoot = "/home/windycityar/data/tracks/";
			MusicFlicRoot = "/home/windycityar/data/flic/";
			BodyTrackingRoot = "/home/windycityar/data/bodytracking/";
			TarkLangRoot = "/home/windycityar/data/tarklang/";
			LogRoot = "/home/windycityar/data/logging/";
			PitchMatcherRoot = "/home/windycityar/data/tunes/";
		}         
		}
		
	}
	
	
	
	
}

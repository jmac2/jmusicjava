package com.jmcbride.jhubgrdl.speechstore;

import java.util.ArrayList;
import java.util.HashMap;

public class SpeechStore {
	
	private static String speechData;
	private static ArrayList<String> allSpeech = new ArrayList<String> ();
	private static ArrayList<String> allNames = new ArrayList<String> ();
	private static HashMap<String,String> speechMap = new HashMap<String,String>();
	
	
	public static void  clear() {
		speechData = "";
	}
	
	public static void  clearbyName(String nme) {
		speechData = "";
		 allNames.remove(nme);
		 speechMap.put(nme,"");

	}
	
	public static void  clearAll() {
		System.out.println("Clear all Data");
		speechData = "";
		 allSpeech = new ArrayList<String> ();
		 allNames = new ArrayList<String> ();
		 speechMap = new HashMap<String,String>();
		 
		
	}

	public static void  putData(String thedata) {
		speechData = thedata;
		processSpeech(thedata);
	}
	
	private static void processSpeech(String theData) {
		if(theData.contains("~")) {
			String[] parts = theData.split("~");
			String name = parts[0];
			String body = parts[1];
			if(speechMap.containsKey(name)) {
				speechMap.put(name, body);
			}
			else {
				speechMap.put(name, body);
				allNames.add(name);
			}
		}else {
			
		}
		
	}

	public static String getData() {
		System.out.println("In the Speech Store");
		String ret = speechData;
		String allBody = "";
		System.out.println("raw is: " +speechData);
		for(String nme: allNames) {
			System.out.println("checking name: " + nme);
			String bdy = speechMap.get(nme);
			allBody+= nme +"~" + bdy + "^";
		}
		ret = allBody;
		System.out.println("raw is: " +speechData);
		return ret;
	}
}

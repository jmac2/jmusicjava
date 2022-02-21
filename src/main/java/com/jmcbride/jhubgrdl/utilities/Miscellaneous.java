package com.jmcbride.jhubgrdl.utilities;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Miscellaneous {
	
	
	public void printCurrentTime(String s) {
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	        LocalTime localTime = LocalTime.now();
	        System.out.println(s + " " + dtf.format(localTime));    // 16:37:15
	}

}

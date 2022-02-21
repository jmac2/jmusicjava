package com.jmcbride.jhubgrdl.speechproccesor;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import com.jmcbride.jhubgrdl.speechstore.SpeechStore;
import com.jmcbride.jhubgrdl.utilities.Miscellaneous;

public class SpeechProcessor {
	
	public static void main(String[] args) {
		SpeechProcessor speechProcessor = new SpeechProcessor();
		speechProcessor.startTimer();
		speechProcessor.startTimer();
		}
	
	//private Timer timer = null;;
	private static Timer lastTimer = null;
	
	
	public void postSpeechData(String logst){
		startTimer();
		System.out.println("storing: " + logst);
		SpeechStore.putData(logst);
		
	
	}
	
	public String getSpeechData(String logst){
		startTimer();
		String ret="second please data";
		ret = SpeechStore.getData();
		return ret;
	}
	
	public void clearSpeechDataByName(String payload){
		String ret="second please data";
		if(payload.equals("")) {
			clearSpeechData();
		}else {
			SpeechStore.clearbyName(payload);
		}
		
		return;
	}
	
	public void clearSpeechData(){
		String ret="second please data";
		SpeechStore.clear();
		return;
	}
	
	public void clearAll(){

		SpeechStore.clearAll();
		///timer.purge();
		//timer.cancel();
		return;
	}
	
	public void startTimer() {
		if(lastTimer!=null) {
	 		lastTimer.cancel();
			lastTimer = null;
		}
	
		Miscellaneous miscellaneous = new Miscellaneous();
		miscellaneous.printCurrentTime("Starting time");

		Timer timer = new Timer();
         
        // Helper class extends TimerTask
        TimerTask task = new SpeechTimer();
        SpeechTimer st = (SpeechTimer)task;
        st.setSpeechProcessor(this,"amessage");
        /*
         *  Schedule() method calls for timer class.
         *  void schedule(TimerTask task, Date firstTime, long period)
         */
         
        timer.schedule(task, 120000, 120000);
  
        lastTimer = timer;

	}

}

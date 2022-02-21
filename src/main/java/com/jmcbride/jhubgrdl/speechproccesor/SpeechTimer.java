package com.jmcbride.jhubgrdl.speechproccesor;

import com.jmcbride.jhubgrdl.utilities.Miscellaneous;

import java.util.Timer;
import java.util.TimerTask;





class SpeechTimer extends TimerTask {
    private int i = 1;
    private String theMessage ="";
     
    // TimerTask.run() method will be used to perform the action of the task
     
    private SpeechProcessor theSpeechProcessor;
    
    
    public void setSpeechProcessor(SpeechProcessor speechProcessor,String msg) {
    	theSpeechProcessor = speechProcessor;
    	theMessage = msg;
    }
    
    public void run() {
    	i++;
        System.out.println("This is called "  + " time msg: " + theMessage);

		Miscellaneous miscellaneous = new Miscellaneous();
		miscellaneous.printCurrentTime("killing time");

        	theSpeechProcessor.clearAll();
        	this.cancel();

    }
}
 
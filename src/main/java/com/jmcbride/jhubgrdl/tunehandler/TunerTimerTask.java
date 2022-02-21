package com.jmcbride.jhubgrdl.tunehandler;
import com.jmcbride.jhubgrdl.utilities.DisplayImage;

import java.util.Timer;
import java.util.TimerTask;


 

public class TunerTimerTask extends TimerTask {
    public static int i = 1;
    private DisplayImage displayImage;
     
    // TimerTask.run() method will be used to perform the action of the task
     
    public void setImageDisplayMethod(DisplayImage disp) {
    	displayImage = disp;
    }
    
    public void run() {
        System.out.println("This is called " + i++ + " time");
        displayImage.returnFromTimer();
        this.cancel();
    }
}
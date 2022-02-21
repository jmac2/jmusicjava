package com.jmcbride.jhubgrdl.utilities;

import java.awt.Container;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jmcbride.jhubgrdl.tunehandler.TunerTimerTask;



public class DisplayImage extends JFrame {
    
	int w =0;
	int h = 0;
    public DisplayImage() {

        initUI();
    }
    
    private void captureScreen() {
    	////	/usr/sbin/screencapture -R0,82,740,970  /Users/josephmcbride/Documents/sheets/scr.png
    	
    	//ProcessBuilder processBuilder = new ProcessBuilder();
    //	processBuilder.command("/usr/sbin/screencapture -R0,0,w,h  /Users/josephmcbride/Documents/sheets/scr.png");
    	//processBuilder.command("/usr/sbin/screencapture -R0,0,768,1024  /Users/josephmcbride/Documents/sheets/scr.png");
    	

    	System.out.println("writing screen capture");
    	//String cmdLine = "/usr/sbin/screencapture -R0,0,768,1024  /Users/josephmcbride/Documents/sheets/scr.png";
    	
    	
    	String cmdLine = "/usr/sbin/screencapture -R0,0," + String.valueOf(w) + "," + String.valueOf(h)  + " /Users/josephmcbride/Documents/sheets/scr.png";
    	ShellExecutor shellExecutor = new ShellExecutor();
    	shellExecutor.doShellExecutor(cmdLine);

    	
    }
    
    public void returnFromTimer() {
    	captureScreen();
    }
    
	
	public void startTimer() {


		Timer timer = new Timer();
         
        // Helper class extends TimerTask
        TimerTask task = new TunerTimerTask();
        TunerTimerTask tt = (TunerTimerTask)task;
        tt.setImageDisplayMethod(this);
        /*
         *  Schedule() method calls for timer class.
         *  void schedule(TimerTask task, Date firstTime, long period)
         */
         
        timer.schedule(task, 5000, 5000);
 

	}

    private void initUI() {       
        
        ImageIcon ii = loadImage();

        JLabel label = new JLabel(ii);

        createLayout(label);

        setTitle("Image");
     //   setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private ImageIcon loadImage() {

        ImageIcon ii = new ImageIcon("/Users/josephmcbride/Documents/data/images/borrowed_image.jpg");
        w = ii.getIconWidth();
        h = ii.getIconHeight();
        System.out.println("width: " + w + " height: " + h);
        startTimer();
        
        return ii;
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            DisplayImage ex = new DisplayImage();
            ex.setVisible(true);
            ex.startTimer();
        });
        
        
        
        
    }
}
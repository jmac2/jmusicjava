package com.jmcbride.jhubgrdl.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ShellExecutor {

	
		

	public printOutput getStreamWrapper(InputStream is, String type) {
		return new printOutput(is, type);
	}
	
	public void doShellExecutor(String cmdLine) {
		
		System.out.println("About to shell execute: " + cmdLine);
		Runtime rt = Runtime.getRuntime();
		 ShellExecutor rte = new  ShellExecutor();
		printOutput errorReported, outputMessage;

	/*	try {
			Process proc = rt.exec("mkdir /Users/ashah/Desktop/new-folder");
			errorReported = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
			outputMessage = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
			errorReported.start();
			outputMessage.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

		try {
			Process proc = rt.exec(cmdLine);
			errorReported = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
			outputMessage = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
			errorReported.start();
			outputMessage.start();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void main(String[] args) {
		ShellExecutor shellExecutor = new ShellExecutor();
		shellExecutor.doShellExecutor("ls -w");
		
	}
 
	private class printOutput extends Thread {
		InputStream is = null;
 
		printOutput(InputStream is, String type) {
			this.is = is;
		}
 
		public void run() {
			String s = null;
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(is));
				while ((s = br.readLine()) != null) {
					System.out.println(s);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}

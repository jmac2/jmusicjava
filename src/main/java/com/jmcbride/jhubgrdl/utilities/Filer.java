package com.jmcbride.jhubgrdl.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



public class Filer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public String readFiletoString(String fname){
		String ret ="";
	 byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(fname));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ret = new  String(encoded, StandardCharsets.US_ASCII);
		 return ret;
		 
	}
	
	
	public String[] readFiletoStrings(String theFile)
	{
	
	String thisLine = "";	
	String[] ret = null;
	ArrayList lines = new ArrayList();
	try {
		//out = new DataOutputStream(new FileOutputStream(flename));
		BufferedReader br = new BufferedReader(new FileReader(theFile));

		while ((thisLine = br.readLine()) != null)
		{
		thisLine = thisLine.trim();
		lines.add(thisLine);
		}
		br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	int rows = lines.size();
	ret = new String[rows];
	for(int i=0;i<rows;i++){
		ret[i] = (String)lines.get(i);
	}
		
	return ret;		
	}
	
	
	public String writeFiletoStringMakeDirectories(String theFileName,String data){ //lookup root
		String ret = "";
		File file = new File(theFileName);
		file.getParentFile().mkdirs();
		FileWriter fr=null;
		  try {
	            fr = new FileWriter(file);
	            fr.write(data);
	            System.out.println("Attempting to write file in writer: " + theFileName + " with: " + data);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            //close resources
	            try {
	                fr.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		
		return ret;
		
	}
	
	public String writeFile(String theFileName,String data){ //lookup root
		String ret = "";
		File file = new File(theFileName);
		FileWriter fr=null;
		  try {
	            fr = new FileWriter(file);
	            fr.write(data);
	            System.out.println("Attempting to write file in writer: " + theFileName + " with: " + data);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            //close resources
	            try {
	                fr.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		
		return ret;
		
	}
		
	
		
	
	
	
}

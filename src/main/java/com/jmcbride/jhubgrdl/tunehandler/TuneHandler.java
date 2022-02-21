package com.jmcbride.jhubgrdl.tunehandler;

import com.jmcbride.jhubgrdl.jsonobjects.GlobalManager;
import com.jmcbride.jhubgrdl.model.SongTitles;
import com.jmcbride.jhubgrdl.utilities.Filer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


@Component
public class TuneHandler {

	@Value("${pitchmatcher.PitchMatcherRoot}")
	String pitchMatcherRoot;


	private int octave = 3;
	private boolean random = false;
	
	private boolean isKeepBase = false;
	private boolean isRandom = false;
	
	public static void main(String[] args) {
		TuneHandler tuneHandler = new TuneHandler();
		//tuneHandler.getTune("landslide");
		tuneHandler.testData();

	}
	
	
	
	
	public String getTune(String tune) {
		String special = "";
		int showNotes =0;
		String[] allparts = tune.split(",");
		special = allparts[0];
		String r = special.substring(0, 1);
		if(r.equals("R")){
			isRandom = true;
		}
		String kb = special.substring(1, 2);
		if(kb.equals("K")){
			isKeepBase = true;
		}
		tune = allparts[1];
		if(allparts.length>2) {
			String stnumnotes = allparts[2];
			showNotes =Integer.parseInt(stnumnotes); 
		}
		
		
	/*	if(tune.startsWith("random")) {
			random = true;
			String[] parts = tune.split(",");
			tune = parts[1];
			if(parts.length>2) {
				String stnumnotes = parts[2];
				showNotes =Integer.parseInt(stnumnotes);  
			}
		
			
		}
		*/
		
		Filer filer = new Filer();
		//String flename = GlobalManager.PitchMatcherRoot + tune + ".txt";

		String flename = pitchMatcherRoot  + tune + ".txt";

		String ret="";
		String[] lines = filer.readFiletoStrings(flename);
		String[] randLines;
		if(isRandom) {
			if(isKeepBase) {
				lines =  getRandomLinesKeepBase(lines,showNotes);
				
			}else {
				lines = getRandomLines(lines,showNotes);
				
			}
			
		}
		String total="";
		for(String lne:lines) {
			System.out.println(lne);
			octave = 3;
			if(lne.length()<2) {
				continue;
			}
			if(lne.toLowerCase().startsWith("octave")) {
				setOctave(lne);
				continue;
			}
			
			if(lne.toLowerCase().startsWith("pause")) {
				total = total + lne + "\n";
				
				continue;
			}
					
			String[] parts = lne.split(",");
			String num = translateNote(parts[0]);
			String newLine = num + ",";
			for(int i = 1;i<parts.length;i++) {
				newLine+= parts[i] + ",";
				
			}
			newLine = newLine.substring(0,newLine.length()-1);
			total = total + newLine + "\n";
		}
		System.out.println(total);
		return total;
	}

	
	
    
    
    
private void setOctave(String oct) {
	
}

public String translateNote(String notee)
    {
        String ret = "";
        if (notee.length() > 1)
        {
            char c = notee.charAt(1);
            String s=String.valueOf(c);  
            octave = Integer.parseInt(s);

        }


        String note;
        int midinum;

        ret = fromLetter(notee);
        return ret;

    }

    public String fromLetter(String letter)
    {
    	String ret ="";
        int num = 0;
        boolean isLower;
        char ch1 = letter.charAt(0);
        isLower = Character.isLowerCase(ch1);
        int offset=0;
     //   ch1 = Character.toLowerCase(ch1);
   /*     int offset = (int)ch1 - 97;
        if (isLower) {
            offset = offset - 1;
        }
        
        
   */     
        
        
        switch(ch1) {
        case 'a':
          offset=-1;
          break;
        case 'A':
            offset=0;
            break;
        case 'b':
            offset=1;
            break;
        case 'B':
            offset=2;
            break;
        case 'C':
            offset=3;
            break;
            
        case 'd':
            offset=4;
            break;
            
        case 'D':
            offset=5;
            break;
            
        case 'e':
            offset=6;
            break;
            
        case 'E':
            offset=7;
            break;
            
        case 'F':
            offset=8;
            break;
            
        case 'g':
            offset=9;
            break;
            
        case 'G':
            offset=10;
            break;

            
            

      }   
        
        

        num = (octave * 12) + offset + 21;
        ret=String.valueOf(num); 
        
        return ret;

    }
    
    public void saveTune(String fname, String notes) {
    	
    	
    	String flename = GlobalManager.PitchMatcherRoot + fname + ".txt";
    	Filer filer = new Filer();
    	filer.writeFile(flename, notes);
    	
    	
    	
    }
    
    
    
    private String[] getRandomLinesKeepBase(String[] ar, int keep) {

    	//Keep base will play the doh before each other random note.
    	
    	Random rnd = new Random();
    	String[] saveLines = new String[keep];
    	
    	
    	
    	for(int j=0;j<keep;j++) {
    		saveLines[j] = ar[j];
    	}

    	String baseLine = new String(ar[0]);
          for (int i = ar.length - 1; i > 0; i--)
          {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
          }
          
        ArrayList<String> withBaseLines = new ArrayList<String>();
        withBaseLines.add(baseLine);
        withBaseLines.add(baseLine);
        for(int i = 0;i <ar.length;i++) {
        	
        	withBaseLines.add(ar[i]);
        	withBaseLines.add(baseLine);
        	
        }
        
        ar =withBaseLines.toArray(new String[withBaseLines.size()]);

        
      	for(int j=0;j<keep;j++) {
    		ar[j] = saveLines[j];
    	}
          return ar;
    	

    }
    
    private String[] getRandomLines(String[] ar, int keep) {

    	
    	Random rnd = new Random();
    	String[] saveLines = new String[keep];
    	
    	
    	
    	for(int j=0;j<keep;j++) {
    		saveLines[j] = ar[j];
    	}
          for (int i = ar.length - 1; i > 0; i--)
          {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
          }
      	for(int j=0;j<keep;j++) {
    		ar[j] = saveLines[j];
    	}
          return ar;
    	

    }

    private String[] getRandomLinesSample(String[] ar,int indexStart) {

    	
    	Random rnd = new Random();
          for (int i = ar.length - 1; i > 0; i--)
          {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
          }
          return ar;
    	

    }

    
    public void saveNotesAndLyrics(String allnotes) {
    	System.out.println("all ntotes is " + allnotes + "\n");
    	String[]allparts = allnotes.split("\\*");
    	String fileName = allparts[0];
    	String notest  = allparts[1];
    	String lyricst = allparts[2];

    	/* add filename to database  */
    	SongTitles songTitles = new SongTitles();
    	songTitles.setSongfilename(fileName);
    	songTitles.setSongtitle(fileName);
    	//IMMED songTitles.insert();
    	
    	
    	String[] notes = notest.split("\n");
    	ArrayList<NoteStruct> notestructs = new ArrayList<NoteStruct>();
    	float baseline = -1.0f;
    	for(String note:notes) {
    		
    		String[] parts = note.split(" ");
    		float ft = Float.parseFloat(parts[1]);
    		if(baseline< 0) {
    			baseline = ft;
    			ft = 0;
    		}else {
    			ft = ft - baseline;
    		}
    		float midi = Float.parseFloat(parts[0]);
    	
    		String noteltr = getNoteLetterFromMidi(midi);
    		NoteStruct noteStruct = new NoteStruct(noteltr,ft);
    		notestructs.add(noteStruct);
   		
    	}
    	
    	
    	String[] lyrics = lyricst.split("\n");
    	ArrayList<LyricStruct> lyricstructs = new ArrayList<LyricStruct>();
    	baseline = -1.0f;
    	for(String lyric:lyrics) {
    	
    		String[] parts = lyric.split(",");
    		float ft = Float.parseFloat(parts[1]);
    		if(baseline< 0) {
    			baseline = ft;
    			ft = 0;
    		}else {
    			ft = ft - baseline;
    		}
    		String lyrst = parts[0];
    		String[] lparts = lyrst.split(" ");
    		String l = lparts[lparts.length -1];
    		LyricStruct lyricStruct = new LyricStruct(l,ft);
    		lyricstructs.add(lyricStruct);
   		
    	}
    	
    	System.out.println("now start");
    	ArrayList<CombinedStruct> combinedList = new ArrayList<CombinedStruct>();
    	int cnt = 0;
    	for(LyricStruct ls: lyricstructs) {

    		NoteStruct noteStruct= findClosest(notestructs,ls);
    		CombinedStruct comebineStruct  = comebineStruct(noteStruct,ls);
    		combinedList.add(comebineStruct);
    	}
   	
    	String sngString = createStringFromCombinedStructs(combinedList);
    	System.out.println(sngString);
    	saveTune(fileName,sngString);
    	
    }
    
    public void testData() {
    	Filer filer = new Filer();
    	String notest = filer.readFiletoString("/Users/josephmcbride/Documents/data/sampledata/notes.txt");
    	String lyricst = filer.readFiletoString("/Users/josephmcbride/Documents/data/sampledata/lyrics.txt");
    	
    	String[] notes = notest.split("\n");
    	ArrayList<NoteStruct> notestructs = new ArrayList<NoteStruct>();
    	float baseline = -1.0f;
    	for(String note:notes) {
    		
    		String[] parts = note.split(" ");
    		float ft = Float.parseFloat(parts[1]);
    		if(baseline< 0) {
    			baseline = ft;
    			ft = 0;
    		}else {
    			ft = ft - baseline;
    		}
    		float midi = Float.parseFloat(parts[0]);
    	
    		String noteltr = getNoteLetterFromMidi(midi);
    		NoteStruct noteStruct = new NoteStruct(noteltr,ft);
    		notestructs.add(noteStruct);
   		
    	}
    	
    	
    	String[] lyrics = lyricst.split("\n");
    	ArrayList<LyricStruct> lyricstructs = new ArrayList<LyricStruct>();
    	baseline = -1.0f;
    	for(String lyric:lyrics) {
    	
    		String[] parts = lyric.split(",");
    		float ft = Float.parseFloat(parts[1]);
    		if(baseline< 0) {
    			baseline = ft;
    			ft = 0;
    		}else {
    			ft = ft - baseline;
    		}
    		String lyrst = parts[0];
    		String[] lparts = lyrst.split(" ");
    		String l = lparts[lparts.length -1];
    		LyricStruct lyricStruct = new LyricStruct(l,ft);
    		lyricstructs.add(lyricStruct);
   		
    	}
    	
    	System.out.println("now start");
    	ArrayList<CombinedStruct> combinedList = new ArrayList<CombinedStruct>();
    	int cnt = 0;
    	for(LyricStruct ls: lyricstructs) {

    		NoteStruct noteStruct= findClosest(notestructs,ls);
    		CombinedStruct comebineStruct  = comebineStruct(noteStruct,ls);
    		combinedList.add(comebineStruct);
    	}
   	
    	String sngString = createStringFromCombinedStructs(combinedList);
    	System.out.println(sngString);
    	
    }
    
    private CombinedStruct comebineStruct(NoteStruct ns, LyricStruct ls) {
    	CombinedStruct combinedStruct = new CombinedStruct();
    	
    	combinedStruct.setNote(ns.getNote());
    	combinedStruct.setBeat("1");
    	combinedStruct.setLyric(ls.getLyric());
    	
    	return combinedStruct;
    }
    
    private String createStringFromCombinedStructs(ArrayList<CombinedStruct> combinedList) {
    	String ret = "";
    	for(CombinedStruct combinedStruct:combinedList) {
    		String st = "";
    		st = combinedStruct.getNote() + "," + combinedStruct.getBeat() + "," + combinedStruct.getLyric();
    		ret+= st + "\n";
    	}
    	
    	return ret;
    }

    private NoteStruct findClosest(ArrayList<NoteStruct> notestructs,LyricStruct ls){
    	NoteStruct noteStruct = null;
    	float diff = 10000.0f;
    	float chk = ls.getTime();  
    	for(NoteStruct ns:notestructs)	{		
    		float ndiff = Math.abs(ns.getTime() - chk);
    		if(ndiff < diff) {
    			noteStruct = ns;
    			diff = ndiff;
    		}
    	}
    			
    			
    	return noteStruct;
    	
    }
    
 
    private String getNoteLetterFromMidi(float midi) {
    	String ret = "";
    		int noteNumber=0;
    		noteNumber = (int)midi;
    	    noteNumber -= 21; // see the explanation below.
    	    String[] notes = new String[] {"A", "b", "B", "C", "d", "D", "e", "E", "F", "g", "G", "a"};
    	    int octave = noteNumber / 12 + 1;
    	    String name = notes[noteNumber % 12];
    	    ret = name + octave;
    	    return ret;

    }
    
    
}

package com.jmcbride.jhubgrdl.tunehandler;

public class LyricStruct {
	private String lyric;
	private float time;
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}

	LyricStruct(String lyr, float tme){
		lyric = lyr;
		time = tme;
	}
	
}

package com.jmcbride.jhubgrdl.tunehandler;

public class NoteStruct {
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	private String note;
	private float time;

	NoteStruct(String nt, float tme){
		note = nt;
		time = tme;
	}
}

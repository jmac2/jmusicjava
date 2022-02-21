package com.jmcbride.jhubgrdl.speechstore;

public class SpeechChunk {
	
	private String id;
	private String data;
	private boolean isRead;
	

	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}

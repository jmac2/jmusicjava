package com.jmcbride.jhubgrdl.jsonobjects;

//IMMED import com.google.gson.Gson;

public class ReturnObject {

	private String request="";
	private String payload="";
	private String extra="";
	private String status="";
	
	
	public ReturnObject(){
		
	}
	
	public ReturnObject(String request, String payload,String extra, String status){
		this.request = request;
		this.payload = payload;
		this.extra = extra;
		this.status = status;
		
	}
	
	public String  toJson(){
		String json = "";
		
	/* IMMED	Gson gson = new Gson();
		json = gson.toJson(this);
	*/
		return json;
	}
	
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}

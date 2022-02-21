package com.jmcbride.jhubgrdl.jsonobjects;

import java.util.ArrayList;

public class ReturnScenelet {
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getActionk() {
		return actionk;
	}
	public void setActionk(String actionk) {
		this.actionk = actionk;
	}
	public ArrayList<ReturnSceneletObject> getReturnSceneletObjects() {
		return returnSceneletObjects;
	}
	public void setReturnSceneletObjects(ArrayList<ReturnSceneletObject> returnSceneletObjects) {
		this.returnSceneletObjects = returnSceneletObjects;
	}
	
	public void addReturnSceneletObjects(ReturnSceneletObject returnSceneletObject) {
		this.returnSceneletObjects.add(returnSceneletObject);
	}
	
	public void addOtherReturnSceneletObjects(ReturnSceneletObject returnSceneletObject) {
		this.otherReturnSceneletObjects.add(returnSceneletObject);
	}
	
	
	
	private String command;
	private String actionk;
	private String verb;
	
	private String speechURL;
	private String text;
	private String type;
	private String characterName;
	private String setName;
	
	
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getSpeechURL() {
		return speechURL;
	}
	public void setSpeechURL(String speechURL) {
		this.speechURL = speechURL;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}



	private ArrayList<ReturnSceneletObject> returnSceneletObjects = new ArrayList<ReturnSceneletObject>();
	private ArrayList<ReturnSceneletObject> otherReturnSceneletObjects = new ArrayList<ReturnSceneletObject>();
	public ArrayList<ReturnSceneletObject> getOtherReturnSceneletObjects() {
		return otherReturnSceneletObjects;
	}
	public void setOtherReturnSceneletObjects(ArrayList<ReturnSceneletObject> otherReturnSceneletObjects) {
		this.otherReturnSceneletObjects = otherReturnSceneletObjects;
	}
}

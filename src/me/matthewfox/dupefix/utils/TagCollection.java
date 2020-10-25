package me.matthewfox.dupefix.utils;

public class TagCollection {
	
	String text;
	
	public TagCollection(String text) {
		this.text = text;
	}
	
	public String get(String tag){
		return text.split(tag)[1].split(";")[0].replaceFirst(":", "");
	}
	
	public boolean isTrue(String tag){
		return text.split(tag)[1].split(";")[0].replaceFirst(":", "").equalsIgnoreCase("true");
	}
	
	public String[] lines(){
		return text.split(";");
	}
}

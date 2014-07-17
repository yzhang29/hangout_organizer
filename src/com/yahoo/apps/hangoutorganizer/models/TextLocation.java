package com.yahoo.apps.hangoutorganizer.models;

public class TextLocation extends Location {

	private String locationString;
	
	public TextLocation(String locationString) {
		this.locationString = locationString;
	}
	
	@Override
	public String getParameter() {
		return "location";
	}

	@Override
	public String getParameterValue() {
		return locationString;
	}

}

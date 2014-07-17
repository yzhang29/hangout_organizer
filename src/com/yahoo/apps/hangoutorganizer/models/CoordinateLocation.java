package com.yahoo.apps.hangoutorganizer.models;

public class CoordinateLocation extends Location {

	private Double latitude;
	private Double longitude;
	private Double accuracy;
	private Double altitude;
	private Double altitudeAccuracy;
	
	public CoordinateLocation(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public CoordinateLocation(Double latitude, Double longitude, Double accuracy) {
		this(latitude, longitude);
		this.accuracy = accuracy;
	}
	
	public CoordinateLocation(Double latitude, Double longitude, Double accuracy, Double altitude) {
		this(latitude, longitude, accuracy);
		this.altitude = altitude;
	}
	
	public CoordinateLocation(Double latitude, Double longitude, Double accuracy, Double altitude, Double altitudeAccuracy) {
		this(latitude, longitude, accuracy, altitude);
		this.altitudeAccuracy = altitudeAccuracy;
	}
	
	@Override
	public String getParameter() {
		return "ll";
	}

	@Override
	public String getParameterValue() {
		StringBuilder paramSb = new StringBuilder(latitude.toString() + "," + longitude.toString());
		if (accuracy != null) {
			paramSb.append("," + accuracy.toString());
		}
		if (altitude != null) {
			paramSb.append("," + altitude.toString());
		}
		if (altitudeAccuracy != null) {
			paramSb.append("," + altitudeAccuracy.toString());
		}
		return paramSb.toString();
	}

}

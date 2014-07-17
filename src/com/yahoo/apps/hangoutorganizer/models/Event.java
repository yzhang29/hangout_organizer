package com.yahoo.apps.hangoutorganizer.models;

import java.util.Date;
import java.util.List;

public class Event {
	private User creater;
	private String title;
	private String description;
	// private Location location;
	private String location;
	private List<User> guests;
	// private Date date;
	private String date;

	public Event(String t, String l, String d) {
		title = t;
		location = l;
		date = d;
	}

	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<User> getGuests() {
		return guests;
	}

	public void setGuests(List<User> guests) {
		this.guests = guests;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}

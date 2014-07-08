package com.yahoo.apps.hangoutorganizer.models;

import java.util.Date;
import java.util.List;

public class Event {
	private User creater;
	private String title;
	private String description;
	private Location location;
	private List<User> guests;
	private Date date;
}

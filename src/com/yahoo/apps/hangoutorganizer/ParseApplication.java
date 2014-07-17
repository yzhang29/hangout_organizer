package com.yahoo.apps.hangoutorganizer;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		 Parse.initialize(this, "QHgp5nFbpgbtaicT4pDVts4ZxdI82NDw8aaWvuET", "aoBs4bpAsw6QnOLRJjO8m7E0fxJWwbG9tzegibvM");
		 ParseObject testObject = new ParseObject("TestObject");
		 testObject.put("foo", "bar");
		 testObject.saveInBackground();
	}
	

}

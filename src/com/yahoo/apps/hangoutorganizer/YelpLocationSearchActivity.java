package com.yahoo.apps.hangoutorganizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class YelpLocationSearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yelp_location_search);
	}
	
	public void saveLocation(View v){
		Intent i = new Intent();
		i.putExtra("location", "Yahoo");
		setResult(RESULT_OK, i);
		finish();
	}
}

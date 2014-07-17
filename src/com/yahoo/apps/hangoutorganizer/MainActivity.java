package com.yahoo.apps.hangoutorganizer;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.yahoo.apps.hangoutorganizer.fragments.CreateEventFragment;
import com.yahoo.apps.hangoutorganizer.fragments.ViewEventFragment;
import com.yahoo.apps.hangoutorganizer.listener.FragmentTabListener;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupTabs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	private void setupTabs() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		
		Tab tab1 = actionBar
				.newTab()
				.setText("New Event")
				.setTag("CreateEventFragment")
				.setTabListener(new FragmentTabListener<CreateEventFragment>(
								R.id.fl_container, this, "new_event",
								CreateEventFragment.class));
		

		actionBar.addTab(tab1);
		actionBar.selectTab(tab1);
		
		Tab tab2 = actionBar
				.newTab()
				.setText("View Event")
				.setTag("ViewEventFragment")
				.setTabListener(new FragmentTabListener<ViewEventFragment>(
								R.id.fl_container, this, "view_event",
								ViewEventFragment.class));
		
		actionBar.addTab(tab2);

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		CreateEventFragment createEventFragment = (CreateEventFragment) getSupportFragmentManager().findFragmentByTag("new_event");
		if(requestCode == 1 && resultCode == RESULT_OK){
			Log.d("ChengMa","location get data: "+ data.getStringExtra("location"));
			createEventFragment.setLocation(data.getStringExtra("location"));
		}
	}
	
	
}

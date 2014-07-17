package com.yahoo.apps.hangoutorganizer;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.yahoo.apps.hangoutorganizer.models.Address;
import com.yahoo.apps.hangoutorganizer.models.Business;
import com.yahoo.apps.hangoutorganizer.models.TextLocation;

public class YelpLocationSearchActivity extends Activity {

	private YelpClient client;
	private ArrayList<Business> businesses;
	private BusinessArrayAdapter aBusinesses;
	private ListView lvBusinesses;
	private EditText etTerm;
	private EditText etLocation;
	
	private void setupListViewListener() {
		 	final Context ctx = this;
	        lvBusinesses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            	Address address = businesses.get(position).getAddress();
	            	Log.d("DEBUG", "business: " + businesses.get(position).toString());
	            	Log.d("DEBUG", "address: " + address.toString());
	            	chooseLocation(address);
	            }
	        });
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yelp_location_search);
		client = RestApp.getYelpClient();
		businesses = new ArrayList<Business>();
		aBusinesses = new BusinessArrayAdapter(this, businesses);
		lvBusinesses = (ListView) findViewById(R.id.lvBusinesses);
		lvBusinesses.setAdapter(aBusinesses);
		etTerm = (EditText) findViewById(R.id.etTerm);
		etLocation = (EditText) findViewById(R.id.etLocation);
		etTerm.requestFocus();
		setupListViewListener();
	}
	
	public void searchYelp(View v) {
		String term = etTerm.getText().toString();
		String location = etLocation.getText().toString();
		aBusinesses.clear();
		Log.d("DEBUG", "Searching for: " + term + " In: " + location);
		client.search(new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(int code, JSONObject body) {
				try {
					Log.d("DEBUG", "HEY THERE!!!");
					JSONArray businessesJson = body.getJSONArray("businesses");
					ArrayList<Business> businesses = Business.fromJSONArray(businessesJson);
					aBusinesses.addAll(businesses);
					Log.d("DEBUG", businesses.toString());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Throwable e, String s) {
				Log.d("DEBUG", "FAIL!!!!!");
				Log.d("DEBUG", e.toString());
				Log.d("DEBUG", s.toString());
			}
			
			@Override
			public void onStart() {
		        Log.d("DEBUG", "Sending Yelp request...");
		    }
			
			@Override
			public void onFinish() {
				Log.d("DEBUG", "Request finished!");
			}
		}, term, new TextLocation(location));
	}
	
	public final void chooseLocation(Address address){
		Intent i = new Intent();
		i.putExtra("location", address.toString());
		setResult(RESULT_OK, i);
		finish();
	}
}

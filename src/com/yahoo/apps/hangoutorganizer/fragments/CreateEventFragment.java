package com.yahoo.apps.hangoutorganizer.fragments;

import java.text.ParseException;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.yahoo.apps.hangoutorganizer.R;
import com.yahoo.apps.hangoutorganizer.YelpLocationSearchActivity;

public class CreateEventFragment extends Fragment {
	EditText etEventName, etDetails, etLocation, etDate, etFriends;
	Button btnCreate, btnAddLocation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.create_event, container, false);
		etEventName = (EditText) v.findViewById(R.id.et_eventName);
		etDetails = (EditText) v.findViewById(R.id.et_details);
		etLocation = (EditText) v.findViewById(R.id.et_location);
		etDate = (EditText) v.findViewById(R.id.et_date);
		etFriends = (EditText) v.findViewById(R.id.et_friends);
		btnCreate = (Button)v.findViewById(R.id.btn_create);
		btnAddLocation = (Button)v.findViewById(R.id.btn_location);
		setButtonListener();
		return v;
	}

	public void createEvent(View v) throws ParseException {
//		Log.d("ChengMa","Event name: "+etEventName.getText()
//				+" details: "+etDetails.getText()
//				+" location: "+etLocation.getText()
//				+" date: "+etDate.getText()
//				+" friends: "+etFriends.getText());
		ParseObject event = new ParseObject("Event");
		event.put("username","ChengMa");
		event.put("eventName",etEventName.getText().toString());
		event.put("details",etDetails.getText().toString());
		event.put("location",etLocation.getText().toString());
		event.put("date",etDate.getText().toString());
		event.put("friends",etFriends.getText().toString());
		event.saveInBackground(new SaveCallback() {
			@Override
			public void done(com.parse.ParseException e) {
				if(e == null){
					Toast.makeText(getActivity(), "Successfully create event", Toast.LENGTH_SHORT).show();;
				}else{
					Toast.makeText(getActivity(), "Fail to create event", Toast.LENGTH_SHORT).show();
				}
			}
		} );
	}
	
	private void setButtonListener(){
		btnCreate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					createEvent(v);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
		
		btnAddLocation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), YelpLocationSearchActivity.class);
				getActivity().startActivityForResult(i, 1);
			}
		});
	}
	
	public void setLocation(String location){
		etLocation.setText(location);
	}

}

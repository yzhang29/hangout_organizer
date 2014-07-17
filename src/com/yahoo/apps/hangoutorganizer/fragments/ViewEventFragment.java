package com.yahoo.apps.hangoutorganizer.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yahoo.apps.hangoutorganizer.EventListAdapter;
import com.yahoo.apps.hangoutorganizer.R;
import com.yahoo.apps.hangoutorganizer.models.Event;

public class ViewEventFragment extends Fragment {
	
	ListView lvEvents;
	List<Event> eventList = new ArrayList<Event>();
	EventListAdapter elAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.view_event, container, false);
		lvEvents = (ListView) v.findViewById(R.id.lv_events);
		getEvents();
		elAdapter = new EventListAdapter(getActivity(), eventList);
		lvEvents.setAdapter(elAdapter);
		return v;
	}
	
	public void getEvents(){
//		Event e1 = new Event("Play basketBall", "Toyota Center", "2014-12-3 8:00");
//		Event e2 = new Event("Eat outside", "Subway", "2014-11-7 12:00");
//		Event e3 = new Event("Watch baseball game", "SF Giants Center", "2014-9-3 20:00");
//		eventList.add(e1);
//		eventList.add(e2);
//		eventList.add(e3);
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
		query.whereEqualTo("username", "ChengMa");
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> objList, ParseException e) {
		        if (e == null) {
		        	for(ParseObject obj:objList){
		        		Event event = new Event(obj.getString("eventName"),obj.getString("location"),obj.getString("date"));
		        		eventList.add(event);
		        	}
		        } else {
		            Log.d("ChengMa", "Error: " + e.getMessage());
		        }
		        elAdapter.notifyDataSetChanged();
		    }
		});
	}

	

}

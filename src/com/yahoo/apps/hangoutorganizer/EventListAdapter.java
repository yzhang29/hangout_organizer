package com.yahoo.apps.hangoutorganizer;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yahoo.apps.hangoutorganizer.models.Event;

public class EventListAdapter extends ArrayAdapter<Event> {
	TextView eventName, location, date;
	
	public EventListAdapter(Context context, List<Event> events) {
		super(context, 0, events);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			v = inflater.inflate(R.layout.event_list, parent, false);
		} else {
			v = convertView;
		}
		eventName = (TextView) v.findViewById(R.id.tv_eventName);
		location =(TextView) v.findViewById(R.id.tv_location);
		date = (TextView)v.findViewById(R.id.tv_date);
		
		Event event= getItem(position);
		eventName.setText(event.getTitle());
		location.setText(event.getLocation());
		date.setText(event.getDate());
		
		return v;
	}

}

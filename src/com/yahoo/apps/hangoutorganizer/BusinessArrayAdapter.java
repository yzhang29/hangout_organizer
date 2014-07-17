package com.yahoo.apps.hangoutorganizer;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.yahoo.apps.hangoutorganizer.models.Business;

public class BusinessArrayAdapter extends ArrayAdapter<Business> {
	
	public BusinessArrayAdapter(Context context, List<Business> businesses) {
		super(context, 0, businesses);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Business business = getItem(position);
		View v;
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			v = inflater.inflate(R.layout.business_item, parent, false);
		} else {
			v = convertView;
		}
		
		RoundedImageView ivProfileImage = (RoundedImageView) v.findViewById(R.id.ivProfileImage);
		ImageView ivRating = (ImageView) v.findViewById(R.id.ivRating);
		TextView tvName = (TextView) v.findViewById(R.id.tvName);
		ivProfileImage.setImageResource(android.R.color.transparent);
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.displayImage(business.getImageUrl(), ivProfileImage);
		imageLoader.displayImage(business.getRatingImageUrlLarge(), ivRating);
		tvName.setText(business.getName());
		return v;
	}
}

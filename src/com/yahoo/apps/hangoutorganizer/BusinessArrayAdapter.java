package com.yahoo.apps.hangoutorganizer;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
		final Context ctx = this.getContext();
		
		RoundedImageView ivProfileImage = (RoundedImageView) v.findViewById(R.id.ivProfileImage);
		ImageView ivRating = (ImageView) v.findViewById(R.id.ivRating);
		TextView tvName = (TextView) v.findViewById(R.id.tvName);
		ivProfileImage.setImageResource(android.R.color.transparent);
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.displayImage(business.getImageUrl(), ivProfileImage);
		imageLoader.displayImage(business.getRatingImageUrlSmall(), ivRating);
		tvName.setText(business.getName());
		
		ivProfileImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(ctx, "RETURN TO ACTIVITY!", Toast.LENGTH_SHORT).show();
			}
			
		});
		return v;
	}
}

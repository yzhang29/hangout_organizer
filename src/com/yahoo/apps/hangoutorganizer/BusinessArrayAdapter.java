package com.yahoo.apps.hangoutorganizer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
		
		/*RoundedImageView ivProfileImage = (RoundedImageView) v.findViewById(R.id.ivProfileImage);
		TextView tvUserName = (TextView) v.findViewById(R.id.tvComposeUserName);
		TextView tvUserScreenName = (TextView) v.findViewById(R.id.tvUserScreenName);
		TextView tvBody = (TextView) v.findViewById(R.id.tvBody);
		TextView tvCreatedAt = (TextView) v.findViewById(R.id.tvCreatedAt);
		TextView tvRetweets = (TextView) v.findViewById(R.id.tvRetweets);
		TextView tvFavorites = (TextView) v.findViewById(R.id.tvFavorites);
		ivProfileImage.setImageResource(android.R.color.transparent);
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.displayImage(tweet.getUser().getProfileImageUrl(), ivProfileImage);
		tvUserName.setText(tweet.getUser().getName());
		tvUserScreenName.setText("@" + tweet.getUser().getScreenName());
		tvBody.setText(tweet.getBody());
		tvCreatedAt.setText(getRelativeTimeAgo(tweet.getCreatedAt()));
		tvRetweets.setText(formatNumberWithSuffix(tweet.getRetweetCount()));
		tvFavorites.setText(formatNumberWithSuffix(tweet.getFavoriteCount()));
		
		ivProfileImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((TweetListActivity) getContext()).openUserProfile(tweet.getUser());
			}
			
		});*/
		return v;
	}
}

package com.yahoo.apps.hangoutorganizer.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Business implements Serializable {
	private static final long serialVersionUID = 3427552831573129803L;
	private String id;
	private String name;
	private String phone;
	private String imageUrl;
	private String ratingImageUrl;
	private String ratingImageUrlSmall;
	private String ratingImageUrlLarge;
	private Address address;
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public String getId() {
		return id;
	}

	public String getRatingImageUrl() {
		return ratingImageUrl;
	}

	public String getRatingImageUrlSmall() {
		return ratingImageUrlSmall;
	}
	
	public String getRatingImageUrlLarge() {
		return ratingImageUrlLarge;
	}
	
	public Address getAddress() {
		return address;
	}

	public static Business fromJSON(JSONObject jsonObject) {
		Business b = new Business();
        
		try {
			b.id = jsonObject.getString("id");
        	b.name = jsonObject.getString("name");
        	b.phone = jsonObject.getString("display_phone");
        	b.imageUrl = jsonObject.getString("image_url");
        	b.ratingImageUrl = jsonObject.getString("rating_img_url");
        	b.ratingImageUrlSmall = jsonObject.getString("rating_img_url_small");
        	b.ratingImageUrlLarge = jsonObject.getString("rating_img_url_large");
        	b.address = Address.fromJSON(jsonObject.getJSONObject("location"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
		return b;
	}
	
	public static ArrayList<Business> fromJSONArray(JSONArray jsonArray) {
        ArrayList<Business> businesses = new ArrayList<Business>(jsonArray.length());
        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject businessJson = null;
            try {
            	businessJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Business business = Business.fromJSON(businessJson);
            if (business != null) {
            	businesses.add(business);
            }
        }

        return businesses;
    }
    
    @Override
    public String toString() {
    	return id + " " + name + " " + phone + " " + imageUrl + " " + ratingImageUrl;
    }
}

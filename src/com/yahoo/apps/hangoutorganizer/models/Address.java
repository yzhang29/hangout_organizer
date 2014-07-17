package com.yahoo.apps.hangoutorganizer.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Address implements Serializable {
	
	private static final long serialVersionUID = 327430838737414374L;
	private String crossStreets;
	private String city;
	private ArrayList<String> displayAddress;
	private ArrayList<String> neighborhoods;
	private String postalCode;
	private String countryCode;
	private String address;
	private String stateCode;
	
	private static void populateArrayListFromStringArray(ArrayList<String> list, JSONArray jsonArray) {
		for (int i=0; i < jsonArray.length(); i++) {
            String str = null;
            try {
            	str = jsonArray.getString(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            
            if (str != null) {
            	list.add(str);
            }
        }
	}
	
	
	
	public String getCrossStreets() {
		return crossStreets;
	}



	public String getCity() {
		return city;
	}



	public ArrayList<String> getDisplayAddress() {
		return displayAddress;
	}



	public ArrayList<String> getNeighborhoods() {
		return neighborhoods;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public String getCountryCode() {
		return countryCode;
	}



	public String getAddress() {
		return address;
	}



	public String getStateCode() {
		return stateCode;
	}



	public static Address fromJSON(JSONObject jsonObject) {
		Address a = new Address();
        
		try {
			a.crossStreets = jsonObject.getString("cross_streets");
		} catch (JSONException e) {
			//do nothing
		}
		
		try {
			a.neighborhoods = new ArrayList<String>();
			populateArrayListFromStringArray(a.neighborhoods, jsonObject.getJSONArray("neighborhoods"));
		} catch (JSONException e) {
			//do nothing
		}
		
		try {
        	a.city = jsonObject.getString("city");
        	a.displayAddress = new ArrayList<String>();
        	populateArrayListFromStringArray(a.displayAddress, jsonObject.getJSONArray("display_address"));
        	a.postalCode = jsonObject.getString("postal_code");
        	a.countryCode = jsonObject.getString("country_code");
        	a.address = jsonObject.getString("address");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
		return a;
	}
	
	public static ArrayList<Address> fromJSONArray(JSONArray jsonArray) {
        ArrayList<Address> addresses = new ArrayList<Address>(jsonArray.length());
        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject addressJson = null;
            try {
            	addressJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Address address = Address.fromJSON(addressJson);
            if (address != null) {
            	addresses.add(address);
            }
        }

        return addresses;
    }
    
    @Override
    public String toString() {
    	if (displayAddress == null || displayAddress.isEmpty()) {
    		return "--";
    	}
    	StringBuilder sb = new StringBuilder(displayAddress.get(0));
    	for (int i=1; i < displayAddress.size(); i++) {
    		sb.append(", " + displayAddress.get(i));
    	}
    	return sb.toString();
    }
}

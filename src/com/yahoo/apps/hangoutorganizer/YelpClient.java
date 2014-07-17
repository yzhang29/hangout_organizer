package com.yahoo.apps.hangoutorganizer;

import org.scribe.builder.api.Api;
import org.scribe.model.Token;

import android.content.Context;
import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.yahoo.apps.hangoutorganizer.models.Location;

public class YelpClient extends OAuthBaseClient {
    public static final Class<? extends Api> REST_API_CLASS = YelpApi.class; 
    public static final String REST_URL = "http://api.yelp.com/v2"; 
    public static final String REST_CONSUMER_KEY = "YkO1eyL-RncCiKGsIsUeGA";       
    public static final String REST_CONSUMER_SECRET = "IoObM9U4d4MEx0nWBezF9Zh9wIE"; 
    public static final String REST_APP_TOKEN = "QWz3nu7Y6ty76hB6Kx7WnNgwLJ7XDY4f";
    public static final String REST_APP_TOKEN_SECRET = "flByPdeGZCshwJn_PgTOM_opdXs";
    public static final String REST_CALLBACK_URL = "oauth://cpyelp"; 
    
    public YelpClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
        client.setAccessToken(new Token(REST_APP_TOKEN, REST_APP_TOKEN_SECRET));
    }
    
    public void search(AsyncHttpResponseHandler handler, String searchTerm, Location location) {
        String apiUrl = getApiUrl("search");
        RequestParams params = new RequestParams();
        
        if (searchTerm != null) {
        	params.put("term", searchTerm);
        }
        
        if (location != null) {
        	params.put(location.getParameter(), location.getParameterValue());
        }
        
        client.get(apiUrl, params, handler);
    }
    
    public void getBusiness(AsyncHttpResponseHandler handler, String businessId) {
    	String apiUrl = getApiUrl("/business/" + businessId);
        client.get(apiUrl, null, handler);
    }
}
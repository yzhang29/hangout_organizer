package com.yahoo.apps.hangoutorganizer;

import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;

public class RestApp extends com.activeandroid.app.Application {
	private static Context context;
	
    @Override
    public void onCreate() {
        super.onCreate();
        //Parse.initialize(this, "QHgp5nFbpgbtaicT4pDVts4ZxdI82NDw8aaWvuET", "aoBs4bpAsw6QnOLRJjO8m7E0fxJWwbG9tzegibvM");
        //ParseFacebookUtils.initialize("672552016165260");
        RestApp.context = this;
        
        // Create global configuration and initialize ImageLoader with this configuration
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
        		cacheInMemory().cacheOnDisc().build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
            .defaultDisplayImageOptions(defaultOptions)
            .build();
        ImageLoader.getInstance().init(config);
    }
    
    public static YelpClient getYelpClient() {
    	return (YelpClient) YelpClient.getInstance(YelpClient.class, RestApp.context);
    }
}
package com.chw323.theworldsmoond;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MoodSelection1 extends Activity implements OnClickListener{
	ImageButton myButtonG;
	ImageButton myButtonS;
	ImageButton myButtonN;
	ImageButton myButtonM;
    private Context mContext;
    private double currentLat;
    private double currentLon;
	


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater =  getLayoutInflater();

	    this.setContentView(R.layout.activity_main); 
		super.onCreate(savedInstanceState);
		ParseAnalytics.trackAppOpened(getIntent());
		mContext = this.getApplicationContext();
		GPSTracker gps = new GPSTracker(this);
         int status = 0;
         if (gps.canGetLocation()) {
             status = GooglePlayServicesUtil
                     .isGooglePlayServicesAvailable(getApplicationContext());

             if (status == ConnectionResult.SUCCESS) {
                currentLat = gps.getLatitude(); 
                currentLon = gps.getLongitude();
               
                 Log.d("dashlatlongon", "" + Double.toString(currentLat) + "-"
                         + Double.toString(currentLon));

                
             } else {
                 
             }

         } else {
             gps.showSettingsAlert();
         }
		
		
	    final View view1 = inflater.inflate(R.layout.moodselection1, null);//
	    final View view2 = inflater.inflate(R.layout.moodselection2, null);//
		setContentView(R.layout.moodselection1);
		
		myButtonG=(ImageButton) findViewById(R.id.ms_button1);
		myButtonS=(ImageButton) findViewById(R.id.ms_button2);
		myButtonN=(ImageButton) findViewById(R.id.ms_button3);
		myButtonM=(ImageButton) findViewById(R.id.ms_button4);

		
		myButtonG.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						  ParseObject moodObject = new ParseObject("MoodObject");
						  moodObject.put("mood", "great!");
						  moodObject.put("lat",Double.toString(currentLat) );
						  moodObject.put("lon",Double.toString(currentLon) );
						  moodObject.saveInBackground();	

						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodView.class);
						startActivity(i);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

					}
				  }
				);
		
		myButtonS.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						  ParseObject moodObject = new ParseObject("MoodObject");
						  moodObject.put("mood", "surprised!");
						  moodObject.put("lat",Double.toString(currentLat) );
						  moodObject.put("lon",Double.toString(currentLon) );
						  moodObject.saveInBackground();
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodView.class);
						startActivity(i);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
		
		myButtonN.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						  ParseObject moodObject = new ParseObject("MoodObject");
						  moodObject.put("mood", "nooo!");
						  moodObject.put("lat",Double.toString(currentLat) );
						  moodObject.put("lon",Double.toString(currentLon) );
						  moodObject.saveInBackground();
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodView.class);
						startActivity(i);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
		
		myButtonM.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						  ParseObject moodObject = new ParseObject("MoodObject");
						  moodObject.put("mood", "mixed");
						  moodObject.put("lat",Double.toString(currentLat) );
						  moodObject.put("lon",Double.toString(currentLon) );
						  moodObject.saveInBackground();
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodView.class);
						startActivity(i);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
	class GPSTracker extends Service implements LocationListener {

	    private final Context mContext;

	    // flag for GPS status
	    boolean isGPSEnabled = false;

	    // flag for network status
	    boolean isNetworkEnabled = false;

	    // flag for GPS status
	    boolean canGetLocation = false;

	    Location location; // location
	    double latitude; // latitude
	    double longitude; // longitude

	    // The minimum distance to change Updates in meters
	    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

	    // The minimum time between updates in milliseconds
	    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

	    // Declaring a Location Manager
	    protected LocationManager locationManager;

	    public GPSTracker(Context context) {
	        this.mContext = context;
	        getLocation();
	    }

	    public Location getLocation() {
	        try {
	            locationManager = (LocationManager) mContext
	                    .getSystemService(LOCATION_SERVICE);

	            // getting GPS status
	            isGPSEnabled = locationManager
	                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

	            // getting network status
	            isNetworkEnabled = locationManager
	                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

	            if (!isGPSEnabled && !isNetworkEnabled) {
	                // no network provider is enabled
	            } else {
	                this.canGetLocation = true;
	                // First get location from Network Provider
	                if (isNetworkEnabled) {
	                    locationManager.requestLocationUpdates(
	                            LocationManager.NETWORK_PROVIDER,
	                            MIN_TIME_BW_UPDATES,
	                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
	                    Log.d("Network", "Network");
	                    if (locationManager != null) {
	                        location = locationManager
	                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	                        if (location != null) {
	                            latitude = location.getLatitude();
	                            longitude = location.getLongitude();
	                        }
	                    }
	                }
	                // if GPS Enabled get lat/long using GPS Services
	                if (isGPSEnabled) {
	                    if (location == null) {
	                        locationManager.requestLocationUpdates(
	                                LocationManager.GPS_PROVIDER,
	                                MIN_TIME_BW_UPDATES,
	                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
	                        Log.d("GPS Enabled", "GPS Enabled");
	                        if (locationManager != null) {
	                            location = locationManager
	                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
	                            if (location != null) {
	                                latitude = location.getLatitude();
	                                longitude = location.getLongitude();
	                            }
	                        }
	                    }
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return location;
	    }


	    public void stopUsingGPS(){
	        if(locationManager != null){
	            locationManager.removeUpdates(GPSTracker.this);
	        }       
	    }


	    public double getLatitude(){
	        if(location != null){
	            latitude = location.getLatitude();
	        }

	        // return latitude
	        return latitude;
	    }


	    public double getLongitude(){
	        if(location != null){
	            longitude = location.getLongitude();
	        }

	        // return longitude
	        return longitude;
	    }


	    public boolean canGetLocation() {
	        return this.canGetLocation;
	    }


	    public void showSettingsAlert(){
	        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

	        // Setting Dialog Title
	        alertDialog.setTitle("GPS is settings");

	        // Setting Dialog Message
	        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

	        // On pressing Settings button
	        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	                mContext.startActivity(intent);
	                dialog.cancel();
	            }
	        });


	        alertDialog.setCancelable(false);
	        alertDialog.show();
	    }

	    @Override
	    public void onLocationChanged(Location location) {
	    }

	    @Override
	    public void onProviderDisabled(String provider) {
	    }

	    @Override
	    public void onProviderEnabled(String provider) {
	    }

	    @Override
	    public void onStatusChanged(String provider, int status, Bundle extras) {
	    }

	    @Override
	    public IBinder onBind(Intent arg0) {
	        return null;
	    }
	    

	}
	@Override
	public void onBackPressed() {
	}
}

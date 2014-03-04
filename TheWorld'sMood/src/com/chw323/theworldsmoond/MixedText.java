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
import android.widget.Toast;

public class MixedText extends Activity implements OnClickListener{
	ImageButton myButtonGC;
    private Context mContext;
    private double currentLat;
    private double currentLon;
    private EditText greatText;
    ParseObject moodData = new ParseObject("mood");


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater =  getLayoutInflater();
		setContentView(R.layout.mixedwords);
	    
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
		
		

		myButtonGC=(ImageButton) findViewById(R.id.greatConfirm);
		greatText=(EditText) findViewById(R.id.greatText);

		

		
		myButtonGC.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						moodData.put("mood", "mixed!");
						moodData.put("lat",Double.toString(currentLat) );
						moodData.put("lon",Double.toString(currentLon) );
						
						if (greatText.getText().toString()!=null) {
							moodData.put("moodString", greatText.getText().toString());
						}else{
							
							moodData.put("moodString","Nothing special to say.");
						}
						moodData.saveInBackground();	

						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MixedText.this, MoodView.class);
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
	

	
}
	

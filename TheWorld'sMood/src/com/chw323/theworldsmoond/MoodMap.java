package com.chw323.theworldsmoond;

import java.util.List;

import com.chw323.theworldsmoond.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class MoodMap extends Activity implements OnClickListener{
	Button mmButton1;
	Button mmButton2;
	Button mmButton3;
	private GoogleMap map;

	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moodmap);
        GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
			ParseAnalytics.trackAppOpened(getIntent());
			
			loadData();
		
		
		
		mmButton1=(Button) findViewById(R.id.mm_button1);
		mmButton2=(Button) findViewById(R.id.mm_button2);
		mmButton3=(Button) findViewById(R.id.mm_button3);
		
		mmButton1.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodMap.this, MoodSelection1.class);
						startActivity(i);
					}
				  }
				);
		
		mmButton2.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodMap.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mmButton3.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodMap.this, MoodList.class);
						startActivity(i);
					}
				  }
				);
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	public void loadData(){
		ParseQuery<ParseObject> query = ParseQuery.getQuery("mood");
		
		query.findInBackground(new FindCallback<ParseObject>() {
		  

		@Override
		public void done(List<ParseObject> objects, ParseException e) {
			// TODO Auto-generated method stub
			if (e == null) {
				 for (int i = 0; i < objects.size(); i++) {
					 ParseObject moodObject=objects.get(i);
					String moodString= moodObject.getString("mood");
					Double latValueDouble=Double.parseDouble(moodObject.getString("lat"));
					Double lonValueDouble=Double.parseDouble(moodObject.getString("lon"));
					LatLng posLatLng = new LatLng(latValueDouble, lonValueDouble);
					 
					 Marker moodMarker = map.addMarker(new MarkerOptions().position(posLatLng).title(moodString));
					 map.moveCamera(CameraUpdateFactory.newLatLngZoom(posLatLng, 16));
				 }
	        } else {
	            
	        }
			
		}
		});

	}
}

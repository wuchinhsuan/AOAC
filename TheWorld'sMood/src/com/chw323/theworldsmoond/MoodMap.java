package com.chw323.theworldsmoond;

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


public class MoodMap extends FragmentActivity implements OnClickListener{
	Button mmButton1;
	Button mmButton2;
	Button mmButton3;
	private GoogleMap map;

	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moodmap);
		map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

		ParseAnalytics.trackAppOpened(getIntent());
		
		
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
}

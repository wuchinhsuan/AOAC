package com.chw323.theworldsmoond;

import java.util.List;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MoodView extends Activity{
	private GoogleMap map;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

		ParseAnalytics.trackAppOpened(getIntent());
		
		loadData();
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

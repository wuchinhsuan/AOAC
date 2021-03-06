package com.chw323.theworldsmoond;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MoodView extends Activity {
	ImageButton myButtonM;
	private GoogleMap map;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moodmap);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.setMyLocationEnabled(true);
		map.getUiSettings().setMyLocationButtonEnabled(true);
		try {
    		CameraUpdate center=
			        CameraUpdateFactory.newLatLng(new LatLng(map.getMyLocation().getLatitude(),map.getMyLocation().getLongitude()));
			    CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);

			    map.moveCamera(center);
			    map.animateCamera(zoom);
			    
		} catch (Exception e) {

		}
		
		
		
		ParseAnalytics.trackAppOpened(getIntent());
		
		
		loadData();
		
myButtonM=(ImageButton) findViewById(R.id.map_button1);

		
		myButtonM.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodView.this, MoodSelection1.class);
						startActivity(i);
						overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

					}
				  }
				);
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
					String nameString= moodObject.getString("mood");
					String moodString= moodObject.getString("moodString");
					Double latValueDouble=Double.parseDouble(moodObject.getString("lat"));
					Double lonValueDouble=Double.parseDouble(moodObject.getString("lon"));
					LatLng posLatLng = new LatLng(latValueDouble, lonValueDouble);
		 
						if(nameString.equals("great!")){
							 Marker greatMarker = map.addMarker(new MarkerOptions().position(posLatLng).title(nameString).snippet(moodString).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_great)));
							 map.moveCamera(CameraUpdateFactory.newLatLngZoom(posLatLng, 16));
							}else if(nameString.equals("nooo!")){
								Marker noooMarker = map.addMarker(new MarkerOptions().position(posLatLng).title(nameString).snippet(moodString).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_nooo)));
								 map.moveCamera(CameraUpdateFactory.newLatLngZoom(posLatLng, 16));
							}else if(nameString.equals("mixed")){
								Marker mixedMarker = map.addMarker(new MarkerOptions().position(posLatLng).title(nameString).snippet(moodString).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_mixed)));
								 map.moveCamera(CameraUpdateFactory.newLatLngZoom(posLatLng, 16));
							}else if(nameString.equals("surprised!")){
								Marker surprisedMarker = map.addMarker(new MarkerOptions().position(posLatLng).title(nameString).snippet(moodString).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_surprised)));
								 map.moveCamera(CameraUpdateFactory.newLatLngZoom(posLatLng, 16));
							}
				 }
	        } else {
	            
	        }
			
		}
		});


	}
	@Override
	public void onBackPressed() {
		Intent i= new Intent(MoodView.this, MoodSelection1.class);
		startActivity(i);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	}
}

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

public class MoodSelection1 extends Activity implements OnClickListener{
	ImageButton myButtonG;
	ImageButton myButtonS;
	ImageButton myButtonN;
	ImageButton myButtonM;
	ImageButton myButtonSM;
    private Context mContext;
    private double currentLat;
    private double currentLon;
    ParseObject moodData = new ParseObject("mood");


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater =  getLayoutInflater();
		setContentView(R.layout.moodselection1);
		
		
		myButtonG=(ImageButton) findViewById(R.id.ms_button1);
		myButtonS=(ImageButton) findViewById(R.id.ms_button2);
		myButtonN=(ImageButton) findViewById(R.id.ms_button3);
		myButtonM=(ImageButton) findViewById(R.id.ms_button4);
		myButtonSM=(ImageButton) findViewById(R.id.imageButton1);
		
		myButtonG.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent g= new Intent(MoodSelection1.this, GreatText.class);
						startActivity(g);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

					}
				  }
				);
		
		
		myButtonS.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent s= new Intent(MoodSelection1.this, SurprisedText.class);
						startActivity(s);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
		
		myButtonN.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent n= new Intent(MoodSelection1.this, NoooText.class);
						startActivity(n);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
		
		myButtonM.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent m= new Intent(MoodSelection1.this, MixedText.class);
						startActivity(m);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
		
		myButtonSM.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent sm= new Intent(MoodSelection1.this, MoodView.class);
						startActivity(sm);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
		
		
		
		
		
		
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		
		
	}
	

	public void onBackPressed() {
	}
}



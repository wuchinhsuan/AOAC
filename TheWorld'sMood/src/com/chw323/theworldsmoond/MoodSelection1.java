package com.chw323.theworldsmoond;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import android.os.Bundle;
import android.app.Activity;
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
import android.widget.ImageButton;
import android.widget.TextView;

public class MoodSelection1 extends Activity implements OnClickListener{
	ImageButton myButtonG;
	ImageButton myButtonB;
	ImageButton myButtonO;
	Button mdButton1;
	Button mdButton2;
	Button mdButton3;
	Button mdButton4;
	Button mdButton5;
	Button mdButton6;
	Button mdButton7;
	Button mdButton8;
	Button mdButton9;
	


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater =  getLayoutInflater();

	    this.setContentView(R.layout.activity_main); 
		super.onCreate(savedInstanceState);
		ParseAnalytics.trackAppOpened(getIntent());
		
	    final View view1 = inflater.inflate(R.layout.moodselection1, null);//
	    final View view2 = inflater.inflate(R.layout.moodselection2, null);//
		setContentView(R.layout.moodselection1);
		
		myButtonG=(ImageButton) findViewById(R.id.ms_button1);
		myButtonB=(ImageButton) findViewById(R.id.ms_button2);
		myButtonO=(ImageButton) findViewById(R.id.ms_button3);
		mdButton1=(Button) view2.findViewById(R.id.ms2_button1);
		mdButton2=(Button) view2.findViewById(R.id.ms2_button2);
		mdButton3=(Button) view2.findViewById(R.id.ms2_button3);
		mdButton4=(Button) view2.findViewById(R.id.ms2_button4);
		mdButton5=(Button) view2.findViewById(R.id.ms2_button5);
		mdButton6=(Button) view2.findViewById(R.id.ms2_button6);
		mdButton7=(Button) view2.findViewById(R.id.ms2_button7);
		mdButton8=(Button) view2.findViewById(R.id.ms2_button8);
		mdButton9=(Button) view2.findViewById(R.id.ms2_button9);
		
		myButtonG.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						  ParseObject moodObject = new ParseObject("MoodObject");
						  moodObject.put("mood", "great");
						  moodObject.saveInBackground();
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

					}
				  }
				);
		
		myButtonB.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						  ParseObject moodObject = new ParseObject("MoodObject");
						  moodObject.put("mood", "bad");
						  moodObject.saveInBackground();
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodList.class);
						startActivity(i);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
		
		myButtonO.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						setContentView(R.layout.moodselection2);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
				  }
				);
		
		
		mdButton1.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mdButton2.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mdButton3.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mdButton4.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mdButton5.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mdButton6.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mdButton7.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mdButton8.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mdButton9.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodSelection1.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

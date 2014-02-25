package com.chw323.theworldsmoond;

import com.chw323.theworldsmoond.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MoodList extends Activity {
	Button mlButton1;
	Button mlButton2;
	Button mlButton3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moodlist);
		
		mlButton1=(Button) findViewById(R.id.ml_button1);
		mlButton2=(Button) findViewById(R.id.ml_button2);
		mlButton3=(Button) findViewById(R.id.ml_button3);
		
		mlButton1.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodList.this, MoodSelection1.class);
						startActivity(i);
					}
				  }
				);
		
		mlButton2.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodList.this, MoodMap.class);
						startActivity(i);
					}
				  }
				);
		
		mlButton3.setOnClickListener(
				new OnClickListener(){
					@Override
					public void onClick(View arg0){
						Log.v("MainActivity", "Button Clicked");
						Intent i= new Intent(MoodList.this, MoodList.class);
						startActivity(i);
					}
				  }
				);
		
	}
	}


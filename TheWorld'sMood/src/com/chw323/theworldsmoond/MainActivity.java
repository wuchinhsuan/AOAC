package com.chw323.theworldsmoond;

import java.io.IOException;
import java.io.InputStream;
//import com.habibm.customactivitytransition.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MotionEvent;
import android.widget.Toast;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseUser;



public class MainActivity extends Activity implements OnClickListener{
	TextView myTextView1;
	Button myButton1;
    ImageView imageView;
    

    private boolean isTouch = false;
    float x1,x2;
    float y1, y2;
    
    

public void onCreate() {

}

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Parse.initialize(this, "n5ZvMpPy2MC3IVVLzG3eA5G83PzL0QadsYx7rZif", "ZaeWHnsTU4UDLz8e2dS5iB2TZHFl5950yCyv9sed");
		ParseAnalytics.trackAppOpened(getIntent());
	    this.setContentView(R.layout.activity_main); 
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View clickedView) {
			
		}
	@Override
	public void onBackPressed() {
	}
	
	
@Override
public boolean onTouchEvent(MotionEvent touchevent) {
int eventaction = touchevent.getAction();

Intent i= new Intent(MainActivity.this, MoodSelection1.class);



switch (eventaction) {

case MotionEvent.ACTION_DOWN:
    x1 = touchevent.getX();
    y1 = touchevent.getY();
    isTouch = true;
    break;

    case MotionEvent.ACTION_UP: 
    {
    x2 = touchevent.getX();
    y2 = touchevent.getY(); 

    if (isTouch=true){

    	startActivityForResult(i, 500);
    	
    	overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    	
    	
    }
    else if (x1 > x2)
      {
        	startActivityForResult(i, 500);
        	overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
       }
            }
        }
return false;
}
}



	

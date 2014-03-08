package com.chw323.theworldsmoond;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;

import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "n5ZvMpPy2MC3IVVLzG3eA5G83PzL0QadsYx7rZif", "ZaeWHnsTU4UDLz8e2dS5iB2TZHFl5950yCyv9sed");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
	}

}

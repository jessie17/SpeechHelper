package com.example.speechhelper.relax;

import com.example.speechhelper.R;
import com.example.speechhelper.R.layout;
import com.example.speechhelper.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MusicActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.music, menu);
		return true;
	}

}

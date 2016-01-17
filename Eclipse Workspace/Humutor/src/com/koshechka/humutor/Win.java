package com.koshechka.humutor;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends Activity {
	Random rnd = new Random();

	TextView winName;
	Button btnSend, btnImprove, btnSettings;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win);
		
		winName = (TextView) findViewById(R.id.textCongrats);
		btnSend = (Button) findViewById(R.id.buttonShowTries);
		btnImprove = (Button) findViewById(R.id.buttonImprove);
		btnSettings = (Button) findViewById(R.id.buttonSettings);

		Context context = getApplicationContext();
		Bundle bundle = getIntent().getExtras();
		int counter = bundle.getInt("Counter");
		final String name = bundle.getString("Name");
		counter++;
		int[] phrase = new int[] {R.string.congrats1, R.string.congrats2, R.string.congrats3, R.string.congrats4, R.string.congrats5};
		
		winName.setText(String.valueOf(name) + context.getString(phrase[rnd.nextInt(5)]));
		
		btnSend.setText(String.valueOf(counter));
		btnSend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*
				 *  Send email here!
				 */
			}
		});
		
		btnImprove.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int randomnum = rnd.nextInt(9) + 1;
				Intent i = new Intent (v.getContext(), Game.class);
				i.putExtra("Number", randomnum);
				i.putExtra("Name", name);
				startActivity(i);
				finish();
			}
		});
		
		btnSettings.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.win, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	
}

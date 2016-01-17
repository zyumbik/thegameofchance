package com.weird.playthisgameplease;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	Random rnd = new Random();
	Button btnSubmit, btnSettings, btnSend, btnName;
	EditText edtName;
	TextView txtGreeting;
	LinearLayout lytName;
	int rndNumber = rnd.nextInt(9);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lytName = (LinearLayout) findViewById(R.id.layoutName);
		txtGreeting = (TextView) findViewById(R.id.textGreeting);
		txtGreeting.setVisibility(TextView.GONE);
		
		edtName = (EditText) findViewById(R.id.editName);
		btnName = (Button) findViewById(R.id.buttonName);
		btnName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txtGreeting.setText("Welcome, " + edtName.getText() + "!");
				lytName.setVisibility(LinearLayout.GONE);
				txtGreeting.setVisibility(TextView.VISIBLE);
				
			}
		});
		
		btnSubmit = (Button) findViewById(R.id.buttonSubmit);
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
			}
		});
		
		btnSettings = (Button) findViewById(R.id.buttonSettings);
		btnSettings.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
			}
		});
		
		btnSend = (Button) findViewById(R.id.buttonSend);
		btnSend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

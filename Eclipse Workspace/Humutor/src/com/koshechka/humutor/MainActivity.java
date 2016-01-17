package com.koshechka.humutor;

import java.util.Locale;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	Random rnd = new Random();

	RelativeLayout lLeft, lRight;
	EditText edtName;
	String name;
	int number;
	public Locale local = new Locale ("ru");
	public Locale localen = new Locale ("en");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		
		edtName = (EditText) findViewById(R.id.editName);
		name = edtName.getText().toString();
		lLeft = (RelativeLayout) findViewById(R.id.layLeft);
		lRight = (RelativeLayout) findViewById(R.id.layRight);
		
		lLeft.setMinimumWidth(width);
		lRight.setMinimumWidth(width);
		
//		btnRu.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				name = edtName.getText().toString();
//				Configuration c = new Configuration(getResources().getConfiguration());
//				c.locale = local;
//				getResources().updateConfiguration(c, getResources().getDisplayMetrics());
//				intentActivities(name);
//			}
//			
//		});
//		
//		btnEn.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				name = edtName.getText().toString();
//				Configuration c = new Configuration(getResources().getConfiguration());
//				c.locale = localen;
//				getResources().updateConfiguration(c, getResources().getDisplayMetrics());
//				intentActivities(name);
//			}
//		});
//		
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

	private int generateNumber() {
		int i = rnd.nextInt(9) + 1;
		return i;
	}
	
	private void intentActivities(String userName) {
		int genNumber = generateNumber();
		Intent second = new Intent (MainActivity.this, Game.class);
		second.putExtra("Name", userName);
		second.putExtra("Number", genNumber);
		startActivity(second);
		finish();
	}
	
}

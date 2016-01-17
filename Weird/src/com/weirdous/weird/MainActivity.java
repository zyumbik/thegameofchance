package com.weirdous.weird;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	
	boolean chkd;
	
	public void toggle () {
		
	}
	
	public void btnClick (View view) {
		if (chkd) {
			RadioButton b = (RadioButton) findViewById(R.id.radio1);
			b.setChecked(true);
		}
		else {
			RadioButton b = (RadioButton) findViewById(R.id.radio0);
			b.setChecked(true);
		}
	}
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radio0:
	            if (checked)
	                chkd = true;
	            break;
	        case R.id.radio1:
	            if (checked)
	            	chkd = false;
	            break;
	    }
	}
	
}

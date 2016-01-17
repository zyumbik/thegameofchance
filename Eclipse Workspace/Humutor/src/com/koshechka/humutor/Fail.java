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

public class Fail extends Activity {
Random rnd = new Random();
Button btnFail;
TextView smile, failPhrase;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fail);
		
		btnFail = (Button) findViewById(R.id.buttonFail);
		smile = (TextView) findViewById(R.id.textSmile);
		failPhrase = (TextView) findViewById(R.id.textFail);
		
		Context context = getApplicationContext();
		Bundle bundle = getIntent().getExtras();
		final int counter = bundle.getInt("Counter") + 1;
		final int number = bundle.getInt("Number");
		final String name = bundle.getString("Name");
		
		int[] phrase = new int[] {R.string.fail1, R.string.fail2, R.string.fail3, R.string.fail4, R.string.fail5};
		int[] smiles = new int[] {R.string.smile1, R.string.smile2, R.string.smile3, R.string.smile4, R.string.smile5};
		
		failPhrase.setText(context.getString(phrase[rnd.nextInt(5)]));
		smile.setText(context.getString(smiles[rnd.nextInt(5)]));
		
		btnFail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), Game.class);
				i.putExtra("Counter", counter);
				i.putExtra("Number", number);
				i.putExtra("Name", name);
				startActivity(i);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fail, menu);
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

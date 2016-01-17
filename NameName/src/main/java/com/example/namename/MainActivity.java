package com.example.namename;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btn;
	EditText input, output;
	int number, counter;
	int[] userNumber;
	int[] randomNumber;
	StringBuffer sb = new StringBuffer();
	StringBuffer attempt = new StringBuffer(20);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		randomNumber = createArray();
		counter = 0;

		btn = (Button) findViewById(R.id.button);
		input = (EditText) findViewById(R.id.inputText);
		output = (EditText) findViewById(R.id.outputText);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				number = Integer.valueOf(input.getText().toString());
				if (number < 1000) {
					Toast.makeText(getApplicationContext(), "The number should be 4 symbols long!", Toast.LENGTH_LONG).show();
				} else {
					counter++;
					input.setText("");
					//sb.replace(0, sb.length() - 1, output.getText().toString());
					userNumber = createArray(number);
					boolean equal = true;
					if (attempt.length() != 0) {
						attempt.replace(0, attempt.length() - 1, "");
					}
					for (int i = 0; i < randomNumber.length; i++) {
						if (randomNumber[i] == userNumber[i]) {
							attempt.append("Bull ");
						} else {
							attempt.append("Cow ");
							equal = false;
						}
					}
					sb.insert(0, attempt.toString() + "\n");
					output.setText(sb.toString());
					if (equal) {
						Toast.makeText(getApplicationContext(), "You won! Congratulations! The number was " + number, Toast.LENGTH_LONG).show();
						output.setText("Attempts: " + counter);
						counter = 0;
						randomNumber = createArray();
						sb.replace(0, sb.length() - 1, "");
					}
				}


			}
		});
	}

	//Creates a random array of 4 digits
	public static int[] createArray() {
		Random rnd = new Random();
		int number = rnd.nextInt(8999) + 1000;
		int[] array = new int[4];
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = number % 10;
			number /= 10;
		}
		return array;
	}

	//Splits number digits into an array
	public static int[] createArray(int number) {
		int[] array = new int[4];
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = number % 10;
			number /= 10;
		}
		return array;
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

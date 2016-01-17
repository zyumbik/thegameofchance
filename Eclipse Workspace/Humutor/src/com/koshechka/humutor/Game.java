package com.koshechka.humutor;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Game extends Activity {

	Button[] buttons = new Button[9];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		final int[] numbers = Shuffle();
		
		Bundle bundle = getIntent().getExtras();
		final String name = bundle.getString("Name");
		final int unknownNumber = bundle.getInt("Number");
		final int counter = bundle.getInt("Counter");
		
		buttons[0] = (Button)findViewById(R.id.button1);
	    buttons[1] = (Button)findViewById(R.id.button2);
	    buttons[2] = (Button)findViewById(R.id.button3);
	    buttons[3] = (Button)findViewById(R.id.button4);
	    buttons[4] = (Button)findViewById(R.id.button5);
	    buttons[5] = (Button)findViewById(R.id.button6);
	    buttons[6] = (Button)findViewById(R.id.button7);
	    buttons[7] = (Button)findViewById(R.id.button8);
	    buttons[8] = (Button)findViewById(R.id.button9);
	    
	    for (int i = 0; i < numbers.length; i++){
	    	buttons[i].setText("" + numbers[i]);
	    }
	    

	    buttons[0].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 0, unknownNumber, counter, name);
			}
		});
	    
	    buttons[1].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 1, unknownNumber, counter, name);
			}
		});	
	    buttons[2].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 2, unknownNumber, counter, name);
			}
		});	    

	    buttons[3].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 3, unknownNumber, counter, name);
			}
		});	    

	    buttons[4].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 4, unknownNumber, counter, name);
			}
		});	    

	    buttons[5].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 5, unknownNumber, counter, name);
			}
		});	    

	    buttons[6].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 6, unknownNumber, counter, name);
			}
		});	    

	    buttons[7].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 7, unknownNumber, counter, name);
			}
		});	    

	    buttons[8].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launch(numbers, 8, unknownNumber, counter, name);
			}
		}); 
	    
	    
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
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
	
	private int[] Shuffle()
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	    int index;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        if (index != i)
	        {
	            array[index] ^= array[i];
	            array[i] ^= array[index];
	            array[index] ^= array[i];
	        }
	    }
	    return array;
	}
	
	private void launch (int[] numbers, int i, int num, int counter, String name) {
		if (numbers[i] == num) {
			Intent win = new Intent (Game.this, Win.class);
			win.putExtra("Counter", counter);
			win.putExtra("Name", name);
			startActivity(win);
			finish();
		}
		else {
			Intent fail = new Intent (Game.this, Fail.class);
			fail.putExtra("Counter", counter);
			fail.putExtra("Name", name);
			fail.putExtra("Number", num);
			startActivity(fail);
			finish();
		}
	}
	
}

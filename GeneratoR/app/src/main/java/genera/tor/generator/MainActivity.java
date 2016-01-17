package genera.tor.generator;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	Button generate, clear;
	EditText input, output;
	CheckBox checkbox;
	int i = 0;
	int buttonType = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		generate = (Button)findViewById(R.id.buttonGenerate);
		clear = (Button) findViewById(R.id.buttonClear);
		input = (EditText) findViewById(R.id.input);
		checkbox = (CheckBox) findViewById(R.id.check);
		output = (EditText) findViewById(R.id.output);

		clear.setVisibility(View.INVISIBLE);
		checkbox.setVisibility(View.INVISIBLE);
		output.setVisibility(View.INVISIBLE);

		//Double click detector
		generate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				i++;
				Handler handler = new Handler();
				Runnable r = new Runnable() {

					@Override
					public void run() {
						i = 0;
					}
				};
				if (i == 1) {
					handler.postDelayed(r, 250);
					//Single click - generate
					output.setVisibility(View.VISIBLE);
					if ((input.getText().toString().equals("")) && (buttonType != -1)) {
						output.setText("You\'re rekt");
					} else {
						switch (buttonType) {
							case 0:
								output.setText(generateSomething(Integer.valueOf(input.getText().toString())));
								break;
							case 1:
								output.setText(generateSomething(Integer.valueOf(input.getText().toString()), checkbox.isChecked()));
								break;
							case 2:
								output.setText(generateSomething(checkbox.isChecked()));
								break;
							default:
								if (input.getText().toString().equals("33")) {
									output.setText("7");
								} else {
									output.setVisibility(View.INVISIBLE);
								}
								break;
						}
					}
				} else if (i == 2) {
					i = 0;
					//Double click - change type, clear input, change input type, set visibility
					buttonType = changeButtonType(buttonType);
					generate.setText(buttonChange(buttonType));
					input.setText("");
					output.setVisibility(View.INVISIBLE);
					switch (buttonType) {
						case 0:
							//Number
							input.setInputType(InputType.TYPE_CLASS_NUMBER);
							checkbox.setVisibility(View.INVISIBLE);
							break;
						case 1:
							//Password
							checkbox.setVisibility(View.VISIBLE);
							checkbox.setText("Complicated");
							input.setInputType(InputType.TYPE_CLASS_NUMBER);
							break;
						case 2:
							//Answer
							checkbox.setVisibility(View.VISIBLE);
							checkbox.setText("Simple (Y/N)");
							input.setInputType(InputType.TYPE_CLASS_TEXT);
							break;
						default:
							input.setInputType(InputType.TYPE_CLASS_NUMBER);
							checkbox.setVisibility(View.INVISIBLE);
							break;
					}
				}
			}
		});

	}

	public String buttonChange(int currentType) {
		switch (currentType) {
			case 0:
				return "Number";
			case 1:
				return "Password";
			case 2:
				return "Answer";
			default:
				return "Something went wrong :-S";
		}
	}

	public int changeButtonType(int currentType) {
		if (currentType == 2) {
			return 0;
		} else {
			currentType++;
			return currentType;
		}
	}

	public String generateSomething(int range) {
		Random rnd = new Random();
		try {
			int generatedNumber = rnd.nextInt(range + 1);
			return "" + generatedNumber;
		} catch (IllegalArgumentException e) {
			return "You entered invalid number!";
		}
	}

	public static String generateSomething(int length, boolean isComplicated) {
		Random rnd = new Random();
		StringBuffer sb = new StringBuffer();
		char[] alphabet = new char[78];

		//Filling the array of symbols (0 - 61, chars: 0-9, a-z, A-Z)
		for (int i = 0; i < 10; i++) {
			alphabet[i] = (char) (i + 48);
		}
		for (int i = 10; i < 36; i++) {
			alphabet[i] = (char) (i + 55);
		}
		for (int i = 36; i < 62; i++) {
			alphabet[i] = (char) (i + 61);
		}
		//For complicated passwords (indexes 62 - 77)
		char[] additional = {'!', '?', '#', '$', '%', '(', ')', '.', '+', '*', '^', '/', '@', '_', '~', '&'};
		for (int i = 0; i < additional.length; i++) {
			alphabet[i + 62] = additional[i];
		}

		char character;
		if (isComplicated) {
			for (int i = 0; i <= length; i++) {
				if (i % 5 == 0) {
					sb.append('-');
				} else {
					character = alphabet[rnd.nextInt(78)];
					sb.append(character);
				}
			}
		} else {
			for (int i = 0; i <= length; i++) {
				character = alphabet[rnd.nextInt(62)];
				sb.append(character);
			}
		}

		return sb.toString();
	}

	public String generateSomething(boolean simple) {
		Random rnd = new Random();
		if (simple) {
			int choice = rnd.nextInt(2);
			switch (choice) {
				case 0:
					return "Yes";
				default:
					return "No";
			}
		}
		String[] answers = {"What?", "Are you crazy?", "It\'s totally up to you", "I don\'t know, ask your cat", "100%", "Why would you ask this?", "Just forget", "You\'ll regret"};
		return answers[rnd.nextInt(answers.length)];
	}

}

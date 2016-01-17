package com.notseller.glebsabirzyanov.avianotsales;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	EditText edtName, edtCost, edtClass;
	Button btnGet;
	TextView txtTicket;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edtName = (EditText) findViewById(R.id.editName);
		edtCost = (EditText) findViewById(R.id.editCost);
		edtClass = (EditText) findViewById(R.id.editClass);
		btnGet = (Button) findViewById(R.id.btnGet);
		txtTicket = (TextView) findViewById(R.id.textTicket);
		
		btnGet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (edtCost.getText().length() > 0) {
					Ticket ticket = new Ticket(edtName.getText().toString(), Integer.parseInt(edtCost.getText().toString()), edtClass.getText().toString());
					txtTicket.setText(ticket.getTicket());
				} else {
					Context context = getApplicationContext();
					CharSequence text = "You have to pay us some money (even though you won't get anything)!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					ViewGroup group = (ViewGroup) toast.getView();
					TextView messageTextView = (TextView) group.getChildAt(0);
					messageTextView.setTextSize(35);
					toast.show();
				}
			}
		});

       

	}
}

class Ticket {
	private String name;
	private int cost;
	private String type;
	private String number;


	public Ticket(String name, int cost, String type) {
		Random rnd = new Random();
		if (name.length() == 0) {
			this.name = "Nameless person #" + (rnd.nextInt(966) + 33);
		} else {
			this.name = name;
		}
		if (type.length() == 0) {
			this.type = "Poorest class ever (Luggage Compartment)";
		} else {
			this.type = type;
		}
		this.cost = cost;

		this.number = number();

	}

	private String number() {
		Random rnd = new Random();
		StringBuffer sb = new StringBuffer(10);
		for (int i = 0; i < 10; i++) {
			sb.append(rnd.nextInt(9));
		}
		return sb.toString();
	}

	public String getTicket() {
		return "# " + this.number + "\nName: " + name.toUpperCase() + "\nClass: " + type + "\nPaid for nothing: " + cost;
	}

}

package whoami.iamdeveloper.firebasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Firebase.setAndroidContext(getApplicationContext());
		Firebase firebase = new Firebase("https://the-game-of-chance.firebaseio.com/");
	}
}

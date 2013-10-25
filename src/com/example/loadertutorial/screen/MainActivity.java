package com.example.loadertutorial.screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.example.loadertutorial.R;
import com.example.loadertutorial.screen.fragment.LoaderFragment;

public class MainActivity extends FragmentActivity {

	public static final String TAG = "Main Activity";

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

	public void onMainScreen(View button) {
		switch (button.getId()) {
		case R.id.loaderActivityBtn:
			Log.d(TAG, "Start loader activity");
			startActivity(new Intent(MainActivity.this, LoaderActivity.class));
			break;

		case R.id.loaderFragmentBtn:
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new LoaderFragment()).commit();
			break;

		default:
			break;
		}
	}

}

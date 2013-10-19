package com.example.loadertutorial.screen;

import com.example.loadertutorial.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.View;

public class LoaderActivity extends Activity implements
		LoaderCallbacks<Integer> {

	public static final String TAG = "Loader Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loader);
	}

	@Override
	public Loader<Integer> onCreateLoader(int id, Bundle args) {
		Log.d(TAG, "onCreateLoader. Id is " + Integer.toString(id));
		return null;
	}

	@Override
	public void onLoadFinished(Loader<Integer> loader, Integer data) {
		Log.d(TAG, "onLoadFinished. Id is " + loader.getId());

	}

	@Override
	public void onLoaderReset(Loader<Integer> loader) {
		Log.d(TAG, "onLoaderReset. Id is " + loader.getId());

	}

	public void onLoaderActivity(View button) {
		Log.d(TAG, "Init loader");
		getLoaderManager();
	}

}

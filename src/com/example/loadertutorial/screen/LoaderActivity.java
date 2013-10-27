package com.example.loadertutorial.screen;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.loadertutorial.R;
import com.example.loadertutorial.loader.MyAsyncLoader;

public class LoaderActivity extends FragmentActivity implements
		LoaderCallbacks<Integer> {

	private static final String TAG = "Loader Activity";
	private static final int ASYNC_LOADER_ID = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loader);
		if (getSupportLoaderManager().getLoader(ASYNC_LOADER_ID) != null) {
			Log.d(TAG, "Reconnecting with existing Loader id");
			getSupportLoaderManager().initLoader(ASYNC_LOADER_ID, null, this);
			showProgress();
		}

	}

	@Override
	public Loader<Integer> onCreateLoader(int id, Bundle args) {
		Log.d(TAG, "onCreateLoader. Id is " + Integer.toString(id));
		showProgress();
		switch (id) {
		case ASYNC_LOADER_ID:
			return new MyAsyncLoader(LoaderActivity.this);

		default:
			return null;
		}

	}

	@Override
	public void onLoadFinished(Loader<Integer> loader, Integer data) {
		Log.d(TAG, "onLoadFinished. Id is " + loader.getId());
		switch (loader.getId()) {
		case ASYNC_LOADER_ID:
			Log.d(TAG, "Load is finished. Value is " + Integer.toString(data));
			((TextView) findViewById(R.id.loaderValue)).setText(Integer
					.toString(data));
			break;

		default:
			break;
		}
		hideProgress();
	}

	@Override
	public void onLoaderReset(Loader<Integer> loader) {
		Log.d(TAG, "onLoaderReset. Id is " + loader.getId());

	}

	public void onLoaderActivityScreen(View button) {
		switch (button.getId()) {
		case R.id.startLoaderBtn:
			Log.d(TAG, "Start Loader Button");
			getSupportLoaderManager().initLoader(ASYNC_LOADER_ID, null, this);
			break;

		case R.id.resetLoaderBtn:
			Log.d(TAG, "Reset Loader Button");
			getSupportLoaderManager()
					.restartLoader(ASYNC_LOADER_ID, null, this);
			break;

		default:
			break;
		}
	}

	private void hideProgress() {
		((ProgressBar) findViewById(R.id.progressBarActivity))
				.setVisibility(View.INVISIBLE);
		((Button) findViewById(R.id.startLoaderBtn))
				.setVisibility(View.VISIBLE);
		((Button) findViewById(R.id.resetLoaderBtn))
				.setVisibility(View.VISIBLE);
	}

	private void showProgress() {
		((ProgressBar) findViewById(R.id.progressBarActivity))
				.setVisibility(View.VISIBLE);
		((Button) findViewById(R.id.startLoaderBtn))
				.setVisibility(View.INVISIBLE);
		((Button) findViewById(R.id.resetLoaderBtn))
				.setVisibility(View.INVISIBLE);
	}

}

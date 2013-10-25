package com.example.loadertutorial.screen;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.loadertutorial.R;
import com.example.loadertutorial.loader.MyAsyncLoader;
import com.example.loadertutorial.loader.MyLoader;

public class LoaderActivity extends FragmentActivity implements
		LoaderCallbacks<Integer> {

	private static final String TAG = "Loader Activity";
	private static final int LOADER_ID = 1;
	private static final int ASYNC_LOADER_ID = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loader);

		if (getSupportLoaderManager().getLoader(ASYNC_LOADER_ID) != null) {
			Log.d(TAG, "Reconnecting with existing Loader id");
			startAsyncLoader();
		}
	}

	@Override
	public Loader<Integer> onCreateLoader(int id, Bundle args) {
		Log.d(TAG, "onCreateLoader. Id is " + Integer.toString(id));
		switch (id) {
		case LOADER_ID:
			return new MyLoader(LoaderActivity.this);

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
		case LOADER_ID:
			break;

		case ASYNC_LOADER_ID:
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
			Log.d(TAG, "Init Loader");
			getSupportLoaderManager().initLoader(LOADER_ID, null, this);
			showProgress();
			break;

		case R.id.startAsyncLoaderBtn:
			Log.d(TAG, "Init Async Loader");
			startAsyncLoader();
			break;

		default:
			break;
		}
	}

	private void startAsyncLoader() {
		getSupportLoaderManager().initLoader(ASYNC_LOADER_ID, null, this);
		showProgress();
	}

	private void hideProgress() {
		((ProgressBar) findViewById(R.id.progressBarActivity))
				.setVisibility(View.INVISIBLE);
		((Button) findViewById(R.id.startLoaderBtn))
				.setVisibility(View.VISIBLE);
		((Button) findViewById(R.id.startAsyncLoaderBtn))
				.setVisibility(View.VISIBLE);
	}

	private void showProgress() {
		((ProgressBar) findViewById(R.id.progressBarActivity))
				.setVisibility(View.VISIBLE);
		((Button) findViewById(R.id.startLoaderBtn))
				.setVisibility(View.INVISIBLE);
		((Button) findViewById(R.id.startAsyncLoaderBtn))
				.setVisibility(View.INVISIBLE);
	}

}

package com.example.loadertutorial.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class MyAsyncLoader extends AsyncTaskLoader<Integer> {

	public static final String TAG = "My Async Loader";

	public MyAsyncLoader(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Load data here
	 */
	@Override
	public Integer loadInBackground() {
		Log.d(TAG, "loadInBackground(). Start loading");
		return null;
	}

	@Override
	protected void onForceLoad() {
		Log.d(TAG, "onForceLoad()");
		super.onForceLoad();
	}

	@Override
	public void deliverResult(Integer data) {
		Log.d(TAG, "deliverResult() " + data.toString());
		super.deliverResult(data);
	}

	@Override
	protected void onReset() {
		Log.d(TAG, "onReset()");
		super.onReset();
	}

	@Override
	protected void onStartLoading() {
		Log.d(TAG, "onStartLoading()");
		super.onStartLoading();
	}

	@Override
	protected void onStopLoading() {
		Log.d(TAG, "onStopLoading()");
		super.onStopLoading();
	}

}

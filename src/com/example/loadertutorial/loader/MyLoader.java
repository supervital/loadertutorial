package com.example.loadertutorial.loader;

import android.content.Context;
import android.support.v4.content.Loader;
import android.util.Log;

public class MyLoader extends Loader<Integer> {

	public static final String TAG = "My Loader";

	public MyLoader(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deliverResult(Integer data) {
		Log.d(TAG, "Deliver Result" + data.toString());
		super.deliverResult(data);
	}

	@Override
	protected void onForceLoad() {
		Log.d(TAG, "onForceLoad()");
		super.onForceLoad();
	}

	@Override
	protected void onReset() {
		Log.d(TAG, "onReset()");
		super.onReset();
	}
	
	/*
	 * Load data here
	 */
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

	@Override
	public void reset() {
		Log.d(TAG, "reset()");
		super.reset();
	}

	@Override
	public void stopLoading() {
		Log.d(TAG, "stopLoading()");
		super.stopLoading();
	}

}

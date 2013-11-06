package com.example.loadertutorial.loader;

import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.support.v4.content.Loader;
import android.util.Log;

public class MyLoader extends Loader<Integer> {

	private Integer result;

	public static final String TAG = "My Loader";

	public MyLoader(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deliverResult(Integer data) {
		Log.d(TAG, "Deliver Result" + data.toString());
		super.deliverResult(result);
	}

	/*
	 * Load data here
	 */
	@Override
	protected void onForceLoad() {
		Log.d(TAG, "onForceLoad()");
		loadData();
		super.onForceLoad();
	}

	@Override
	protected void onReset() {
		Log.d(TAG, "onReset()");
		super.onReset();
	}

	@Override
	protected void onStartLoading() {
		Log.d(TAG, "onStartLoading()");
		if (result != null) {
			deliverResult(result);
		}
		if (takeContentChanged() || result == null) {
			forceLoad();
		}
		super.onStartLoading();
	}

	@Override
	protected void onStopLoading() {
		Log.d(TAG, "onStopLoading()");
		deliverResult(1);
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

	private void loadData() {
		try {
			for (int i = 0; i < 15; i++) {
				TimeUnit.SECONDS.sleep(1);
				Log.d(TAG, "Loading..... " + i);
				result = i;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopLoading();
	}

}

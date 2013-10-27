package com.example.loadertutorial.loader;

import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class MyAsyncLoader extends AsyncTaskLoader<Integer> {

	public static final String TAG = "My Async Loader";

	private Integer result;

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
		try {
			for (int i = 0; i < 15; i++) {
				TimeUnit.SECONDS.sleep(1);
				Log.d(TAG, "Loading..... " + i);
				result = i;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;
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
		if (result != null) {
			deliverResult(result);
		}
		if (takeContentChanged() || result == null) {
			forceLoad();
		}
	}

	@Override
	protected void onStopLoading() {
		Log.d(TAG, "onStopLoading()");
		super.onStopLoading();
	}

}

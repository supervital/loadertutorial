package com.example.loadertutorial.screen.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.loadertutorial.R;
import com.example.loadertutorial.loader.MyAsyncLoader;

public class LoaderFragment extends Fragment implements
		LoaderCallbacks<Integer> {

	private static final String TAG = "Loader Fragment";
	private static final int ASYNC_LOADER_ID = 2;

	private View mMainView;
	private LoaderCallbacks<Integer> mLoaderCallBack;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView. Fragment");
		mMainView = inflater.inflate(R.layout.activity_loader, null);
		mLoaderCallBack = this;
		setRetainInstance(true);
		
		if (getLoaderManager().getLoader(ASYNC_LOADER_ID) != null) {
			Log.d(TAG, "Reconnecting with existing Loader id");
			getLoaderManager().initLoader(ASYNC_LOADER_ID, null, this);
			((TextView) mMainView.findViewById(R.id.loaderValue))
					.setText(" --- ");
			showProgress();
		}

		((Button) mMainView.findViewById(R.id.startLoaderBtn))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Log.d(TAG, "Start Loader Button");
						getLoaderManager().initLoader(ASYNC_LOADER_ID, null,
								mLoaderCallBack);
					}
				});

		((Button) mMainView.findViewById(R.id.resetLoaderBtn))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Log.d(TAG, "Reset Loader Button");
						getLoaderManager().restartLoader(ASYNC_LOADER_ID, null,
								mLoaderCallBack);
					}
				});

		return mMainView;
	}

	@Override
	public Loader<Integer> onCreateLoader(int id, Bundle args) {
		Log.d(TAG, "onCreateLoader. Id is " + Integer.toString(id));
		showProgress();
		switch (id) {
		case ASYNC_LOADER_ID:
			return new MyAsyncLoader(getActivity());

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
			((TextView) mMainView.findViewById(R.id.loaderValue))
					.setText(Integer.toString(data));
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

	private void hideProgress() {
		((ProgressBar) mMainView.findViewById(R.id.progressBarActivity))
				.setVisibility(View.INVISIBLE);
		((Button) mMainView.findViewById(R.id.startLoaderBtn))
				.setVisibility(View.VISIBLE);
		((Button) mMainView.findViewById(R.id.resetLoaderBtn))
				.setVisibility(View.VISIBLE);
	}

	private void showProgress() {
		((ProgressBar) mMainView.findViewById(R.id.progressBarActivity))
				.setVisibility(View.VISIBLE);
		((Button) mMainView.findViewById(R.id.startLoaderBtn))
				.setVisibility(View.INVISIBLE);
		((Button) mMainView.findViewById(R.id.resetLoaderBtn))
				.setVisibility(View.INVISIBLE);
	}

}

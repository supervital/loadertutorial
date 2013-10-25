package com.example.loadertutorial.screen.fragment;

import com.example.loadertutorial.R;
import com.example.loadertutorial.loader.MyAsyncLoader;
import com.example.loadertutorial.loader.MyLoader;
import com.example.loadertutorial.screen.LoaderActivity;

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

public class LoaderFragment extends Fragment implements
		LoaderCallbacks<Integer> {

	private static final String TAG = "Loader Fragment";
	private static final int LOADER_ID = 1;
	private static final int ASYNC_LOADER_ID = 2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.activity_loader, null);

		((Button) view.findViewById(R.id.startAsyncLoaderBtn))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						startAsyncLoader(view);
					}
				});

		if (getLoaderManager().getLoader(ASYNC_LOADER_ID) != null) {
			Log.d(TAG, "Reconnecting with existing Loader id");
			startAsyncLoader(view);
		}
		return view;
	}

	private void startAsyncLoader(View view) {
		getLoaderManager().initLoader(ASYNC_LOADER_ID, null, this);
		showProgress(view);
	}

	private void hideProgress(View view) {
		((ProgressBar) view.findViewById(R.id.progressBarActivity))
				.setVisibility(View.INVISIBLE);
		((Button) view.findViewById(R.id.startLoaderBtn))
				.setVisibility(View.VISIBLE);
		((Button) view.findViewById(R.id.startAsyncLoaderBtn))
				.setVisibility(View.VISIBLE);
	}

	private void showProgress(View view) {
		((ProgressBar) view.findViewById(R.id.progressBarActivity))
				.setVisibility(View.VISIBLE);
		((Button) view.findViewById(R.id.startLoaderBtn))
				.setVisibility(View.INVISIBLE);
		((Button) view.findViewById(R.id.startAsyncLoaderBtn))
				.setVisibility(View.INVISIBLE);
	}

	@Override
	public Loader<Integer> onCreateLoader(int id, Bundle args) {
		Log.d(TAG, "onCreateLoader. Id is " + Integer.toString(id));
		switch (id) {
		case LOADER_ID:
			return new MyLoader(getActivity());

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
		case LOADER_ID:
			break;

		case ASYNC_LOADER_ID:
			break;

		default:
			break;
		}

		// hideProgress();

	}

	@Override
	public void onLoaderReset(Loader<Integer> loader) {
		Log.d(TAG, "onLoaderReset. Id is " + loader.getId());

	}

}

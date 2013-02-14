package com.example.westeroshouses;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HouseListFragment extends ListFragment {

	private static final String STATE_ACTIVATED_POSITION = "activated_position";
	private Callbacks mCallbacks = MyCallbacks;
	private int mActivatedPosition = ListView.INVALID_POSITION;
	private List<String> mHouseNamesList;

	private static Callbacks MyCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(String houseName, int pos) {
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHouseNamesList = Arrays.asList(getResources().getStringArray(
				R.array.house_names));

		int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? android.R.layout.simple_list_item_activated_1
				: android.R.layout.simple_list_item_1;

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				layout, android.R.id.text1, mHouseNamesList);
		setListAdapter(adapter);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		if (savedInstanceState != null
				&& savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
			setActivatedPosition(savedInstanceState
					.getInt(STATE_ACTIVATED_POSITION));
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException(
					"Activity must implement fragment's callbacks!");
		}
		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = MyCallbacks;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		mCallbacks.onItemSelected(mHouseNamesList.get(position), position);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mActivatedPosition != ListView.INVALID_POSITION) {
			outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
		}
	}

	public void setActivateOnItemClick(boolean activate) {
		getListView().setChoiceMode(
				activate ? ListView.CHOICE_MODE_SINGLE
						: ListView.CHOICE_MODE_NONE);
	}

	private void setActivatedPosition(int pos) {
		if (pos == ListView.INVALID_POSITION) {
			getListView().setItemChecked(mActivatedPosition, true);
		} else {
			getListView().setItemChecked(pos, true);
		}
		mActivatedPosition = pos;
	}

}
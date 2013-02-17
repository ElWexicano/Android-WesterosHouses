package com.example.westeroshouses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class HouseListActivity extends FragmentActivity implements Callbacks {

	private Boolean mTwoPane = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_house_list);

		if (findViewById(R.id.frame_house_detail) != null) {
			setmTwoPane(true);

			((HouseListFragment) getSupportFragmentManager().findFragmentById(
					R.id.fragment_house_list)).setActivateOnItemClick(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public Boolean getmTwoPane() {
		return mTwoPane;
	}

	public void setmTwoPane(Boolean mTwoPane) {
		this.mTwoPane = mTwoPane;
	}

	@Override
	public void onItemSelected(String name, int id) {
		if (mTwoPane) {
			Bundle arguments = new Bundle();
			arguments.putString(HouseDetailFragment.ARG_ITEM_NAME, name);
			arguments.putInt(HouseDetailFragment.ARG_ITEM_ID, id);
			HouseDetailFragment fragment = new HouseDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.frame_house_detail, fragment).commit();
		} else {
			Intent detailIntent = new Intent(this, HouseDetailActivity.class);
			detailIntent.putExtra(HouseDetailFragment.ARG_ITEM_NAME, name);
			detailIntent.putExtra(HouseDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}

package ie.iamshanedoyle.westeroshouses;

import com.example.westeroshouses.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class HouseDetailActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_house_detail);

		if (savedInstanceState == null) {
			Bundle arguments = new Bundle();
			arguments.putString(HouseDetailFragment.ARG_ITEM_NAME, getIntent()
					.getStringExtra(HouseDetailFragment.ARG_ITEM_NAME));
			arguments.putInt(HouseDetailFragment.ARG_ITEM_ID, getIntent()
					.getIntExtra(HouseDetailFragment.ARG_ITEM_ID, 0));
			HouseDetailFragment fragment = new HouseDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.frame_house_detail, fragment).commit();
		}
	}
}
package ie.iamshanedoyle.westeroshouses;

import java.util.Arrays;
import java.util.List;

import com.example.westeroshouses.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HouseDetailFragment extends Fragment {

	public static final String ARG_ITEM_ID = "item_id";
	public static final String ARG_ITEM_NAME = "item_name";
	private String mHouseDescription = "";
	private String mHouseName = "";
	private List<String> mHouseDescriptionsList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHouseDescriptionsList = Arrays.asList(getResources().getStringArray(
				R.array.house_descriptions));
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mHouseDescription = mHouseDescriptionsList.get(getArguments().getInt(ARG_ITEM_ID));
		}
		if (getArguments().containsKey(ARG_ITEM_NAME)) {
			mHouseName = getArguments().getString(ARG_ITEM_NAME);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_house_detail,
				container, false);

		if (mHouseDescription != null) {
			((TextView) rootView.findViewById(R.id.text_house_description))
					.setText(mHouseDescription);
		}
		if (mHouseName != null) {
			((TextView) rootView.findViewById(R.id.text_house_name))
					.setText(mHouseName);
		}

		return rootView;
	}
}
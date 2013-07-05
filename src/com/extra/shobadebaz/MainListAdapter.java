package com.extra.shobadebaz;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.activity.shobadebaz.MainActivity;
import com.activity.shobadebaz.R;

public class MainListAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;

	public MainListAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.activity_listitem, null);

		TextView title = (TextView) vi.findViewById(R.id.title); // title
		ImageView thumbnail = (ImageView) vi.findViewById(R.id.thumbnail); // title

		HashMap<String, String> item = new HashMap<String, String>();
		item = data.get(position);

		// Setting all values in list view
		title.setText(item.get(MainActivity.KEY_TITLE));

		String listImage = item.get(MainActivity.KEY_THUMBNAIL);

		if (listImage == "icon1") {
			thumbnail.setImageResource(R.drawable.icon1);
		}

		if (listImage == "icon2") {
			thumbnail.setImageResource(R.drawable.icon2);
		}

		if (listImage == "icon3") {
			thumbnail.setImageResource(R.drawable.icon3);
		}

		if (listImage == "icon4") {
			thumbnail.setImageResource(R.drawable.icon4);
		}

		if (listImage == "icon5") {
			thumbnail.setImageResource(R.drawable.icon5);
		}

		if (listImage == "icon") {
			thumbnail.setImageResource(R.drawable.icon);
		}

		return vi;
	}
}
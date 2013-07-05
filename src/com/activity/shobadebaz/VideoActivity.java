package com.activity.shobadebaz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class VideoActivity extends Activity {
	private ListView lv;
	private String listview_array[] = { "Ring | حلقه", "Bar Tricks | رستوران",
			"Bill | اسكناس", "Card | كارت", "Close-Up | محفلي", "Coin | سكه",
			"Illusion | حرفه اي ها", "Levitation | پرواز",
			"Mentalism | ذهن خواني", "Rope | طناب", };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listview_array));
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (arg2) {
				case 0:
					Intent video1 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video1.putExtra("cid", 9);
					startActivity(video1);
					break;

				case 1:
					Intent video2 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video2.putExtra("cid", 10);
					startActivity(video2);
					break;

				case 2:
					Intent video3 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video3.putExtra("cid", 11);
					startActivity(video3);
					break;

				case 3:
					Intent video4 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video4.putExtra("cid", 12);
					startActivity(video4);
					break;

				case 4:
					Intent video5 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video5.putExtra("cid", 13);
					startActivity(video5);
					break;

				case 5:
					Intent video6 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video6.putExtra("cid", 14);
					startActivity(video6);
					break;

				case 6:
					Intent video7 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video7.putExtra("cid", 15);
					startActivity(video7);
					break;

				case 7:
					Intent video8 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video8.putExtra("cid", 16);
					startActivity(video8);
					break;

				case 8:
					Intent video9 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video9.putExtra("cid", 17);
					startActivity(video9);
					break;

				case 9:
					Intent video10 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					video10.putExtra("cid", 18);
					startActivity(video10);
					break;
				}
			}
		});
	}
}

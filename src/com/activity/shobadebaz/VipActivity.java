package com.activity.shobadebaz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VipActivity extends Activity {
	private ListView lv;
	private String listview_array[] = { "V.I.P Magic Movie",
			"V.I.P Magic Book", "V.I.P Magic Music", "Penguin Live",
			"Criss Angel Live", "Essential Magic Conference", };

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
					Intent vip1 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					vip1.putExtra("cid", 3);
					startActivity(vip1);
					break;

				case 1:
					Intent vip2 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					vip2.putExtra("cid", 4);
					startActivity(vip2);
					break;

				case 2:
					Intent vip3 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					vip3.putExtra("cid", 5);
					startActivity(vip3);
					break;

				case 3:
					Intent vip4 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					vip4.putExtra("cid", 6);
					startActivity(vip4);
					break;

				case 4:
					Intent vip5 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					vip5.putExtra("cid", 7);
					startActivity(vip5);
					break;

				case 5:
					Intent vip6 = new Intent(getApplicationContext(),
							ListfileActivity.class);
					vip6.putExtra("cid", 8);
					startActivity(vip6);
					break;
				}
			}
		});
	}
}

package com.activity.shobadebaz;

import java.util.ArrayList;
import java.util.List;

import com.database.shobadebaz.DatabaseHandler;
import com.database.shobadebaz.Item;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListfileActivity extends Activity {

	public int GetId;
	public int SetId;

	private ListView lv;
	private ArrayList<String> listview_title = new ArrayList<String>();
	private ArrayList<Integer> listview_id = new ArrayList<Integer>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			GetId = extras.getInt("cid");
		}

		// Read page from DB
		DatabaseHandler db = new DatabaseHandler(this);
		List<Item> items = db.getAllItemCid(GetId);

		// Add to array
		for (Item cn : items) {
			listview_title.add(cn.getTitle());
			listview_id.add(cn.getId());
		}

		// Make list view
		lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listview_title));
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				SetId = listview_id.get(arg2);

				Intent item = new Intent(getApplicationContext(),
						ItemfileActivity.class);
				item.putExtra("id", SetId);
				startActivity(item);
			}
		});
	}
}

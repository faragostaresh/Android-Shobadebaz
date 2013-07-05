package com.activity.shobadebaz;


import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.database.shobadebaz.DatabaseHandler;
import com.database.shobadebaz.Item;
import com.extra.shobadebaz.MainListAdapter;


public class MainActivity<Index> extends Activity {
	public ListView lv;
	public MainListAdapter adapter;

	public static final String KEY_TITLE = "title";
	public static final String KEY_THUMBNAIL = "thumbnail";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Will remove
		DatabaseHandler db = new DatabaseHandler(this);
		db.addItem(new Item(1, "test title 1", "test body 1", "downloads_50a4ee5f1ba3b.jpg", "test link 1"));
		db.addItem(new Item(1, "test title 2", "test body 1", "downloads_4eea444eeb2ca.jpg", "test link 1"));
		db.addItem(new Item(1, "test title 3", "test body 1", "downloads_518f8ade34c14.jpg", "test link 1"));
		db.addItem(new Item(1, "test title 4", "test body 1", "downloads_4e357ce034fe7.jpg", "test link 1"));
		db.addItem(new Item(1, "test title 5", "test body 1", "downloads_4e5f59cfaa6fa.jpg", "test link 1"));
	    db.addItem(new Item(1, "test title 6", "test body 1", "downloads_4da408147bea4.jpg", "test link 1"));
		db.addItem(new Item(1, "test title 7", "test body 1", "downloads_4da407e1e89ae.jpg", "test link 1"));
		// Will remove

		// Set list array
		ArrayList<HashMap<String, String>> listview_main = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put(KEY_TITLE, "معرفی هنر شعبده بازی");
		map1.put(KEY_THUMBNAIL, "icon1");
		listview_main.add(map1);

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put(KEY_TITLE, "آموزش شعبده بازی");
		map2.put(KEY_THUMBNAIL, "icon2");
		listview_main.add(map2);

		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put(KEY_TITLE, "فروشگاه شعبده باز");
		map3.put(KEY_THUMBNAIL, "icon3");
		listview_main.add(map3);

		HashMap<String, String> map4 = new HashMap<String, String>();
		map4.put(KEY_TITLE, "درباره ما");
		map4.put(KEY_THUMBNAIL, "icon4");
		listview_main.add(map4);

		HashMap<String, String> map5 = new HashMap<String, String>();
		map5.put(KEY_TITLE, "تماس با ما");
		map5.put(KEY_THUMBNAIL, "icon5");
		listview_main.add(map5);

		HashMap<String, String> map6 = new HashMap<String, String>();
		map6.put(KEY_TITLE, "تست");
		map6.put(KEY_THUMBNAIL, "icon");
		listview_main.add(map6);

		// Getting adapter by ArrayList
		adapter = new MainListAdapter(this, listview_main);

		// Set custom list view
		lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(adapter);
		lv.setDivider(null);
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (arg2) {
				case 0:
					startActivity(new Intent(getApplicationContext(),
							HelpActivity.class));
					break;

				case 1:
					startActivity(new Intent(getApplicationContext(),
							LearnActivity.class));
					break;

				case 2:
					startActivity(new Intent(getApplicationContext(),
							ShopActivity.class));
					break;

				case 3:
					startActivity(new Intent(getApplicationContext(),
							AboutActivity.class));
					break;

				case 4:
					startActivity(new Intent(getApplicationContext(),
							ContactActivity.class));
					break;

				case 5:
					Intent test = new Intent(getApplicationContext(),
							ListfileActivity.class);
					test.putExtra("cid", 1);
					startActivity(test);
					break;
				}
			}
		});
	}
}
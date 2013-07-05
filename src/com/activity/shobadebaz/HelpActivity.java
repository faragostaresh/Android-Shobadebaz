package com.activity.shobadebaz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HelpActivity extends Activity {
	private ListView lv;
	private String listview_array[] = { "شعبده باز کیست؟",
			"وسايل شعبده بازي مخصوص هستند؟", "هنر شعبده بازي چيست؟",
			"آموزش شعبده بازی چگونه است؟", "چرا آموزش تصویری؟",
			"وب سایت شعبده باز", "راهنماي عضويت در وب سایت", };

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
					Intent help1 = new Intent(getApplicationContext(),
							ItemfileActivity.class);
					help1.putExtra("id", 1);
					startActivity(help1);
					break;

				case 1:
					Intent help2 = new Intent(getApplicationContext(),
							ItemfileActivity.class);
					help2.putExtra("id", 2);
					startActivity(help2);
					break;

				case 2:
					Intent help3 = new Intent(getApplicationContext(),
							ItemfileActivity.class);
					help3.putExtra("id", 3);
					startActivity(help3);
					break;

				case 3:
					Intent help4 = new Intent(getApplicationContext(),
							ItemfileActivity.class);
					help4.putExtra("id", 4);
					startActivity(help4);
					break;

				case 4:
					Intent help5 = new Intent(getApplicationContext(),
							ItemfileActivity.class);
					help5.putExtra("id", 5);
					startActivity(help5);
					break;

				case 5:
					Intent help6 = new Intent(getApplicationContext(),
							ItemfileActivity.class);
					help6.putExtra("id", 6);
					startActivity(help6);
					break;

				case 6:
					Intent help7 = new Intent(getApplicationContext(),
							ItemfileActivity.class);
					help7.putExtra("id", 7);
					startActivity(help7);
					break;
				}
			}
		});
	}
}

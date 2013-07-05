package com.activity.shobadebaz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.database.shobadebaz.DatabaseHandler;
import com.database.shobadebaz.Item;
import com.extra.shobadebaz.ConnectionDetector;
import com.extra.shobadebaz.ImageLoader;

public class ItemfileActivity extends Activity {

	public int GetId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			GetId = extras.getInt("id");
		}

		// Read page from DB
		DatabaseHandler db = new DatabaseHandler(this);
		Item item = db.getItem(GetId);

		// Set id for layout
		TextView showId = (TextView) findViewById(R.id.showid);
		showId.setText(String.valueOf(item.getId()));

		// Set title for layout
		TextView showTitle = (TextView) findViewById(R.id.showtitle);
		showTitle.setText(item.getTitle());

		// Set body for layout
		TextView showBody = (TextView) findViewById(R.id.showbody);
		showBody.setText(item.getBody());

		// Check connection
		ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
		Boolean isInternetPresent = cd.isConnectingToInternet(); // true or
																	// false
		if (!isInternetPresent) {
			showAlertDialog(ItemfileActivity.this);
		} else {
			// Imageview to show
			ImageView image = (ImageView) findViewById(R.id.showimage);

			// Image url
			String image_url = "http://www.shobadebaz.com/uploads/TDMDownloads/images/shots/"
					+ item.getImage();

			// ImageLoader class instance
			ImageLoader imgLoader = new ImageLoader(getApplicationContext());

			// whenever you want to load an image from url
			// call DisplayImage function
			// url - image url to load
			// image - ImageView
			imgLoader.DisplayImage(image_url, image);
		}

	}

	/**
	 * Function to display simple Alert Dialog
	 * 
	 * @param context
	 **/
	@SuppressWarnings("deprecation")
	public void showAlertDialog(Context context) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(getResources().getString(R.string.d_internet));

		// Setting Dialog Message
		alertDialog.setMessage(getResources().getString(
				R.string.d_internet_image));

		// Setting alert dialog icon
		alertDialog.setIcon(R.drawable.cancel);

		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {

			}
		});

		// Showing Alert Message
		alertDialog.show();
	}
}

package com.activity.shobadebaz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	private static final int SPLASH_DISPLAY_TIME = 2000; // splash screen delay
															// time

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		new Handler().postDelayed(new Runnable() {
			public void run() {

				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, MainActivity.class);

				SplashActivity.this.startActivity(intent);
				SplashActivity.this.finish();

			}
		}, SPLASH_DISPLAY_TIME);
	}
}

/**
 * Copyright (C) 2014 Rus Wizards
 *
 * Created: 11.12.2014
 * Vladimir Farafonov
 */
package com.example.admin.rwlab48;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Main class of the app
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {

	private static final String LATITUDE = "37.422006";
	private static final String LONGITUDE = "-122.084095";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onClick(View v) {
		Intent startNextIntent;
		switch (v.getId()) {
			case R.id.gallery_button:
				/*
				* Starts gallery app.
                * Have some trouble here with gallery apps on emulator (both 4.4 and 5.0). No app
                * can be found and started with CATEGORY_APP_GALLERY intent. So app tries to open
                * standard gallery directly with package name if no apps is found by category.
                */
				startNextIntent = new Intent(Intent.ACTION_MAIN);
				startNextIntent.addCategory(Intent.CATEGORY_APP_GALLERY);
				if (startNextIntent.resolveActivity(getPackageManager()) == null) {
					startNextIntent = getPackageManager().
							getLaunchIntentForPackage("com.android.gallery");
				}
				break;
			case R.id.web_browser_button:
				// Puts in intent browser category
				startNextIntent = new Intent(Intent.ACTION_MAIN);
				startNextIntent.addCategory(Intent.CATEGORY_APP_BROWSER);
				break;
			case R.id.map_button:
				// Puts in intent action to view on a map app coordinates from constants
				startNextIntent = new Intent(Intent.ACTION_VIEW);
				startNextIntent.setData(Uri.parse("geo:" + LATITUDE + "," + LONGITUDE));
				break;
			case R.id.gallery_image_button:
				// Puts in intent action to get content for any type of images
				startNextIntent = new Intent(Intent.ACTION_GET_CONTENT);
				startNextIntent.setType("image/*");
				break;
			case R.id.camera_photo_button:
				// Puts in intent capture image action
				startNextIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				break;
			case R.id.camera_video_button:
				// Puts in intent capture video action
				startNextIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
				break;
			case R.id.dictaphone_button:
				// Puts in intent voice recording action
				startNextIntent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
				break;
			default:
				throw new IllegalStateException(
						getString(R.string.wrong_button_illegal_state_exception));
		}
		if ((startNextIntent.resolveActivity(getPackageManager()) != null)) {
			startNextIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			// Start activity with apps chooser dialog (if it is more than one app)
			Intent chooserIntent = Intent.createChooser(
					startNextIntent, getString(R.string.title_application_chooser));
			startActivity(chooserIntent);
		} else {
			// Toast is shown up if apps not found
			Toast.makeText(this, getString(R.string.toast_application_not_found),
					Toast.LENGTH_SHORT).show();
		}
	}
}

package com.example.testgame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

public class GameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		final Button achievementButton = (Button) findViewById(R.id.achievement);
		achievementButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GameActivity.this,
						AchievementActivity.class);
				startActivity(intent);
			}
		});

		final Button inventoryButton = (Button) findViewById(R.id.inventory);
		inventoryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GameActivity.this,
						InventoryActivity.class);
				startActivity(intent);
			}
		});

		final Button characterButton = (Button) findViewById(R.id.character);
		characterButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GameActivity.this,
						CharacterActivity.class);
				startActivity(intent);
			}
		});

		final Button configButton = (Button) findViewById(R.id.configuration);
		configButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
						.getSystemService(LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(
						R.layout.popup_configuration, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				
			
				
				Button buttonSave = (Button) popupView
						.findViewById(R.id.save);
				buttonSave.setOnClickListener(new Button.OnClickListener() {
					@Override
					public void onClick(View v) {
						// save the game first
						Intent intent = new Intent(GameActivity.this,
								SaveActivity.class);
						startActivity(intent);
						popupWindow.dismiss();
					}
				});
				
				Button buttonLoad = (Button) popupView
						.findViewById(R.id.load);
				buttonLoad.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// load game first
						Toast.makeText(GameActivity.this,
								"Game successifuly loaded!",
								Toast.LENGTH_SHORT).show();
						popupWindow.dismiss();
					}
				});
				
				Button buttonExit = (Button) popupView
						.findViewById(R.id.exit);
				buttonExit.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(GameActivity.this,
								"Back to black",
								Toast.LENGTH_SHORT).show();
						popupWindow.dismiss();
					}
				});
				
			popupWindow.showAtLocation(configButton, Gravity.CENTER , 0, 0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}

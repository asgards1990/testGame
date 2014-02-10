package com.example.testgame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SaveActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save);

		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener () {
				@Override
				public void onClick(View v) {
					
					Toast.makeText(SaveActivity.this,
							"Game successifuly saved!",
							Toast.LENGTH_SHORT).show();
					finish();
				}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.save, menu);
		return true;
	}

}

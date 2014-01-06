package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {
	TextView hello = null;
	Button mystery = null;
	


	
	private OnClickListener clickListenerButton = new View.OnClickListener() {
	    @Override
	    public void onClick(View v) {	
	    	hello = (TextView)findViewById(R.id.hello);
	    	if(hello.getText()=="Hello world!") {
	    		hello.setText("Hell, I'm sick of the \"Hello world!\" message!!!");
	    	}
	    	else hello.setText("Hello world!");
	      
	    }
	  };
	  
	private OnTouchListener touchListenerButton = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			Button button = (Button) v;

			//we get the length and width of the button
			int largeur = button.getWidth();
			
			int hauteur = button.getHeight();

			//we get the position of the touch
			float x = event.getX();
			
			float y = event.getY();
			
			//we adjust the size of the text according to the touch
			button.setTextSize(Math.max(Math.min(Math.abs(x - largeur / 2)
					+ Math.abs(y - hauteur / 2),70),5));
			
			//The touch is over once not wanted
			return false;
		}
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mystery = (Button)findViewById(R.id.mystery);
        mystery.setOnClickListener(clickListenerButton);
        mystery.setOnTouchListener(touchListenerButton);
    }
    
    
}

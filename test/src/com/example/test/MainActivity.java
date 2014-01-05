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

			// On r¨¦cup¨¨re la largeur du bouton
			int largeur = button.getWidth();
			// On r¨¦cup¨¨re la hauteur du bouton
			int hauteur = button.getHeight();

			// On r¨¦cup¨¨re la coordonn¨¦e sur l'abscisse (X) de l'¨¦v¨¨nement
			float x = event.getX();
			// On r¨¦cup¨¨re la coordonn¨¦e sur l'ordonn¨¦e (Y) de l'¨¦v¨¨nement
			float y = event.getY();
			
			button.setTextSize(Math.max(Math.min(Math.abs(x - largeur / 2)
					+ Math.abs(y - hauteur / 2),70),5)); 
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

package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
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
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mystery = (Button)findViewById(R.id.mystery);
        mystery.setOnClickListener(clickListenerButton);
    }
    
    
}

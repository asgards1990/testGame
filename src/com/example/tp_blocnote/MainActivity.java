package com.example.tp_blocnote;


import android.os.Bundle;
import android.text.Editable;
import android.text.Html.ImageGetter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;



public class MainActivity extends Activity {
	
	Button gras = null;
	Button italique = null;
	Button souligne = null;
	Button cacherAfficher = null;
	
	int[] tailleDuMenu = new int[2];
	
	RadioGroup couleurs = null;
	
	EditText edition = null;
	
	TextView previsualisation = null; 

	
	RelativeLayout menu = null;
	RelativeLayout main = null;
	
	private String noir = "#000000";
	private String bleu = "#0000FF";
	private String rouge = "#FF0000";

	boolean isOpen = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gras = (Button)findViewById(R.id.gras);
		italique = (Button)findViewById(R.id.italique);
		souligne = (Button)findViewById(R.id.souligne);
		cacherAfficher = (Button)findViewById(R.id.cacherAfficher);
		
		couleurs = (RadioGroup)findViewById(R.id.couleurs);
		
		edition = (EditText)findViewById(R.id.edition);
		
		
		previsualisation = (TextView)findViewById(R.id.previsualisation);
		
		couleurs.getLocationInWindow(tailleDuMenu);
		
		menu = (RelativeLayout)findViewById(R.id.menu);
		main = (RelativeLayout)findViewById(R.id.main);
		
		
		cacherAfficher.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Button temp = (Button)v;
				Animation animation = null;
				final int[] y = new int[2];
				if (temp.getText().toString().equals("Cacher")) {
					y[0] = 0;
					y[1] = -menu.getHeight();					
					temp.setText("Afficher");
				}
				else {
					y[0] = -menu.getHeight();
					y[1] = 0;
					temp.setText("Cacher");
				}
				
				animation = new TranslateAnimation(0,0,y[0],y[1]);
				animation.setDuration(1450);
				animation.setInterpolator(new BounceInterpolator());
//				animation.setFillAfter(true);
				animation.setFillEnabled(true);
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationEnd(Animation arg0) {
						RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)menu.getLayoutParams();
						params.topMargin += y[1]-y[0];
	                    menu.setLayoutParams(params);
						
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationStart(Animation arg0) {
						
						
					}
					
				});


				LayoutAnimationController animationController = new LayoutAnimationController(animation);
				animationController.setDelay(0);
				main.setLayoutAnimation(animationController);
				
			}
		}); 
		
		edition.addTextChangedListener(new TextWatcher() {
			@Override
			 
			  public void onTextChanged(CharSequence s, int start, int before, int count) {
			    
//				String currentText = edition.getText().toString();
//				currentText = currentText.substring(0,start);
				
				previsualisation.setText(s);
			  }

			  @Override
			  
			  public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			    // Que faire juste avant que le changement de texte soit pris en compte ?
			  }

			  @Override
			  
			  public void afterTextChanged(Editable s) {
		
			  }
		});
		
		couleurs.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged (RadioGroup group, int checkedId)
            {
            	switch(checkedId)
                {
                case R.id.noir:
                    previsualisation.setTextColor(Color.parseColor(noir));
                    break;
                case R.id.bleu:
                	previsualisation.setTextColor(Color.parseColor(bleu));
                    break;
                case R.id.rouge:
                	previsualisation.setTextColor(Color.parseColor(rouge));
                    break;
                }
            	
            }
        });

		
		
//		edition.setOnKeyListener(new View.OnKeyListener() {
//			  
//			  public boolean onKey(View v, int keyCode, KeyEvent event) {
//			    
//				  return true;
//			  }
//			});
//		

		
	}
	
//	public class Exemple implements ImageGetter {
//		  @Override
//		  public Drawable getDrawable(String identifiant) {
//		    Drawable retour = null;
//			
//		    retour = getResources().getDrawable(R.drawable.ic_launcher);
//				
//	
//		    retour.setBounds(0, 0, retour.getIntrinsicWidth(), retour.getIntrinsicHeight());
//		    return retour;
//		  }
//		}

	

}

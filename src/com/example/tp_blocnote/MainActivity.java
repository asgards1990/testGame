package com.example.tp_blocnote;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.TextWatcher;
import android.view.View;
import android.view.KeyEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;




public class MainActivity extends Activity {
	
	public class SmileyGetter implements ImageGetter {
		  /* Context de notre activité */
		  protected Context context = null;
		  
		  public SmileyGetter(Context c) {
		    context = c;
		  }

		  public void setContext(Context context) {
		    this.context = context;
		  }

		  @Override
		  public Drawable getDrawable(String smiley) {
		    Drawable retour = null;
		    
		    // On récupère le gestionnaire de ressources
		    Resources resources = context.getResources();
		    
		    // Si on désire le clin d'œil…
		    if(smiley.equals("smiley1"))
		      // … alors on récupère le drawable correspondant
		      retour = resources.getDrawable(R.drawable.smiley1);
		    else if(smiley.equals("smiley2"))
		      retour = resources.getDrawable(R.drawable.smiley2);
		    else
		      retour = resources.getDrawable(R.drawable.smiley3);
		    // On délimite l'image (elle va de son coin en haut à gauche à son coin en bas à droite)
		    retour.setBounds(0, 0, retour.getIntrinsicWidth(), retour.getIntrinsicHeight());
		    return retour;
		  }
		}
	
	Button gras = null;
	Button italique = null;
	Button souligne = null;
	Button cacherAfficher = null;
	
	ImageButton smiley1 = null;
	ImageButton smiley2 = null;
	ImageButton smiley3 = null;
	
	RadioGroup couleurs = null;
	
	EditText edition = null;
	
	TextView previsualisation = null; 
	
	RelativeLayout menu = null;
	RelativeLayout bloc = null;
	RelativeLayout main = null;
	
	private String noir = "#000000";
	private String bleu = "#0000FF";
	private String rouge = "#FF0000";
	private String currentColor = noir;
	
	private SmileyGetter getter = null;
	
	boolean isOpen = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gras = (Button)findViewById(R.id.gras);
		italique = (Button)findViewById(R.id.italique);
		souligne = (Button)findViewById(R.id.souligne);
		cacherAfficher = (Button)findViewById(R.id.cacherAfficher);
		
		smiley1 =(ImageButton)findViewById(R.id.smiley1);
		smiley2 =(ImageButton)findViewById(R.id.smiley2);
		smiley3 =(ImageButton)findViewById(R.id.smiley3);
		
		getter = new SmileyGetter(this);
		
		couleurs = (RadioGroup)findViewById(R.id.couleurs);
		
		edition = (EditText)findViewById(R.id.edition);
		
		previsualisation = (TextView)findViewById(R.id.previsualisation);
		
		menu = (RelativeLayout)findViewById(R.id.menu);
		main = (RelativeLayout)findViewById(R.id.main);
		
	    gras.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View vue) {
	        // On récupère la position du début de la sélection
	        int selectionStart = edition.getSelectionStart();
	        // On récupère la position de la fin de la sélection
	        int selectionEnd = edition.getSelectionEnd();
	        
	        Editable editable = edition.getText();
	        
	        // Si les deux positions sont identiques (pas de sélection de plusieurs caractères)
	        if(selectionStart == selectionEnd)
	          //On insère les balises ouvrante et fermante avec rien dedans
	          editable.insert(selectionStart, "<b></b>");
	        else
	        {
	          // On met la balise avant la sélection
	          editable.insert(selectionStart, "<b>");
	          // On rajoute la balise après la sélection (et après les 3 caractères de la balise <b>)
	          editable.insert(selectionEnd + 3, "</b>");
	        }
	      }
	    });

	    italique.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View vue) {
	        int selectionStart = edition.getSelectionStart();
	        int selectionEnd = edition.getSelectionEnd();

	        Editable editable = edition.getText();

	        if(selectionStart == selectionEnd)
	          editable.insert(selectionStart, "<i></i>");
	        else
	        {
	          editable.insert(selectionStart, "<i>");
	          editable.insert(selectionEnd + 3, "</i>");
	        }
	      }
	    });

	     souligne.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View vue) {
	        int selectionStart = edition.getSelectionStart();
	        int selectionEnd = edition.getSelectionEnd();

	        Editable editable = edition.getText();

	        if(selectionStart == selectionEnd)
	          editable.insert(selectionStart, "<u></u>");
	        else
	        {
	          editable.insert(selectionStart, "<u>");
	          editable.insert(selectionEnd + 3, "</u>");
	        }
	      }
	    });
		
		smiley1.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View v) {
		        int selectionStart = edition.getSelectionStart();
		        edition.getText().insert(selectionStart, "<img src=\"smiley1\" >");
		      }
		    });
		
		
		smiley2.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View v) {
		        int selectionStart = edition.getSelectionStart();
		        edition.getText().insert(selectionStart, "<img src=\"smiley2\" >");
		      }
		    });
		
		smiley3.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View v) {
		        int selectionStart = edition.getSelectionStart();
		        edition.getText().insert(selectionStart, "<img src=\"smiley3\" >");
		      }
		    });
		
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
					y[0] = 0;
					y[1] = menu.getHeight();
					temp.setText("Cacher");
					
				}
				
				animation = new TranslateAnimation(0,0,y[0],y[1]);
//				animation = new TranslateAnimation(0,0,0,0);
				animation.setDuration(1450);
				animation.setInterpolator(new BounceInterpolator());
				animation.setFillEnabled(true);
				animation.setFillBefore(false);
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationEnd(Animation arg0) {
						RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)menu.getLayoutParams();
						params.topMargin += y[1];
	                    menu.setLayoutParams(params);				
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationStart(Animation arg0) {
						int[] temp = new int[2];
						cacherAfficher.getLocationOnScreen(temp);
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
			    
				previsualisation.setText(Html.fromHtml("<font color=\"" + currentColor + "\">" + edition.getText().toString() + "</font>", getter, null));

			  }

			  @Override
			  
			  public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    currentColor = noir;
                    break;
                case R.id.bleu:
                	currentColor = bleu;
                    break;
                case R.id.rouge:
                	currentColor = rouge;
                    break;
                }
            	edition.setText(edition.getText().toString());           	
            }
        });

		edition.setOnKeyListener(new View.OnKeyListener() {
		      @Override
		      public boolean onKey(View v, int keyCode, KeyEvent event) {
		        int cursorIndex = edition.getSelectionStart();
		        // Ne réagir qu'à l'appui sur une touche (et pas au relâchement)
		        if(event.getAction() == 0)
		          // S'il s'agit d'un appui sur la touche « entrée »
		          if(keyCode == 66)
		            // On insère une balise de retour à la ligne
		            edition.getText().insert(cursorIndex, "<br />");
		        return true;
		      }
		    });
		
	}	

}

package com.sarga.kids;






import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;







import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class KidsAppEnglishManualActivity extends Activity implements 
OnMenuItemClickListener,OnInitListener, OnClickListener{
    /** Called when the activity is first created. */
	
	DBAdapter dbAdapter;
	//private static PlaceDataSQL placeData;
	String AlphaA,AlphaB,AlphaC,AlphaD,AlphaE,AlphaF,AlphaG,AlphaH,AlphaI,AlphaJ,AlphaK,AlphaL,AlphaM,AlphaN,AlphaO,AlphaP,AlphaQ,AlphaR,AlphaS,AlphaT,AlphaU,AlphaV,AlphaW,AlphaX,AlphaY,AlphaZ;
	String wordA,wordB,wordC,wordD,wordE,wordF,wordG,wordH,wordI,wordJ,wordK,wordL,wordM,wordN,wordO,wordP,wordQ,wordR,wordS,wordT,wordU,wordV,wordW,wordX,wordY,wordZ;
	String prnA,prnB,prnC,prnD,prnE,prnF,prnG,prnH,prnI,prnJ,prnK,prnL,prnM,prnN,prnO,prnP,prnQ,prnR,prnS,prnT,prnU,prnV,prnW,prnX,prnY,prnZ;
	byte[] imageA,imageB,imageC,imageD,imageE,imageF,imageG,imageH,imageI,imageJ,imageK,imageL,imageM,imageN,imageO,imageP,imageQ,imageR,imageS,imageT,imageU,imageV,imageW,imageX,imageY,imageZ;	

private final String TAG="KidsAppEnglishManualActivity";
	
	private ArrayList<byte[]> image = new ArrayList<byte[]>();
	private ArrayList<String> alpha = new ArrayList<String>();
	private ArrayList<String> word = new ArrayList<String>();
	private ArrayList<String> pronounce = new ArrayList<String>();

	MenuItem item,item2;
	TextView tv;
	private int MY_DATA_CHECK_CODE = 0;
	private TextToSpeech mtts;
	

	Toast toast = null;
	public static Bitmap bitmap = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.englishmanualmain);
  
    	init_controls();
    	fetchdata();
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	fetchdata();
 	
    }
public void init_controls() {
		

		Intent checkIntent = new Intent();
		checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
		mtts = new TextToSpeech(this, this);
		mtts.setLanguage(Locale.ENGLISH);
		
		AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		int amStreamMusicMaxVol = am.getStreamMaxVolume(am.STREAM_MUSIC);
		am.setStreamVolume(am.STREAM_MUSIC, amStreamMusicMaxVol, 0);
		//createGpsDisabledAlert();
		// OnClick Operation
		
		((Button) findViewById(R.id.A)).setOnClickListener(this);
		((Button) findViewById(R.id.B)).setOnClickListener(this);
		((Button) findViewById(R.id.C)).setOnClickListener(this);
		((Button) findViewById(R.id.D)).setOnClickListener(this);
		((Button) findViewById(R.id.E)).setOnClickListener(this);
		((Button) findViewById(R.id.F)).setOnClickListener(this);
		((Button) findViewById(R.id.G)).setOnClickListener(this);
		((Button) findViewById(R.id.H)).setOnClickListener(this);
		((Button) findViewById(R.id.I)).setOnClickListener(this);
		((Button) findViewById(R.id.J)).setOnClickListener(this);
		((Button) findViewById(R.id.K)).setOnClickListener(this);
		((Button) findViewById(R.id.L)).setOnClickListener(this);
		((Button) findViewById(R.id.M)).setOnClickListener(this);
		((Button) findViewById(R.id.N)).setOnClickListener(this);
		((Button) findViewById(R.id.O)).setOnClickListener(this);
		((Button) findViewById(R.id.P)).setOnClickListener(this);
		((Button) findViewById(R.id.Q)).setOnClickListener(this);
		((Button) findViewById(R.id.R)).setOnClickListener(this);
		((Button) findViewById(R.id.S)).setOnClickListener(this);
		((Button) findViewById(R.id.T)).setOnClickListener(this);
		((Button) findViewById(R.id.U)).setOnClickListener(this);
		((Button) findViewById(R.id.V)).setOnClickListener(this);
		((Button) findViewById(R.id.W)).setOnClickListener(this);
		((Button) findViewById(R.id.X)).setOnClickListener(this);
		((Button) findViewById(R.id.Y)).setOnClickListener(this);
		((Button) findViewById(R.id.Z)).setOnClickListener(this);
		((Button) findViewById(R.id.one1)).setOnClickListener(this);
		((Button) findViewById(R.id.two2)).setOnClickListener(this);
		((Button) findViewById(R.id.three3)).setOnClickListener(this);
		((Button) findViewById(R.id.four4)).setOnClickListener(this);
		((Button) findViewById(R.id.five5)).setOnClickListener(this);
		((Button) findViewById(R.id.six6)).setOnClickListener(this);
		((Button) findViewById(R.id.seven7)).setOnClickListener(this);
		((Button) findViewById(R.id.eight8)).setOnClickListener(this);
		((Button) findViewById(R.id.nine9)).setOnClickListener(this);
		((Button) findViewById(R.id.ten10)).setOnClickListener(this);
	}
	public void onClick(View v) {
				
		
		
		if (v == ((Button) findViewById(R.id.A))) {
			

		
			if(AlphaA.equalsIgnoreCase("A")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordA+"_____________", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageA , 0, imageA.length));
			
			toastView.addView(imageCodeProject, 0);
			toast.show();
			
			mtts.speak("A for" +prnA,
					TextToSpeech.QUEUE_ADD, null);
			
			}

		}
		
		if (v == ((Button) findViewById(R.id.B))) {
			
			if(AlphaB.equalsIgnoreCase("B")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordB+"_____________", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageB, 0, imageB.length));

			toastView.addView(imageCodeProject, 0);
			
			toast.show();
						
			mtts.speak("B for" +prnB,
					TextToSpeech.QUEUE_ADD, null);
			
			}

		}
		
	if (v == ((Button) findViewById(R.id.C))) {
			
			if(AlphaC.equalsIgnoreCase("C")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordC+"_____________", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageC, 0, imageC.length));

			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("C for" +prnC,
					TextToSpeech.QUEUE_ADD, null);
			
			}
			
		}	
	if (v == ((Button) findViewById(R.id.D))) {
		
		if(AlphaD.equalsIgnoreCase("D")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordD+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageD, 0, imageD.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("D for" +prnD,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.E))) {
		
		if(AlphaE.equalsIgnoreCase("E")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordE+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageE, 0, imageE.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("E for" +prnE,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	if (v == ((Button) findViewById(R.id.F))) {
		
		if(AlphaF.equalsIgnoreCase("F")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordF+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageF, 0, imageF.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("F for" +prnF,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.G))) {
		
		if(AlphaG.equalsIgnoreCase("G")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordG+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageG, 0, imageG.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("G for" +prnG,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.H))) {
		
		if(AlphaH.equalsIgnoreCase("H")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordH+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageH, 0, imageH.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("H for" +prnH,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.I))) {
		
		if(AlphaI.equalsIgnoreCase("I")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordI+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageI, 0, imageI.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("I for" +prnI,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		}
	if (v == ((Button) findViewById(R.id.J))) {
		
		if(AlphaJ.equalsIgnoreCase("J")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordJ+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageJ, 0, imageJ.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("J for" +prnJ,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	if (v == ((Button) findViewById(R.id.K))) {
		
		if(AlphaK.equalsIgnoreCase("K")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordK+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageK, 0, imageK.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("K for" +prnK,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	if (v == ((Button) findViewById(R.id.L))) {
		
		if(AlphaL.equalsIgnoreCase("L")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordL+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageL, 0, imageL.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("L for" +prnL,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	if (v == ((Button) findViewById(R.id.M))) {
		
		if(AlphaM.equalsIgnoreCase("M")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordM+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageM, 0, imageM.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("M for" +prnM,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.N))) {
		
		if(AlphaN.equalsIgnoreCase("N")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordN+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageN, 0, imageN.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("N for" +prnN,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	if (v == ((Button) findViewById(R.id.O))) {
		
		if(AlphaO.equalsIgnoreCase("O")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordO+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageO, 0, imageO.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("O for" +prnO,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	if (v == ((Button) findViewById(R.id.P))) {
		
		if(AlphaP.equalsIgnoreCase("P")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordP+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageP, 0, imageP.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("P for" +prnP,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.Q))) {
		
		if(AlphaQ.equalsIgnoreCase("Q")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordQ+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageQ, 0, imageQ.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("Q for" +prnQ,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.R))) {
		
		if(AlphaR.equalsIgnoreCase("R")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordR+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageR, 0, imageR.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("R for" +prnR,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.S))) {
		
		if(AlphaS.equalsIgnoreCase("S")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordS+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageS, 0, imageS.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("S for" +prnS,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.T))) {
		
		if(AlphaT.equalsIgnoreCase("T")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordT+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageT, 0, imageT.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("T for" +prnT,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	if (v == ((Button) findViewById(R.id.U))) {
		
		if(AlphaU.equalsIgnoreCase("U")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordU+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageU, 0, imageU.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("U for" +prnU,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	if (v == ((Button) findViewById(R.id.V))) {
		
		if(AlphaV.equalsIgnoreCase("V")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordV+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageV, 0, imageV.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("V for" +prnV,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	
	if (v == ((Button) findViewById(R.id.W))) {
		
		if(AlphaW.equalsIgnoreCase("W")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordW+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageW, 0, imageW.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("W for" +prnW,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
		
	if (v == ((Button) findViewById(R.id.X))) {
		
		if(AlphaX.equalsIgnoreCase("X")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordX+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageX, 0, imageX.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("X for" +prnX,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
	if (v == ((Button) findViewById(R.id.Y))) {
		
		if(AlphaY.equalsIgnoreCase("Y")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordY+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageY, 0, imageY.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("Y for" +prnY,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	
	}
		
	if (v == ((Button) findViewById(R.id.Z))) {
		
		if(AlphaZ.equalsIgnoreCase("Z")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordZ+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageZ, 0, imageZ.length));
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("Z for" +prnZ,
				TextToSpeech.QUEUE_ADD, null);
		
		}
	}
	
	if (v == ((Button) findViewById(R.id.one1))) {
		
		
		toast = Toast.makeText(getApplicationContext(),
				"________one_______", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.one);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		
		mtts.speak("one",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.two2))) {
		toast = Toast.makeText(getApplicationContext(),
				"________two________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.two);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		
		
		mtts.speak("two",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.three3))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______three_______", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.three);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		
		
		mtts.speak("three",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.four4))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______four_______", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.four);
		toastView.addView(imageCodeProject, 0);
		toast.show();

		mtts.speak("four",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.five5))) {
		
		toast = Toast.makeText(getApplicationContext(),
				"_______five_______", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.five);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("five",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.six6))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______six_______", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.six);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("six",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.seven7))) {
		toast = Toast.makeText(getApplicationContext(),
				"________seven________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.seven);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("seven",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.eight8))) {
		toast = Toast.makeText(getApplicationContext(),
				"________eight________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.eight);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("eight",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.nine9))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______nine________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.nine);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("nine",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.ten10))) {
		toast = Toast.makeText(getApplicationContext(),
				"________ten________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.ten);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("ten",
				TextToSpeech.QUEUE_ADD, null);										
	}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		item = menu.add("Configuration");
		item.setIcon(R.drawable.settings);
		item.setOnMenuItemClickListener(this);
		
		item2 = menu.add("SetDefault");
		item2.setIcon(R.drawable.settings);
		item2.setOnMenuItemClickListener(this);
		return true;
	}

	public boolean onMenuItemClick(MenuItem menuItem) {
		// TODO Auto-generated method stub
		if (menuItem == item) {
			Intent intent = new Intent(this, EnglishManualSetting_Menu.class);
			startActivity(intent);
		}
		
		if (menuItem == item2) {
			
			
			DBAdapter dbAdapter = DBAdapter.getDBAdapterInstance(KidsAppEnglishManualActivity.this);
			dbAdapter.openDataBase();
			dbAdapter.deleteRecordInDB("kidsenglish", null, null);
			Toast.makeText(getBaseContext(), "Deleted", Toast.LENGTH_SHORT);
			
			
			byte[] bytes1 = null;
			InputStream bs1 = getResources().openRawResource(R.drawable.apple);
			byte[] bytes2 = null;
			InputStream bs2 = getResources().openRawResource(R.drawable.ball);
			byte[] bytes3 = null;
			InputStream bs3 = getResources().openRawResource(R.drawable.cat);
			byte[] bytes4 = null;
			InputStream bs4 = getResources().openRawResource(R.drawable.dog);
			byte[] bytes5 = null;
			InputStream bs5 = getResources().openRawResource(R.drawable.elephant);
			byte[] bytes6 = null;
			InputStream bs6 = getResources().openRawResource(R.drawable.fish);
			byte[] bytes7 = null;
			InputStream bs7 = getResources().openRawResource(R.drawable.goat);
			byte[] bytes8 = null;
			InputStream bs8 = getResources().openRawResource(R.drawable.horse);
			byte[] bytes9 = null;
			InputStream bs9 = getResources().openRawResource(R.drawable.icecream);
			byte[] bytes10 = null;
			InputStream bs10 = getResources().openRawResource(R.drawable.jug);
			byte[] bytes11 = null;
			InputStream bs11 = getResources().openRawResource(R.drawable.kite);
			byte[] bytes12 = null;
			InputStream bs12 = getResources().openRawResource(R.drawable.lion);
			byte[] bytes13 = null;
			InputStream bs13 = getResources().openRawResource(R.drawable.monkey);
			byte[] bytes14 = null;
			InputStream bs14 = getResources().openRawResource(R.drawable.nose);
			byte[] bytes15 = null;
			InputStream bs15 = getResources().openRawResource(R.drawable.ox);
			byte[] bytes16 = null;
			InputStream bs16 = getResources().openRawResource(R.drawable.pen);
			byte[] bytes17 = null;
			InputStream bs17 = getResources().openRawResource(R.drawable.queen);
			byte[] bytes18 = null;
			InputStream bs18 = getResources().openRawResource(R.drawable.rose);
			byte[] bytes19 = null;
			InputStream bs19 = getResources().openRawResource(R.drawable.snake);
			byte[] bytes20 = null;
			InputStream bs20 = getResources().openRawResource(R.drawable.table);
			byte[] bytes21 = null;
			InputStream bs21 = getResources().openRawResource(R.drawable.umbrella);
			byte[] bytes22 = null;
			InputStream bs22 = getResources().openRawResource(R.drawable.vegetables);
			byte[] bytes23 = null;
			InputStream bs23 = getResources().openRawResource(R.drawable.water);
			byte[] bytes24 = null;
			InputStream bs24 = getResources().openRawResource(R.drawable.xmastree);
			byte[] bytes25 = null;
			InputStream bs25 = getResources().openRawResource(R.drawable.yak);
			byte[] bytes26 = null;
			InputStream bs26 = getResources().openRawResource(R.drawable.zebra);
				try {
					bytes1 = new byte[bs1.available()];
					bs1.read(bytes1);
					bytes2 = new byte[bs2.available()];
					bs2.read(bytes2);
					bytes3 = new byte[bs3.available()];
					bs3.read(bytes3);
					bytes4 = new byte[bs4.available()];
					bs4.read(bytes4);
					bytes5 = new byte[bs5.available()];
					bs5.read(bytes5);
					bytes6 = new byte[bs6.available()];
					bs6.read(bytes6);
					bytes7 = new byte[bs7.available()];
					bs7.read(bytes7);
					bytes8 = new byte[bs8.available()];
					bs8.read(bytes8);
					bytes9 = new byte[bs9.available()];
					bs9.read(bytes9);
					bytes10 = new byte[bs10.available()];
					bs10.read(bytes10);
					bytes11 = new byte[bs11.available()];
					bs11.read(bytes11);
					bytes12 = new byte[bs12.available()];
					bs12.read(bytes12);
					bytes13 = new byte[bs13.available()];
					bs13.read(bytes13);
					bytes14 = new byte[bs14.available()];
					bs14.read(bytes14);
					bytes15 = new byte[bs15.available()];
					bs15.read(bytes15);
					bytes16 = new byte[bs16.available()];
					bs16.read(bytes16);
					bytes17 = new byte[bs17.available()];
					bs17.read(bytes17);
					bytes18 = new byte[bs18.available()];
					bs18.read(bytes18);
					bytes19 = new byte[bs19.available()];
					bs19.read(bytes19);
					bytes20 = new byte[bs20.available()];
					bs20.read(bytes20);
					bytes21 = new byte[bs21.available()];
					bs21.read(bytes21);
					bytes22 = new byte[bs22.available()];
					bs22.read(bytes22);
					bytes23 = new byte[bs23.available()];
					bs23.read(bytes23);
					bytes24 = new byte[bs24.available()];
					bs24.read(bytes24);
					bytes25 = new byte[bs25.available()];
					bs25.read(bytes25);
					bytes26 = new byte[bs26.available()];
					bs26.read(bytes26);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 dbAdapter = DBAdapter.getDBAdapterInstance(KidsAppEnglishManualActivity.this);
					dbAdapter.openDataBase();

					ContentValues initialValues1 = new ContentValues();
			
					    initialValues1.put("pronounce", "apple");
						initialValues1.put("word", "apple");
						initialValues1.put("alpha", "A");
						initialValues1.put("image",bytes1);
	
						long n1 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues1);				

					
					ContentValues initialValues2 = new ContentValues();
					
					initialValues2.put("pronounce", "ball");
					initialValues2.put("word", "ball");
					initialValues2.put("alpha", "B");
					initialValues2.put("image",bytes2);

					long n2 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues2);				
		
					
ContentValues initialValues3 = new ContentValues();
					
               initialValues3.put("pronounce", "cat");
					initialValues3.put("word", "cat");
					initialValues3.put("alpha", "C");
					initialValues3.put("image",bytes3);

					long n3 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues3);				
					
					
ContentValues initialValues4 = new ContentValues();
					

                    initialValues4.put("pronounce", "dog");
					initialValues4.put("word", "dog");
					initialValues4.put("alpha", "D");
					initialValues4.put("image",bytes4);

					long n4 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues4);				
					
ContentValues initialValues5 = new ContentValues();
					

                    initialValues5.put("pronounce", "elephant");
					initialValues5.put("word", "elephant");
					initialValues5.put("alpha", "E");
					initialValues5.put("image",bytes5);

					long n5 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues5);				
					
ContentValues initialValues6 = new ContentValues();
					

initialValues6.put("pronounce", "fish");
					initialValues6.put("word", "fish");
					initialValues6.put("alpha", "F");
					initialValues6.put("image",bytes6);

					long n6 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues6);				
					
					
ContentValues initialValues7 = new ContentValues();
					
initialValues7.put("pronounce", "Goat");
					initialValues7.put("word", "Goat");
					initialValues7.put("alpha", "G");
					initialValues7.put("image",bytes7);

					long n7 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues7);				
					
					
					
ContentValues initialValues8 = new ContentValues();
					
initialValues8.put("pronounce", "Horse");
					initialValues8.put("word", "Horse");
					initialValues8.put("alpha", "H");
					initialValues8.put("image",bytes8);

					long n8 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues8);				
ContentValues initialValues9 = new ContentValues();
					
initialValues9.put("pronounce", "icecream");
					initialValues9.put("word", "icecream");
					initialValues9.put("alpha", "I");
					initialValues9.put("image",bytes9);

					long n9 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues9);				
					
ContentValues initialValues10 = new ContentValues();
					
initialValues10.put("pronounce", "Jug");
					initialValues10.put("word", "Jug");
					initialValues10.put("alpha", "J");
					initialValues10.put("image",bytes10);

					long n10 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues10);				
					
ContentValues initialValues11 = new ContentValues();
initialValues11.put("pronounce", "kite");
					initialValues11.put("word", "kite");
					initialValues11.put("alpha", "K");
					initialValues11.put("image",bytes11);

					long n11 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues11);				
					
ContentValues initialValues12 = new ContentValues();
initialValues12.put("pronounce", "Lion");		
					initialValues12.put("word", "Lion");
					initialValues12.put("alpha", "L");
					initialValues12.put("image",bytes12);

					long n12 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues12);				
					
					
ContentValues initialValues13 = new ContentValues();
initialValues13.put("pronounce", "Monkey");
					initialValues13.put("word", "Monkey");
					initialValues13.put("alpha", "M");
					initialValues13.put("image",bytes13);

					long n13 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues13);				
					
					
ContentValues initialValues14 = new ContentValues();
initialValues14.put("pronounce", "Nose");				
					initialValues14.put("word", "Nose");
					initialValues14.put("alpha", "N");
					initialValues14.put("image",bytes14);

					long n14 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues14);				
					
					
ContentValues initialValues15 = new ContentValues();
					
initialValues15.put("pronounce", "Ox");
					initialValues15.put("word", "Ox");
					initialValues15.put("alpha", "O");
					initialValues15.put("image",bytes15);

					long n15 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues15);				
					
					
ContentValues initialValues16= new ContentValues();
					
initialValues16.put("pronounce", "Pen");
					initialValues16.put("word", "Pen");
					initialValues16.put("alpha", "P");
					initialValues16.put("image",bytes16);

					long n16 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues16);				
					
					
					
ContentValues initialValues17 = new ContentValues();
			
initialValues17.put("pronounce", "Queen");
					initialValues17.put("word", "Queen");
					initialValues17.put("alpha", "Q");
					initialValues17.put("image",bytes17);

					long n17 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues17);				
					
					
ContentValues initialValues18 = new ContentValues();
initialValues18.put("pronounce", "Rose");		
					initialValues18.put("word", "Rose");
					initialValues18.put("alpha", "R");
					initialValues18.put("image",bytes18);

					long n18 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues18);				
					
					
ContentValues initialValues19 = new ContentValues();
					
initialValues19.put("pronounce", "Snake");	
					initialValues19.put("word", "Snake");
					initialValues19.put("alpha", "S");
					initialValues19.put("image",bytes19);

					long n19 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues19);				
					
					
					
ContentValues initialValues20 = new ContentValues();
					
initialValues20.put("pronounce", "Table");	
					initialValues20.put("word", "Table");
					initialValues20.put("alpha", "T");
					initialValues20.put("image",bytes20);

					long n20 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues20);				
					
					
ContentValues initialValues21 = new ContentValues();
				
initialValues21.put("pronounce", "Umbrella");
					initialValues21.put("word", "Umbrella");
					initialValues21.put("alpha", "U");
					initialValues21.put("image",bytes21);

					long n21 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues21);				
					
					
ContentValues initialValues22 = new ContentValues();
			
initialValues22.put("pronounce", "Vegetables");
					initialValues22.put("word", "Vegetables");
					initialValues22.put("alpha", "V");
					initialValues22.put("image",bytes22);

					long n22 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues22);				
					
					
					
ContentValues initialValues23 = new ContentValues();
			
initialValues23.put("pronounce", "water");
					initialValues23.put("word", "water");
					initialValues23.put("alpha", "W");
					initialValues23.put("image",bytes23);

					long n23 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues23);				
					
					
ContentValues initialValues24 = new ContentValues();
				
initialValues24.put("pronounce", "X-mas tree");
					initialValues24.put("word", "X-mas tree");
					initialValues24.put("alpha", "X");
					initialValues24.put("image",bytes24);

					long n24 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues24);				
					
					
ContentValues initialValues25 = new ContentValues();
					
initialValues25.put("pronounce", "Yak");
					initialValues25.put("word", "Yak");
					initialValues25.put("alpha", "Y");
					initialValues25.put("image",bytes25);

					long n25 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues25);				
					
					
ContentValues initialValues26 = new ContentValues();
				
initialValues26.put("pronounce", "Zebra");
					initialValues26.put("word", "Zebra");
					initialValues26.put("alpha", "Z");
					initialValues26.put("image",bytes26);

					long n26 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues26);			
			
			
			Intent inten=new Intent(KidsAppEnglishManualActivity.this,KidsAppEnglishManualActivity.class);
			startActivity(inten);
			Toast.makeText(getApplicationContext(), "Default", Toast.LENGTH_LONG).show();
		}
			
		return true;
	}
	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
	}
	


		private Cursor getEvents(String query) {
			
			
			 dbAdapter=DBAdapter.getDBAdapterInstance(this);
	 		try {
	 			dbAdapter.createDataBase();
	 		} catch (IOException e) {
	 			Log.i("*** select ",e.getMessage());
	 		}
	 		dbAdapter.openDataBase();		
	 		
			
			  Log.d(TAG, "open data base2");
			
			  Cursor cursor=  dbAdapter.selectRecordsFromDB(query,null);
			
			startManagingCursor(cursor);
			
			
			  Log.d(TAG, "return cursor");
			return cursor;
			
		}
		
	public void fetchdata(){
		

        
      Log.d(TAG, "open data base");
   		
        image = new ArrayList<byte[]>();
   	   	alpha = new ArrayList<String>();
   	    	word = new ArrayList<String>();
   	    	pronounce = new ArrayList<String>();
   	    	Cursor cursor = getEvents("select *from kidsenglish");
   	    	
   	     Log.d(TAG, "open table");
   	    	
   	    	while (cursor.moveToNext()) {
   				//String temp_id = cursor.getString(0);
   				
   	    		String prn= cursor.getString(0);
   				String temp_caption = cursor.getString(1);
   				
   				String temp_description = cursor.getString(2);
   				byte[] temp_image = cursor.getBlob(3);
   				
   				
   				image.add(temp_image);
   				
   				alpha.add(temp_caption);
   				word.add(temp_description);
   				pronounce.add(prn);
   				//dbAdapter.close();

   	    	}
   	    	
   	    	for(int i=0;i<alpha.size();i++){
   	    		 AlphaA=alpha.get(0);
   	    		 AlphaB=alpha.get(1);
   	    		 AlphaC=alpha.get(2);
   	    		 AlphaD=alpha.get(3);
   	    		 AlphaE=alpha.get(4);
   	    		 AlphaF=alpha.get(5);
   	    		 AlphaG=alpha.get(6);
   	    		 AlphaH=alpha.get(7);
   	    		 AlphaI=alpha.get(8);
   	    		 AlphaJ=alpha.get(9);
   	    		 AlphaK=alpha.get(10);
   	    		 AlphaL=alpha.get(11);
   	    		 AlphaM=alpha.get(12);
   	    		 AlphaN=alpha.get(13);
   	    		 AlphaO=alpha.get(14);
   	    		 AlphaP=alpha.get(15);
   	    		 AlphaQ=alpha.get(16);
   	    		 AlphaR=alpha.get(17);
   	    		 AlphaS=alpha.get(18);
   	    		 AlphaT=alpha.get(19);
   	    		 AlphaU=alpha.get(20);
   	    		 AlphaV=alpha.get(21);
   	    		 AlphaW=alpha.get(22);
   	    		 AlphaX=alpha.get(23);
   	    		 AlphaY=alpha.get(24);
   	    		 AlphaZ=alpha.get(25);
   	    		
   	    		
   	    	}
   	    	for(int i=0;i<word.size();i++){
   	    		 wordA=word.get(0);
   	    		 wordB=word.get(1);
   	    		 wordC=word.get(2);
   	    		 wordD=word.get(3);
   	    		wordE=word.get(4);
  	    		 wordF=word.get(5);
  	    		 wordG=word.get(6);
  	    		 wordH=word.get(7);
  	    		wordI=word.get(8);
  	    		 wordJ=word.get(9);
  	    		 wordK=word.get(10);
  	    		 wordL=word.get(11);
  	    		wordM=word.get(12);
  	    		 wordN=word.get(13);
  	    		 wordO=word.get(14);
  	    		 wordP=word.get(15);
  	    		wordQ=word.get(16);
 	    		 wordR=word.get(17);
 	    		 wordS=word.get(18);
 	    		 wordT=word.get(19);
 	    		wordU=word.get(20);
 	    		 wordV=word.get(21);
 	    		 wordW=word.get(22);
 	    		 wordX=word.get(23);
 	    		 wordY=word.get(24);
 	    		 wordZ=word.get(25);

   	    	}
   	    	for(int i=0;i<image.size();i++){
   	    		 imageA=image.get(0);
   	    		 imageB=image.get(1);
   	    		 imageC=image.get(2);
   	    		 imageD=image.get(3);
   	    		 imageE=image.get(4);
   	    		 imageF=image.get(5);
   	    		 imageG=image.get(6);
   	    		 imageH=image.get(7);
   	    		 imageI=image.get(8);
   	    		 imageJ=image.get(9);
   	    		 imageK=image.get(10);
   	    		 imageL=image.get(11);
   	    		 imageM=image.get(12);
   	    		 imageN=image.get(13);
   	    		 imageO=image.get(14);
   	    		 imageP=image.get(15);
   	    		 imageQ=image.get(16);
   	    		 imageR=image.get(17);
   	    		 imageS=image.get(18);
   	    		 imageT=image.get(19);
   	    		 imageU=image.get(20);
   	    		 imageV=image.get(21);
   	    		 imageW=image.get(22);
   	    		 imageX=image.get(23);
   	    		 imageY=image.get(24);
   	    		 imageZ=image.get(25); 
   	    	}
   	    	
   	    	for(int i=0;i<pronounce.size();i++){
  	    		 prnA=pronounce.get(0);
  	    		prnB=pronounce.get(1);
  	    		prnC=pronounce.get(2);
  	    		prnD=pronounce.get(3);
  	    		 prnE=pronounce.get(4);
  	    		prnF=pronounce.get(5);
  	    		prnG=pronounce.get(6);
  	    		prnH=pronounce.get(7);
  	    		prnI=pronounce.get(8);
  	    		prnJ=pronounce.get(9);
  	    		prnK=pronounce.get(10);
  	    		prnL=pronounce.get(11);
  	    		prnM=pronounce.get(12);
  	    		prnN=pronounce.get(13);
  	    		prnO=pronounce.get(14);
  	    		prnP=pronounce.get(15);
  	    		prnQ=pronounce.get(16);
  	    		prnR=pronounce.get(17);
  	    		prnS=pronounce.get(18);
  	    		prnT=pronounce.get(19);
  	    		prnU=pronounce.get(20);
  	    		prnV=pronounce.get(21);
  	    		prnW=pronounce.get(22);
  	    		prnX=pronounce.get(23);
  	    		prnY=pronounce.get(24);
  	    		prnZ=pronounce.get(25);
  	    		 
  	    		 
  	    	}
   	    	
   	    	
	}

	   
	

		
}
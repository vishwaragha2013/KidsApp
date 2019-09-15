package com.sarga.kids;






import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Delayed;







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
import android.os.SystemClock;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class KidsAppEnglishAutoActivity extends Activity implements 
 OnClickListener{
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
//	AbsoluteLayout ab;

	Toast toast = null;
	public static Bitmap bitmap = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.englishautomain);
 // ab=(AbsoluteLayout)findViewById(R.id.layout1);
     
        
    	init_controls();
    	fetchdata();
    	
    	/*try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    		delay();	
    

    	
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	fetchdata();
 
    }
public void init_controls() {
	
		
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

	 public  void autoDisplay(){
		   
		
			
				if(AlphaA.equalsIgnoreCase("A")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordA+"_____________", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
			
				LinearLayout toastView = (LinearLayout) toast.getView();
				ImageView imageCodeProject = new ImageView(getApplicationContext());
				imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageA , 0, imageA.length));
				
				toastView.addView(imageCodeProject, 0);
				toast.show();
				
				mtts.speak("A for" +prnA,
						TextToSpeech.QUEUE_ADD, null);
				
				
				}

				
				if(AlphaB.equalsIgnoreCase("B")){
					toast = Toast.makeText(getApplicationContext(),
							"_____________"+wordB+"_____________", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
			
				LinearLayout toastView = (LinearLayout) toast.getView();
				ImageView imageCodeProject = new ImageView(getApplicationContext());
				imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageB, 0, imageB.length));

				toastView.addView(imageCodeProject, 0);
				
				toast.show();
			
							
				mtts.speak("B for" +prnB,
						TextToSpeech.QUEUE_ADD, null);
				
				
				
				}

			
		
				
				if(AlphaC.equalsIgnoreCase("C")){
					toast = Toast.makeText(getApplicationContext(),
							"_____________"+wordC+"_____________", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
			
				LinearLayout toastView = (LinearLayout) toast.getView();
				ImageView imageCodeProject = new ImageView(getApplicationContext());
				imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageC, 0, imageC.length));

				toastView.addView(imageCodeProject, 0);
				toast.show();
							
				mtts.speak("C for" +prnC,
						TextToSpeech.QUEUE_ADD, null);
				
				}
				
			
		
			
			if(AlphaD.equalsIgnoreCase("D")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordD+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageD, 0, imageD.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("D for" +prnD,
					TextToSpeech.QUEUE_ADD, null);
			
			}
			
			
			
			if(AlphaE.equalsIgnoreCase("E")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordE+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageE, 0, imageE.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("E for" +prnE,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
	
			
			
			if(AlphaF.equalsIgnoreCase("F")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordF+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageF, 0, imageF.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("F for" +prnF,
					TextToSpeech.QUEUE_ADD, null);
			
			}
	
			
			
			if(AlphaG.equalsIgnoreCase("G")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordG+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageG, 0, imageG.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("G for" +prnG,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
	
			
			
			if(AlphaH.equalsIgnoreCase("H")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordH+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageH, 0, imageH.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("H for" +prnH,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		

			
			
			if(AlphaI.equalsIgnoreCase("I")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordI+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageI, 0, imageI.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("I for" +prnI,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
			
			
			if(AlphaJ.equalsIgnoreCase("J")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordJ+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageJ, 0, imageJ.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("J for" +prnJ,
					TextToSpeech.QUEUE_ADD, null);
			
			}
	
			
			
			if(AlphaK.equalsIgnoreCase("K")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordK+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageK, 0, imageK.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("K for" +prnK,
					TextToSpeech.QUEUE_ADD, null);
			
			}
	
			
			
			if(AlphaL.equalsIgnoreCase("L")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordL+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageL, 0, imageL.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("L for" +prnL,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
		
			
			if(AlphaM.equalsIgnoreCase("M")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordM+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageM, 0, imageM.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("M for" +prnM,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
	
			
			
			if(AlphaN.equalsIgnoreCase("N")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordN+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageN, 0, imageN.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("N for" +prnN,
					TextToSpeech.QUEUE_ADD, null);
			
			}
	
			
			
			if(AlphaO.equalsIgnoreCase("O")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordO+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageO, 0, imageO.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("O for" +prnO,
					TextToSpeech.QUEUE_ADD, null);
			
			}
	
			
			
			if(AlphaP.equalsIgnoreCase("P")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordP+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageP, 0, imageP.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("P for" +prnP,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
			
		
			
			if(AlphaQ.equalsIgnoreCase("Q")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordQ+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageQ, 0, imageQ.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("Q for" +prnQ,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
			
	
			
			if(AlphaR.equalsIgnoreCase("R")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordR+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageR, 0, imageR.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("R for" +prnR,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
		
			
			if(AlphaS.equalsIgnoreCase("S")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordS+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageS, 0, imageS.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("S for" +prnS,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
			
		
			
			if(AlphaT.equalsIgnoreCase("T")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordT+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageT, 0, imageT.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("T for" +prnT,
					TextToSpeech.QUEUE_ADD, null);
			
			}

			
			
			if(AlphaU.equalsIgnoreCase("U")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordU+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageU, 0, imageU.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("U for" +prnU,
					TextToSpeech.QUEUE_ADD, null);
			
			}
	
			
			
			if(AlphaV.equalsIgnoreCase("V")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordV+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageV, 0, imageV.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("V for" +prnV,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
			
		
		
			
			if(AlphaW.equalsIgnoreCase("W")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordW+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageW, 0, imageW.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("W for" +prnW,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
			
			
	
			
			if(AlphaX.equalsIgnoreCase("X")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordX+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageX, 0, imageX.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("X for" +prnX,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
			
		
			
			if(AlphaY.equalsIgnoreCase("Y")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordY+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageY, 0, imageY.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("Y for" +prnY,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
		
			
			
			if(AlphaZ.equalsIgnoreCase("Z")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordZ+"_____________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageZ, 0, imageZ.length));
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("Z for" +prnZ,
					TextToSpeech.QUEUE_ADD, null);
			
			}
		
		
			
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
		
			
			
		
			toast = Toast.makeText(getApplicationContext(),
					"________two________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView1 = (LinearLayout) toast.getView();
			ImageView imageCodeProject1 = new ImageView(getApplicationContext());
			imageCodeProject1.setImageResource(R.drawable.two);
			toastView1.addView(imageCodeProject1, 0);
			toast.show();
			
			
			mtts.speak("two",
					TextToSpeech.QUEUE_ADD, null);	
			
			
			
		
			toast = Toast.makeText(getApplicationContext(),
					"_______three_______", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView3 = (LinearLayout) toast.getView();
			ImageView imageCodeProject3 = new ImageView(getApplicationContext());
			imageCodeProject3.setImageResource(R.drawable.three);
			toastView3.addView(imageCodeProject3, 0);
			toast.show();
			mtts.speak("three",
					TextToSpeech.QUEUE_ADD, null);	
			
			
	
		
			toast = Toast.makeText(getApplicationContext(),
					"_______four_______", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView4 = (LinearLayout) toast.getView();
			ImageView imageCodeProject4 = new ImageView(getApplicationContext());
			imageCodeProject4.setImageResource(R.drawable.four);
			toastView4.addView(imageCodeProject4, 0);
			toast.show();

			mtts.speak("four",
					TextToSpeech.QUEUE_ADD, null);	
			
			
		
	
		
			
			toast = Toast.makeText(getApplicationContext(),
					"_______five_______", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView5 = (LinearLayout) toast.getView();
			ImageView imageCodeProject5 = new ImageView(getApplicationContext());
			imageCodeProject5.setImageResource(R.drawable.five);
			toastView5.addView(imageCodeProject5, 0);
			toast.show();
			mtts.speak("five",
					TextToSpeech.QUEUE_ADD, null);	
			
			
			
		
			
		
			toast = Toast.makeText(getApplicationContext(),
					"_______six_______", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView6 = (LinearLayout) toast.getView();
			ImageView imageCodeProject6 = new ImageView(getApplicationContext());
			imageCodeProject6.setImageResource(R.drawable.six);
			toastView6.addView(imageCodeProject6, 0);
			toast.show();
			mtts.speak("six",
					TextToSpeech.QUEUE_ADD, null);	
			
			
			
		
		
			toast = Toast.makeText(getApplicationContext(),
					"________seven________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView7 = (LinearLayout) toast.getView();
			ImageView imageCodeProject7 = new ImageView(getApplicationContext());
			imageCodeProject7.setImageResource(R.drawable.seven);
			toastView7.addView(imageCodeProject7, 0);
			toast.show();
			mtts.speak("seven",
					TextToSpeech.QUEUE_ADD, null);	
			
			
			
			
		
		
			toast = Toast.makeText(getApplicationContext(),
					"________eight________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView8 = (LinearLayout) toast.getView();
			ImageView imageCodeProject8 = new ImageView(getApplicationContext());
			imageCodeProject8.setImageResource(R.drawable.eight);
			toastView8.addView(imageCodeProject8, 0);
			toast.show();
			mtts.speak("eight",
					TextToSpeech.QUEUE_ADD, null);	
			
			
			
		
		
			toast = Toast.makeText(getApplicationContext(),
					"_______nine________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView9 = (LinearLayout) toast.getView();
			ImageView imageCodeProject9 = new ImageView(getApplicationContext());
			imageCodeProject9.setImageResource(R.drawable.nine);
			toastView9.addView(imageCodeProject9, 0);
			toast.show();
			mtts.speak("nine",
					TextToSpeech.QUEUE_ADD, null);	
			
			
			
	
		
			toast = Toast.makeText(getApplicationContext(),
					"________ten________", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView10 = (LinearLayout) toast.getView();
			ImageView imageCodeProject10 = new ImageView(getApplicationContext());
			imageCodeProject10.setImageResource(R.drawable.ten);
			toastView10.addView(imageCodeProject10, 0);
			toast.show();
			mtts.speak("ten",
					TextToSpeech.QUEUE_ADD, null);	
			

		 
	   }
	
public void delay(){
	
	 mtts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {

         @Override
         public void onInit(int arg0) {
if(arg0 == TextToSpeech.SUCCESS) 
 
 //SystemClock.sleep(5000);
 autoDisplay();

         }
     });
	 mtts.setSpeechRate(0);
    Intent checkIntent = new Intent();
		checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);

		mtts.setLanguage(Locale.ENGLISH);
		
}

		
}
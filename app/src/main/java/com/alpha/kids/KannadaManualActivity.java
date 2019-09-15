package com.sarga.kids;





import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;





import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
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

public class KannadaManualActivity extends Activity implements 
OnMenuItemClickListener,OnInitListener, OnClickListener{
    /** Called when the activity is first created. */
	public static String setA;
	public static String setchar="zz";
	
	DBAdapter dbAdapter;
	//private static PlaceDataSQL placeData;
	
	String prnA,prnB,prnC,prnD,prnE,prnF,prnG,prnH,prnI,prnJ,prnK,prnL,prnM,prnN,prnO;
	String AlphaA,AlphaB,AlphaC,AlphaD,AlphaE,AlphaF,AlphaG,AlphaH,AlphaI,AlphaJ,AlphaK,AlphaL,AlphaM,AlphaN,AlphaO,AlphaP,AlphaQ,AlphaR,AlphaS,AlphaT,AlphaU,AlphaV,AlphaW,AlphaX,AlphaY,AlphaZ;
	String wordA,wordB,wordC,wordD,wordE,wordF,wordG,wordH,wordI,wordJ,wordK,wordL,wordM,wordN,wordO,wordP,wordQ,wordR,wordS,wordT,wordU,wordV,wordW,wordX,wordY,wordZ;
	byte[] imageA,imageB,imageC,imageD,imageE,imageF,imageG,imageH,imageI,imageJ,imageK,imageL,imageM,imageN,imageO,imageP,imageQ,imageR,imageS,imageT,imageU,imageV,imageW,imageX,imageY,imageZ;	


	private ArrayList<byte[]> image = new ArrayList<byte[]>();
	private ArrayList<String> alpha = new ArrayList<String>();
	private ArrayList<String> word = new ArrayList<String>();
	private ArrayList<String> pronounce = new ArrayList<String>();
	
	MenuItem item,item2;
	TextView tv;
	private int MY_DATA_CHECK_CODE = 0;
	private TextToSpeech mtts;
	Button A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,one,two,three,four,five,six,seven,eight,nine,ten;

	
	Toast toast = null;
	public static Bitmap bitmap = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kannadamanualmain);
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
		
		// OnClick Operation
		Typeface tf = Typeface.createFromAsset(getAssets(),"DroidSansFallback.ttf");
		A=(Button)findViewById(R.id.A);		
		A.setTypeface(tf);
		B=(Button)findViewById(R.id.B);		
		B.setTypeface(tf);
		C=(Button)findViewById(R.id.C);		
		C.setTypeface(tf);
		D=(Button)findViewById(R.id.D);		
		D.setTypeface(tf);
		E=(Button)findViewById(R.id.E);		
		E.setTypeface(tf);
		F=(Button)findViewById(R.id.F);		
		F.setTypeface(tf);
		G=(Button)findViewById(R.id.G);		
		G.setTypeface(tf);
		H=(Button)findViewById(R.id.H);		
		H.setTypeface(tf);
		I=(Button)findViewById(R.id.I);		
		I.setTypeface(tf);
		J=(Button)findViewById(R.id.J);		
		J.setTypeface(tf);
		K=(Button)findViewById(R.id.K);		
		K.setTypeface(tf);
		L=(Button)findViewById(R.id.L);		
		L.setTypeface(tf);
		M=(Button)findViewById(R.id.M);		
		M.setTypeface(tf);
		N=(Button)findViewById(R.id.N);		
		N.setTypeface(tf);
		O=(Button)findViewById(R.id.O);		
		O.setTypeface(tf);
		
		
		one=(Button)findViewById(R.id.one1);		
		one.setTypeface(tf);
		two=(Button)findViewById(R.id.two2);		
		two.setTypeface(tf);
		three=(Button)findViewById(R.id.three3);		
		three.setTypeface(tf);
		four=(Button)findViewById(R.id.four4);		
		four.setTypeface(tf);
		five=(Button)findViewById(R.id.five5);		
		five.setTypeface(tf);
		six=(Button)findViewById(R.id.six6);		
		six.setTypeface(tf);
		seven=(Button)findViewById(R.id.seven7);		
		seven.setTypeface(tf);
		eight=(Button)findViewById(R.id.eight8);		
		eight.setTypeface(tf);
		nine=(Button)findViewById(R.id.nine9);		
		nine.setTypeface(tf);
		ten=(Button)findViewById(R.id.ten10);		
		ten.setTypeface(tf);
		
		
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
			
			if(AlphaA.equalsIgnoreCase("a")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordA+"_____________", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageA , 0, imageA.length));
			
			toastView.addView(imageCodeProject, 0);
			toast.show();
			
			mtts.speak("" +prnA,
					TextToSpeech.QUEUE_ADD, null);
			
			}
			
		
		}
		if (v == ((Button) findViewById(R.id.B))) {
			
			if(AlphaB.equalsIgnoreCase("aa")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordB+"_____________", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageB , 0, imageB.length));
			
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("" +prnB,
					TextToSpeech.QUEUE_ADD, null);
			
			}
			
		
		}
		
	if (v == ((Button) findViewById(R.id.C))) {
			
			if(AlphaC.equalsIgnoreCase("e")){
				toast = Toast.makeText(getApplicationContext(),
						"_____________"+wordC+"_____________", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
		
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageC , 0, imageC.length));
			
			toastView.addView(imageCodeProject, 0);
			toast.show();
						
			mtts.speak("" +prnC,
					TextToSpeech.QUEUE_ADD, null);
			
			}
			
		
		}	
	if (v == ((Button) findViewById(R.id.D))) {
		
		if(AlphaD.equalsIgnoreCase("ee")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordD+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageD , 0, imageD.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnD,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.E))) {
		
		if(AlphaE.equalsIgnoreCase("uu")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordE+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageE , 0, imageE.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnE,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.F))) {
		
		if(AlphaF.equalsIgnoreCase("oo")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordF+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageF , 0, imageF.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnF,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.G))) {
		
		if(AlphaG.equalsIgnoreCase("ru")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordG+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageG , 0, imageG.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnG,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	
	}
	if (v == ((Button) findViewById(R.id.H))) {
		
		if(AlphaH.equalsIgnoreCase("ye")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordH+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageH , 0, imageH.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnH,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.I))) {
		
		if(AlphaI.equalsIgnoreCase("yee")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordI+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageI , 0, imageI.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnI,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.J))) {
		
		if(AlphaJ.equalsIgnoreCase("ai")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordJ+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageJ , 0, imageJ.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnJ,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.K))) {
		
		if(AlphaK.equalsIgnoreCase("o")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordK+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageK , 0, imageK.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnK,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.L))) {
		
		if(AlphaL.equalsIgnoreCase("ooo")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordL+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageL , 0, imageL.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnL,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.M))) {
		
		if(AlphaM.equalsIgnoreCase("ou")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordM+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageM , 0, imageM.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnM,
				TextToSpeech.QUEUE_ADD, null);
	
		}
	
	}
	if (v == ((Button) findViewById(R.id.N))) {
		
		if(AlphaN.equalsIgnoreCase("aum")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordN+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageN, 0, imageN.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnN,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
	if (v == ((Button) findViewById(R.id.O))) {
		
		if(AlphaO.equalsIgnoreCase("aaha")){
			toast = Toast.makeText(getApplicationContext(),
					"_____________"+wordO+"_____________", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
	
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageBitmap(BitmapFactory.decodeByteArray(imageO , 0, imageO.length));
		
		toastView.addView(imageCodeProject, 0);
		toast.show();
					
		mtts.speak("" +prnO,
				TextToSpeech.QUEUE_ADD, null);
		
		}
		
	
	}
	
	
	if (v == ((Button) findViewById(R.id.one1))) {
		
		
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.one);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		
		mtts.speak("oondhu",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.two2))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.two);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		
		
		mtts.speak("yeradu",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.three3))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.three);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		
		
		mtts.speak("mooru",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.four4))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.four);
		toastView.addView(imageCodeProject, 0);
		toast.show();

		mtts.speak("Nalaku",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.five5))) {
		
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.five);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("aidhu",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.six6))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.six);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("aaru",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.seven7))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.seven);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("yelu",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.eight8))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.eight);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("yenttu",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.nine9))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.nine);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("ombatthu",
				TextToSpeech.QUEUE_ADD, null);										
	}
	if (v == ((Button) findViewById(R.id.ten10))) {
		toast = Toast.makeText(getApplicationContext(),
				"_______________", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.ten);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		mtts.speak("haatthu",
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
			Intent intent = new Intent(this, KannadaSetting_Menu.class);
			startActivity(intent);
		}
		
		if (menuItem == item2) {
			
			

			DBAdapter dbAdapter = DBAdapter.getDBAdapterInstance(KannadaManualActivity.this);
			dbAdapter.openDataBase();
			dbAdapter.deleteRecordInDB("kidskannada", null, null);
			Toast.makeText(getBaseContext(), "Deleted", Toast.LENGTH_SHORT);
			
			
			byte[] bytes1 = null;
			InputStream bs1 = getResources().openRawResource(R.drawable.aarasa);
			byte[] bytes2 = null;
			InputStream bs2 = getResources().openRawResource(R.drawable.aadu);
			byte[] bytes3 = null;
			InputStream bs3 = getResources().openRawResource(R.drawable.eeruve);
			byte[] bytes4 = null;
			InputStream bs4 = getResources().openRawResource(R.drawable.eeju);
			byte[] bytes5 = null;
			InputStream bs5 = getResources().openRawResource(R.drawable.oongura);
			byte[] bytes6 = null;
			InputStream bs6 = getResources().openRawResource(R.drawable.oota);
			byte[] bytes7 = null;
			InputStream bs7 = getResources().openRawResource(R.drawable.rushi);
			byte[] bytes8 = null;
			InputStream bs8 = getResources().openRawResource(R.drawable.emme);
			byte[] bytes9 = null;
			InputStream bs9 = getResources().openRawResource(R.drawable.yetha);
			byte[] bytes10 = null;
			InputStream bs10 = getResources().openRawResource(R.drawable.airavata);
			byte[] bytes11 = null;
			InputStream bs11 = getResources().openRawResource(R.drawable.onte);
			byte[] bytes12 = null;
			InputStream bs12 = getResources().openRawResource(R.drawable.oodhu);
			byte[] bytes13 = null;
			InputStream bs13 = getResources().openRawResource(R.drawable.oushadhi);
			byte[] bytes14 = null;
			InputStream bs14 = getResources().openRawResource(R.drawable.angadi);
			byte[] bytes15 = null;
			InputStream bs15 = getResources().openRawResource(R.drawable.aah);
			
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
				
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 dbAdapter = DBAdapter.getDBAdapterInstance(KannadaManualActivity.this);
					dbAdapter.openDataBase();

					ContentValues initialValues1 = new ContentValues();
			
					    initialValues1.put("pronounce", "aarasa");
						initialValues1.put("word", "aarasa");
						initialValues1.put("alpha", "a");
						initialValues1.put("image",bytes1);
	
						long n1 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues1);				

					Toast.makeText(getBaseContext(), "Values Set"+n1, Toast.LENGTH_SHORT);
					ContentValues initialValues2 = new ContentValues();
					
					initialValues2.put("pronounce", "Aadu");
					initialValues2.put("word", "Aadu");
					initialValues2.put("alpha", "aa");
					initialValues2.put("image",bytes2);

					long n2 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues2);				
		
					
ContentValues initialValues3 = new ContentValues();
					
initialValues3.put("pronounce", "eeruvee");
					initialValues3.put("word", "eeruvee");
					initialValues3.put("alpha", "e");
					initialValues3.put("image",bytes3);

					long n3 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues3);				
					
					
ContentValues initialValues4 = new ContentValues();
					
initialValues4.put("pronounce", "Eeju");
					initialValues4.put("word", "Eeju");
					initialValues4.put("alpha", "ee");
					initialValues4.put("image",bytes4);

					long n4 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues4);				
					
ContentValues initialValues5 = new ContentValues();
				
initialValues5.put("pronounce", "Oongura");
					initialValues5.put("word", "Oongura");
					initialValues5.put("alpha", "uu");
					initialValues5.put("image",bytes5);

					long n5 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues5);				
					
ContentValues initialValues6 = new ContentValues();
					
initialValues6.put("pronounce", "uta");
					initialValues6.put("word", "uta");
					initialValues6.put("alpha", "oo");
					initialValues6.put("image",bytes6);

					long n6 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues6);				
					
					
ContentValues initialValues7 = new ContentValues();
					
initialValues7.put("pronounce", "rooshi");
					initialValues7.put("word", "rooshi");
					initialValues7.put("alpha", "ru");
					initialValues7.put("image",bytes7);

					long n7 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues7);				
					
					
					
ContentValues initialValues8 = new ContentValues();
				
initialValues8.put("pronounce", "yemme");
					initialValues8.put("word", "yemme");
					initialValues8.put("alpha", "ye");
					initialValues8.put("image",bytes8);

					long n8 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues8);				
ContentValues initialValues9 = new ContentValues();
					
initialValues9.put("pronounce", "yetha");
					initialValues9.put("word", "yetha");
					initialValues9.put("alpha", "yee");
					initialValues9.put("image",bytes9);

					long n9 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues9);				
					
ContentValues initialValues10 = new ContentValues();
					
initialValues10.put("pronounce", "airavatha");
					initialValues10.put("word", "airavatha");
					initialValues10.put("alpha", "ai");
					initialValues10.put("image",bytes10);

					long n10 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues10);				
					
ContentValues initialValues11 = new ContentValues();
					
initialValues11.put("pronounce", "vantae");
					initialValues11.put("word", "vantae");
					initialValues11.put("alpha", "o");
					initialValues11.put("image",bytes11);

					long n11 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues11);				
					
ContentValues initialValues12 = new ContentValues();
					
initialValues12.put("pronounce", "Odhu");
					initialValues12.put("word", "Odhu");
					initialValues12.put("alpha", "ooo");
					initialValues12.put("image",bytes12);

					long n12 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues12);				
					
					
ContentValues initialValues13 = new ContentValues();
				
initialValues13.put("pronounce", "Oushadhi");
					initialValues13.put("word", "Oushadhi");
					initialValues13.put("alpha", "ou");
					initialValues13.put("image",bytes13);

					long n13 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues13);				
					
					
ContentValues initialValues14 = new ContentValues();
					
initialValues14.put("pronounce", "Angadi");
					initialValues14.put("word", "Angadi");
					initialValues14.put("alpha", "aum");
					initialValues14.put("image",bytes14);

					long n14 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues14);				
					
					
ContentValues initialValues15 = new ContentValues();
					
initialValues15.put("pronounce", "Ahaa");
					initialValues15.put("word", "Ahaa");
					initialValues15.put("alpha", "aaha");
					initialValues15.put("image",bytes15);

					long n15 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues15);				
					
	
			Intent intent = new Intent(KannadaManualActivity.this, KannadaManualActivity.class);
			startActivity(intent);
			
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
 		
		  
		
		
		Cursor cursor=  dbAdapter.selectRecordsFromDB(query,null);
		
		startManagingCursor(cursor);
		
		
		
		return cursor;
		
	}
	
public void fetchdata(){

    image = new ArrayList<byte[]>();
	   	alpha = new ArrayList<String>();
	    	word = new ArrayList<String>();
	    	pronounce = new ArrayList<String>();
	    	Cursor cursor = getEvents("select *from kidskannada");
	    	
	   
	    	
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
 
 	    		 
 	    	}
  	    	
}
	
	


}

	

	
	

package com.sarga.kids;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Locale;




import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class EnglishManualSetting_Menu extends Activity implements OnClickListener,OnInitListener {

	
public String pronounce;
public String setA;
public String setchar;
private Uri mImageCaptureUri;
public  ImageView mImageView;
private int MY_DATA_CHECK_CODE = 0;
private TextToSpeech mtts;

private static final int PICK_FROM_CAMERA = 1;
private static final int PICK_FROM_FILE = 2;
 AlertDialog dialog;
 Bitmap bitmap;
 DBAdapter dbAdapter;
 Spinner spin;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.english_settings);

		Intent checkIntent = new Intent();
		checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
		mtts = new TextToSpeech(this, this);
		mtts.setLanguage(Locale.ENGLISH);
		
		AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		int amStreamMusicMaxVol = am.getStreamMaxVolume(am.STREAM_MUSIC);
		am.setStreamVolume(am.STREAM_MUSIC, amStreamMusicMaxVol, 0);
		
		
		  final String [] items = new String [] {"From Camera", "From SD Card"};
		  ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.select_dialog_item,items);
		  AlertDialog.Builder builder = new AlertDialog.Builder(this);

		  
		  builder.setAdapter( adapter, new DialogInterface.OnClickListener() {
		  public void onClick( DialogInterface dialog, int item ) {
		  if (item == 0) {
		  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		  File file = new File(Environment.getExternalStorageDirectory(),
		  "tmp_avatar_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
		  mImageCaptureUri = Uri.fromFile(file);

		  try {
		  intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
		  intent.putExtra("return-data", true);
		
		  startActivityForResult(intent, PICK_FROM_CAMERA);
		  } catch (Exception e) {
		  e.printStackTrace();
		  }

		  dialog.cancel();
		  } else {
		  Intent intent = new Intent();

		  intent.setType("image/*");
		  intent.setAction(Intent.ACTION_GET_CONTENT);

		  startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_FILE);
		  }
		  }
		  } );

		  
		 
		   dialog = builder.create();
		 
		   mImageView = (ImageView) findViewById(R.id.iv_pic);
		
		
		((EditText) findViewById(R.id.editchar)).setText(setA);
		
	
		spin=((Spinner) findViewById(R.id.A_edit));
		   ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.alphabets, android.R.layout.simple_spinner_item);
	        
	        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        
	        spin.setAdapter(adapter3);
		
		((Button) findViewById(R.id.setbtn)).setOnClickListener(this);
		((Button) findViewById(R.id.abtn)).setOnClickListener(this);
		((Button) findViewById(R.id.button1)).setOnClickListener(this);
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		
	
		if (v == ((Button) findViewById(R.id.setbtn))) {
		
		
			
			setA = (((EditText) findViewById(R.id.editchar))
							.getText().toString());
			((EditText) findViewById(R.id.editchar)).setText(
					setA);
		
			pronounce = (((EditText) findViewById(R.id.pronounce))
					.getText().toString());
	((EditText) findViewById(R.id.pronounce)).setText(
			pronounce);
			
			
			
		setchar=spin.getSelectedItem().toString();
	
			
			
			mImageView= (((ImageView)findViewById(R.id.iv_pic)));
			
		
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			bitmap.compress(CompressFormat.PNG, 0 /*ignored for PNG*/, bos);

			byte[] bitmapdata = bos.toByteArray();

			 dbAdapter = DBAdapter.getDBAdapterInstance(EnglishManualSetting_Menu.this);
				dbAdapter.openDataBase();
			

			
				ContentValues initialValues = new ContentValues();
				
				if(setA.length()==0 && setchar.length()==0 && bitmap==null){	
					
					Toast.makeText(getBaseContext(), "fill all fields", Toast.LENGTH_SHORT).show();
			
					}
				else {
					initialValues.put("pronounce",pronounce);
					initialValues.put("word", setA);
					initialValues.put("alpha", setchar);
					initialValues.put("image",bitmapdata);
					
					String [] strArray = {""+setchar};
					long n = dbAdapter.updateRecordsInDB("kidsenglish", initialValues, "alpha=?",strArray);				
					//long n = dbAdapter.insertRecordsInDB("kidsenglish", null, initialValues);	
						
					
				
				Toast.makeText(getBaseContext(), "Values Set"+n, Toast.LENGTH_SHORT)
						.show();
				}
		
		}
		
		if (v == ((Button) findViewById(R.id.abtn))){
			dialog.show();		
		}
		
		if (v == ((Button) findViewById(R.id.button1))){
			
			EditText edit=(EditText) findViewById(R.id.pronounce);
					
			mtts.speak(edit.getText().toString(),TextToSpeech.QUEUE_ADD, null);
		}
	}

	 @Override
	   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		 
		 
		   BitmapFactory.Options bfOptions=new BitmapFactory.Options();

		   bfOptions.inDither=false;                     //Disable Dithering mode

		   bfOptions.inPurgeable=true;                   //Tell to gc that whether it needs free memory, the Bitmap can be cleared

		   bfOptions.inInputShareable=true;              //Which kind of reference will be used to recover the Bitmap data after being clear, when it will be used in the future

		   bfOptions.inSampleSize=8; //Allocate some temporal memory for decoding
		   
		  

	   if (resultCode != RESULT_OK) return;

	
	

	

	
	   String path = "";

	   if (requestCode == PICK_FROM_FILE) {
		   
		 
	   mImageCaptureUri = data.getData();
	   path = getRealPathFromURI(mImageCaptureUri); //from Gallery
	 
	   if (path == null)
	   path = mImageCaptureUri.getPath(); //from File Manager
	  
	   if (path != null)
		 
	   bitmap = BitmapFactory.decodeFile(path,bfOptions);
	   } else {
		 
	   path = mImageCaptureUri.getPath();
	   bitmap = BitmapFactory.decodeFile(path,bfOptions);
	   }
	   
	   
	
	  mImageView.setImageBitmap(bitmap);

	 
	   }
	 
	

	   public String getRealPathFromURI(Uri contentUri) {
	           String [] proj = {MediaStore.Images.Media.DATA};
	           Cursor cursor = managedQuery( contentUri, proj, null, null,null);
	           
	           if (cursor == null) return null;
	           
	           int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	           
	           cursor.moveToFirst();

	           return cursor.getString(column_index);
	   }

	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	   
	   
	  
}

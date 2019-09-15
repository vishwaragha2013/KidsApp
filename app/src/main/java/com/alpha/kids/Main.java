package com.sarga.kids;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class Main extends Activity {
	
	  Spinner language;
	  Spinner mode;
	  Button submit;
	//  Button add;
	  DBAdapter dbAdapter;

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        
   final Spinner language = (Spinner) findViewById(R.id.language);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        language.setAdapter(adapter);
        
        
 final Spinner mode = (Spinner) findViewById(R.id.modspinner);
        
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.modcat, android.R.layout.simple_spinner_item);
        
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        mode.setAdapter(adapter2);
        
        
   

        
       submit = (Button) findViewById(R.id.btnsubmit);
        
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
			if(language.getSelectedItemId()==0 && mode.getSelectedItemId()==0){
				
				/*DBAdapter dbAdapter = DBAdapter.getDBAdapterInstance(Main.this);
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
					 dbAdapter = DBAdapter.getDBAdapterInstance(Main.this);
						dbAdapter.openDataBase();

						ContentValues initialValues1 = new ContentValues();
				
							initialValues1.put("word", "apple");
							initialValues1.put("alpha", "A");
							initialValues1.put("image",bytes1);
		
							long n1 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues1);				
	
						Toast.makeText(getBaseContext(), "Values Set"+n1, Toast.LENGTH_SHORT);
						ContentValues initialValues2 = new ContentValues();
						
						initialValues2.put("word", "ball");
						initialValues2.put("alpha", "B");
						initialValues2.put("image",bytes2);
	
						long n2 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues2);				
			
						
ContentValues initialValues3 = new ContentValues();
						
						initialValues3.put("word", "cat");
						initialValues3.put("alpha", "C");
						initialValues3.put("image",bytes3);
	
						long n3 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues3);				
						
						
ContentValues initialValues4 = new ContentValues();
						
						initialValues4.put("word", "dog");
						initialValues4.put("alpha", "D");
						initialValues4.put("image",bytes4);
	
						long n4 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues4);				
						
ContentValues initialValues5 = new ContentValues();
						
						initialValues5.put("word", "elephant");
						initialValues5.put("alpha", "E");
						initialValues5.put("image",bytes5);
	
						long n5 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues5);				
						
ContentValues initialValues6 = new ContentValues();
						
						initialValues6.put("word", "fish");
						initialValues6.put("alpha", "F");
						initialValues6.put("image",bytes6);
	
						long n6 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues6);				
						
						
ContentValues initialValues7 = new ContentValues();
						
						initialValues7.put("word", "Goat");
						initialValues7.put("alpha", "G");
						initialValues7.put("image",bytes7);
	
						long n7 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues7);				
						
						
						
ContentValues initialValues8 = new ContentValues();
						
						initialValues8.put("word", "Horse");
						initialValues8.put("alpha", "H");
						initialValues8.put("image",bytes8);
	
						long n8 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues8);				
ContentValues initialValues9 = new ContentValues();
						
						initialValues9.put("word", "icecream");
						initialValues9.put("alpha", "I");
						initialValues9.put("image",bytes9);
	
						long n9 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues9);				
						
ContentValues initialValues10 = new ContentValues();
						
						initialValues10.put("word", "Jug");
						initialValues10.put("alpha", "J");
						initialValues10.put("image",bytes10);
	
						long n10 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues10);				
						
ContentValues initialValues11 = new ContentValues();
						
						initialValues11.put("word", "kite");
						initialValues11.put("alpha", "K");
						initialValues11.put("image",bytes11);
	
						long n11 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues11);				
						
ContentValues initialValues12 = new ContentValues();
						
						initialValues12.put("word", "Lion");
						initialValues12.put("alpha", "L");
						initialValues12.put("image",bytes12);
	
						long n12 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues12);				
						
						
ContentValues initialValues13 = new ContentValues();
						
						initialValues13.put("word", "Monkey");
						initialValues13.put("alpha", "M");
						initialValues13.put("image",bytes13);
	
						long n13 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues13);				
						
						
ContentValues initialValues14 = new ContentValues();
						
						initialValues14.put("word", "Nose");
						initialValues14.put("alpha", "N");
						initialValues14.put("image",bytes14);
	
						long n14 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues14);				
						
						
ContentValues initialValues15 = new ContentValues();
						
						initialValues15.put("word", "Ox");
						initialValues15.put("alpha", "O");
						initialValues15.put("image",bytes15);
	
						long n15 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues15);				
						
						
ContentValues initialValues16= new ContentValues();
						
						initialValues16.put("word", "Pen");
						initialValues16.put("alpha", "P");
						initialValues16.put("image",bytes16);
	
						long n16 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues16);				
						
						
						
ContentValues initialValues17 = new ContentValues();
						
						initialValues17.put("word", "Queen");
						initialValues17.put("alpha", "Q");
						initialValues17.put("image",bytes17);
	
						long n17 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues17);				
						
						
ContentValues initialValues18 = new ContentValues();
						
						initialValues18.put("word", "Rose");
						initialValues18.put("alpha", "R");
						initialValues18.put("image",bytes18);
	
						long n18 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues18);				
						
						
ContentValues initialValues19 = new ContentValues();
						
						initialValues19.put("word", "Snake");
						initialValues19.put("alpha", "S");
						initialValues19.put("image",bytes19);
	
						long n19 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues19);				
						
						
						
ContentValues initialValues20 = new ContentValues();
						
						initialValues20.put("word", "Table");
						initialValues20.put("alpha", "T");
						initialValues20.put("image",bytes20);
	
						long n20 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues20);				
						
						
ContentValues initialValues21 = new ContentValues();
						
						initialValues21.put("word", "Umbrella");
						initialValues21.put("alpha", "U");
						initialValues21.put("image",bytes21);
	
						long n21 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues21);				
						
						
ContentValues initialValues22 = new ContentValues();
						
						initialValues22.put("word", "Vegetables");
						initialValues22.put("alpha", "V");
						initialValues22.put("image",bytes22);
	
						long n22 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues22);				
						
						
						
ContentValues initialValues23 = new ContentValues();
						
						initialValues23.put("word", "water");
						initialValues23.put("alpha", "W");
						initialValues23.put("image",bytes23);
	
						long n23 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues23);				
						
						
ContentValues initialValues24 = new ContentValues();
						
						initialValues24.put("word", "X-mas tree");
						initialValues24.put("alpha", "X");
						initialValues24.put("image",bytes24);
	
						long n24 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues24);				
						
						
ContentValues initialValues25 = new ContentValues();
						
						initialValues25.put("word", "Yak");
						initialValues25.put("alpha", "Y");
						initialValues25.put("image",bytes25);
	
						long n25 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues25);				
						
						
ContentValues initialValues26 = new ContentValues();
						
						initialValues26.put("word", "Zebra");
						initialValues26.put("alpha", "Z");
						initialValues26.put("image",bytes26);
	
						long n26 = dbAdapter.insertRecordsInDB("kidsenglish",null, initialValues26);				*/
						
				 Intent i=new Intent(
				            Main.this,
				            KidsAppEnglishAutoActivity.class);
				      startActivity(i);
				      
				      
			}
			else if(language.getSelectedItemId()==0 && mode.getSelectedItemId()==1)
			{

				 Intent i=new Intent(
				            Main.this,
				            KidsAppEnglishManualActivity.class);
				      startActivity(i);
			}
			
			else if(language.getSelectedItemId()==1 && mode.getSelectedItemId()==0)
			{
				
				/*DBAdapter dbAdapter = DBAdapter.getDBAdapterInstance(Main.this);
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
					 dbAdapter = DBAdapter.getDBAdapterInstance(Main.this);
						dbAdapter.openDataBase();

						ContentValues initialValues1 = new ContentValues();
				
							initialValues1.put("word", "aarasa");
							initialValues1.put("alpha", "a");
							initialValues1.put("image",bytes1);
		
							long n1 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues1);				
	
						Toast.makeText(getBaseContext(), "Values Set"+n1, Toast.LENGTH_SHORT);
						ContentValues initialValues2 = new ContentValues();
						
						initialValues2.put("word", "Aadu");
						initialValues2.put("alpha", "aa");
						initialValues2.put("image",bytes2);
	
						long n2 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues2);				
			
						
ContentValues initialValues3 = new ContentValues();
						
						initialValues3.put("word", "eeruvee");
						initialValues3.put("alpha", "e");
						initialValues3.put("image",bytes3);
	
						long n3 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues3);				
						
						
ContentValues initialValues4 = new ContentValues();
						
						initialValues4.put("word", "Eeju");
						initialValues4.put("alpha", "ee");
						initialValues4.put("image",bytes4);
	
						long n4 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues4);				
						
ContentValues initialValues5 = new ContentValues();
						
						initialValues5.put("word", "Oongura");
						initialValues5.put("alpha", "uu");
						initialValues5.put("image",bytes5);
	
						long n5 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues5);				
						
ContentValues initialValues6 = new ContentValues();
						
						initialValues6.put("word", "uta");
						initialValues6.put("alpha", "oo");
						initialValues6.put("image",bytes6);
	
						long n6 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues6);				
						
						
ContentValues initialValues7 = new ContentValues();
						
						initialValues7.put("word", "rooshi");
						initialValues7.put("alpha", "ru");
						initialValues7.put("image",bytes7);
	
						long n7 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues7);				
						
						
						
ContentValues initialValues8 = new ContentValues();
						
						initialValues8.put("word", "yemme");
						initialValues8.put("alpha", "ye");
						initialValues8.put("image",bytes8);
	
						long n8 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues8);				
ContentValues initialValues9 = new ContentValues();
						
						initialValues9.put("word", "yetha");
						initialValues9.put("alpha", "yee");
						initialValues9.put("image",bytes9);
	
						long n9 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues9);				
						
ContentValues initialValues10 = new ContentValues();
						
						initialValues10.put("word", "airavatha");
						initialValues10.put("alpha", "ai");
						initialValues10.put("image",bytes10);
	
						long n10 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues10);				
						
ContentValues initialValues11 = new ContentValues();
						
						initialValues11.put("word", "vantae");
						initialValues11.put("alpha", "o");
						initialValues11.put("image",bytes11);
	
						long n11 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues11);				
						
ContentValues initialValues12 = new ContentValues();
						
						initialValues12.put("word", "Odhu");
						initialValues12.put("alpha", "ooo");
						initialValues12.put("image",bytes12);
	
						long n12 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues12);				
						
						
ContentValues initialValues13 = new ContentValues();
						
						initialValues13.put("word", "Oushadhi");
						initialValues13.put("alpha", "ou");
						initialValues13.put("image",bytes13);
	
						long n13 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues13);				
						
						
ContentValues initialValues14 = new ContentValues();
						
						initialValues14.put("word", "Angadi");
						initialValues14.put("alpha", "aum");
						initialValues14.put("image",bytes14);
	
						long n14 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues14);				
						
						
ContentValues initialValues15 = new ContentValues();
						
						initialValues15.put("word", "Ahaa");
						initialValues15.put("alpha", "aaha");
						initialValues15.put("image",bytes15);
	
						long n15 = dbAdapter.insertRecordsInDB("kidskannada",null, initialValues15);				
						
				
				*/
				
				
				 Intent i=new Intent(
				            Main.this,
				            KannadaAutoActivity.class);
				      startActivity(i);
			}
			
			else if(language.getSelectedItemId()==1 && mode.getSelectedItemId()==1)
			{
				 Intent i=new Intent(
				            Main.this,
				            KannadaManualActivity.class);
				      startActivity(i);
			}
			}
		});
    
        TextView tv = (TextView)findViewById( R.id.link2_view );
        // make sure that setText call comes BEFORE Linkify.addLinks call
        tv.setText("www.sargatech.com");
        Linkify.addLinks( tv, Linkify.WEB_URLS );
	}

	 
}
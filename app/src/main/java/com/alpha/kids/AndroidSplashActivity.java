package com.sarga.kids;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class AndroidSplashActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread splashThread = new Thread() {
            @Override
            public void run() {
               try {
                  int waited = 0;
                  while (waited < 1000) {
                     sleep(700);
                     waited += 200;
                  }
               } catch (InterruptedException e) {
                  // do nothing
               } finally {
                  finish();
                  Intent i = new Intent(AndroidSplashActivity.this,Main.class);
                 
                  startActivity(i);
               }
            }
         };
         splashThread.start();
        
    }
    
   

}
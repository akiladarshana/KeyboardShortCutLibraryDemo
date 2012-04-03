package com.akiladarshana.ksl;


/*
 * @author - Akila Darshana Panditha
 */
import com.akiladarshana.ksl.KeyboardShortcutLibrary.SingleKeyShortcutLibrary;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnLongClickListener;



public class KeyboardShortcutDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //registering activity for keyboard shortcut library
       SingleKeyShortcutLibrary.getInstance().registerActivity(this.getClass());
    }
      
    
   @Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	   ///Transferring event handle to keyboard shortcut library
	   SingleKeyShortcutLibrary.getInstance().singleKeyEvent(keyCode, event,this.getClass(),this);
	return super.onKeyDown(keyCode, event);
}
   
}
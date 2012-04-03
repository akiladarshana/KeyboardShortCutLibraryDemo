/**
 * 
 */
package com.akiladarshana.ksl.KeyboardShortcutLibrary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

import javax.xml.datatype.Duration;

import com.akiladarshana.ksl.KeyboardShortcutDemoActivity;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * @author Akila Darshana
 *
 */
public class SingleKeyShortcutLibrary {

	/*
	 * This class handles single key events for registered activities 
	 */
	
	// for singleton structure
	private static SingleKeyShortcutLibrary instance;
	
	
	// storing assigned activity references
	private HashSet<Class<? extends Activity>> assignedClasses;
	
	
	// private constructor for singleton operations 
	private SingleKeyShortcutLibrary() {
		assignedClasses = new HashSet<Class<? extends Activity>>();
	}
	
	
	/*
	 * This method registers an activity for global key shortcut service. Avoids duplicates 
	 * 
	 * @param - refering .class extending andriod.activity
	 */
	public  boolean registerActivity(Class<? extends Activity> classReference){
		
		if(! getInstance().assignedClasses.contains(classReference)){
			
			getInstance().assignedClasses.add(classReference);
			
			return true;
		}
		return false;
	}
	
	
	
	//singleton access for class 
	public static SingleKeyShortcutLibrary getInstance() {
		if(instance==null){
			instance = new SingleKeyShortcutLibrary();
		}
		return instance;
	}





	/*
	 * This method handles key events for registered activities
	 * 
	 * @param - key code
	 * @param - key event
	 * @param - refering .class extending andriod.activity
	 * @param - refering context (only for demonstration purpose)
	 */
	public void singleKeyEvent(int keyCode, KeyEvent event,
			Class<? extends Activity> classReference,Context context) {
		
		if(getInstance().assignedClasses.contains(classReference)){
			Log.v("Refferencing class registration Check", "Sucess");
			
			Toast.makeText(context, "Pressed key code:"+keyCode,Toast.LENGTH_SHORT ).show();
			
			
		}
		
		
	}
}

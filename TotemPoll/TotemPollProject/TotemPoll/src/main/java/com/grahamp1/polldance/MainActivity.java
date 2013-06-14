package com.grahamp1.polldance ;

import android.app.Activity ;
import android.content.Intent ;
import android.os.Bundle ;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View ;

import java.util.ArrayList ;


/**
 * Activity for the Splash Screen
 *
 * @author Google Android Camp 2013, Graham + 1
 * @version 14th June 2013
 */
public class MainActivity extends Activity
{
    private static final String TAG = "TotemPoll";

    private static final int MENU_ABOUT = 1;
    private static final int MENU_OPTION_SETTINGS = 2;
    private static final int MENU_HELP = 3;
    private static final int MENU_EXIT = 4;

    /**
     * Initialises the Splash screen.
     *
     * @param savedInstanceState The previous saved state of this activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(0, MENU_ABOUT, 0, "About");
        // menu.add(0, MENU_OPTION_SETTINGS, Menu.NONE, "Settings");
        menu.add(0, MENU_HELP, Menu.NONE, "Help");
        menu.add(0, MENU_EXIT, 0, "Exit");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Log.d(TAG, "menu item " + String.valueOf(item.getItemId()));
        switch (item.getItemId()) {
            case MENU_OPTION_SETTINGS:
//                launchSettingsActivity();
                break;
            case MENU_ABOUT:
                launchAboutActivity();
                break;
            case MENU_HELP:
                launchHelpActivity();
                break;
            case MENU_EXIT:
                finish();
                System.exit(0);
                break;
        }
        return true;
    }

    private void launchExitActivity() {

    }

    private void launchHelpActivity() {
        new SettingsDialogFragment(R.layout.help_alert).show(getFragmentManager(), "dialog");
    }

//    private void launchSettingsActivity() {
//        Log.d(TAG, "showing settings");
//        Intent intent = new Intent(this, GlobalSettingsActivity.class);
//        startActivity(intent);
//    }

    private void launchAboutActivity() {
        Log.d(TAG, "showing about");
        new SettingsDialogFragment(R.layout.about_alert).show(getFragmentManager(), "dialog");
        //Intent intent = new Intent(this, AboutActivity.class);
        //startActivity(intent);
    }


        /* --- INTENTS FOR OTHER ACTIVITIES ----------------------------------------------------------- */

    /**
     * Starts the activity for creating a new poll/question.
     *
     * @param view The {@code View} object that invokes this method.
     */
    public void goToCreatePoll(View view)
    {
        startActivity(new Intent(this, CreatePollActivity.class));
    }

    /**
     * Starts the activity for loading a set polls/questions, from a .xml file.
     *
     * @param view The {@code View} object that invokes this method.
     */
    public void goToLoadPoll(View view)
    {
        startActivity(new Intent(this, QuestionSelectionActivity.class)) ;
    }
}
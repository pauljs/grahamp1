package com.grahamp1.polldance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * The home activity for the Host.
 *
 * @author Google Android Camp 2013, Graham + 1
 * @version 14th June 2013
 */
public class HostHomeActivity extends Activity
{
    /**
     * Initialises the home activity for the Host.
     *
     * @param savedInstanceState The previous saved state of this activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_home);
    }


    /* --- INTENTS FOR OTHER ACTIVITIES ----------------------------------------------------------- */

    /**
     * Starts the activity for creating a new poll/question.
     *
     * @param view The {@code View} object that invokes this method.
     */
    public void goToCreatePoll(View view)
    {
        startActivity(new Intent(HostHomeActivity.this, CreatePollActivity.class));
    }

    /**
     * Starts the activity for loading a set polls/questions, from a .xml file.
     *
     * @param view The {@code View} object that invokes this method.
     */
    public void goToLoadPoll(View view)
    {
        startActivity( new Intent(this,QuestionSelectionActivity.class) ) ;
    }
}
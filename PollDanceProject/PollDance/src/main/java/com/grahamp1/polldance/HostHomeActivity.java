package com.grahamp1.polldance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by demouser on 6/12/13.
 */
public class HostHomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_home);

    }

    public void goToCreatePoll(View view) {
        startActivity(new Intent(HostHomeActivity.this, CreatePollActivity.class));
    }

}

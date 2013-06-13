package com.grahamp1.polldance;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToHostHome(View view) {
        startActivity(new Intent(this, HostHomeActivity.class));
    }

    public void goToResponseScreen(View view) {
        //startActivity(new Intent(this, ClientResponseActivity.class));
    }
}
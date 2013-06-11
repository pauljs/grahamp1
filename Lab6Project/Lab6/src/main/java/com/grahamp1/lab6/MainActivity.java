package com.grahamp1.lab6;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.protocol.HTTP;

import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends Activity {

    EditText textInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput = (EditText)findViewById(R.id.editText);
    }

    public void goToMap(String str){
        Uri location = Uri.parse("geo:0,0?q=" + str.replaceAll("\\s", "+"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,location);
        startActivity(mapIntent);
    }

    public void sendEmail(String email){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Automated email");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "body text");

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(emailIntent,0);

        Intent chooser = Intent.createChooser(emailIntent,"Choose an email client");

        if(activities.size() > 0){
            startActivity(chooser);
        }else{
            Toast.makeText(getApplicationContext(),"No email applications found",Toast.LENGTH_SHORT).show();
        }
    }


    public void parseInput(View view){

        String input = textInput.getText().toString();
        String separated[] = input.split(",");
        for (String s : separated)
            s = s.trim();

        boolean emailAddresses = false;
        //boolean containsAt = separated[0]("\S+@\S\.\S+");
        for (int size = 0; size < separated.length; size++){
           boolean isEmailAddress = Pattern.matches("\\S+@\\S+\\.\\S+", separated[size]);
//            boolean containsAt = separated[size].contains("@");
            if (isEmailAddress) {
                emailAddresses = true;
                sendEmail(separated[size]);
            }
        }
        if (!emailAddresses)
            goToMap(input);



    }



}

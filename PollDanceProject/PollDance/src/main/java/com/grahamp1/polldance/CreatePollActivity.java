package com.grahamp1.polldance;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by demouser on 6/12/13.
 */
public class CreatePollActivity extends Activity {

    ArrayList<String> _listItems = new ArrayList<String>();
    ArrayAdapter<String> _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_poll);

        findViewById(R.id.create_answer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NewAnswerDialogFragment().show(getFragmentManager(), "dialog");
            }
        });

        findViewById(R.id.share_poll_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String questionText = ((EditText) findViewById(R.id.create_question_text))
                        .getText().toString();
            }
        });

        _adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _listItems);
        ListView lv = (ListView) findViewById(R.id.create_answer_list);
        lv.setAdapter(_adapter);

        lv.setClickable(true);
//        lv.setOnI
    }

    public void createNewAnswer(String answerText) {
        _listItems.add(answerText);
        _adapter.notifyDataSetChanged();
    }

}

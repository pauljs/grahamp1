package com.grahamp1.polldance ;

import android.app.Activity ;
import android.content.Intent ;
import android.os.Bundle ;

import android.text.Html ;
import android.text.method.LinkMovementMethod ;

import android.view.View ;

import android.widget.AdapterView ;
import android.widget.ArrayAdapter ;
import android.widget.EditText ;
import android.widget.ListView ;

import java.util.ArrayList ;


/**
 * Activity for Creating a Poll
 *
 * @author Google Android Camp 2013, Graham + 1
 * @version 14th June 2013
 */
public class CreatePollActivity extends Activity
{
    private ArrayList<String> _listItems = new ArrayList<String>();
    private ArrayAdapter<String> _adapter;


    /**
     * Instantiates the screen for creating a poll.
     *
     * @param savedInstanceState The previous saved state of this activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_poll);


        // Set click listeners to the 3 buttons
        findViewById(R.id.create_answer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NewAnswerDialogFragment().show(getFragmentManager(), "create_answer_dialog");
            }
        });

        findViewById(R.id.share_poll_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreatePollActivity.this, ClientResponseActivity.class);

                // get question and answer text from form
                String questionHtml = Html.toHtml(
                        ((EditText) findViewById(R.id.create_question_text)).getText()
                );
                ArrayList<Answer> answers = new ArrayList<Answer>();
                for (String s : _listItems)
                    answers.add(new Answer(s, false));
                Question q = new Question(questionHtml, answers);

                // pass data to ClientResponseActivity
                intent.putExtra( "question_object" , q ) ;
                startActivity( intent ) ;

            }
        });

        findViewById(R.id.add_hyperlink_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddHyperlinkFragment().show(getFragmentManager(), "hyperlink_dialog");
            }
        });


        // Set up ListView for the creation of answers.
        _adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _listItems);
        final ListView lv = (ListView) findViewById(R.id.create_answer_list);
        lv.setAdapter(_adapter);

        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                new EditAnswerDialogFragment(i, _listItems.get(i)).show(
                        getFragmentManager(), "dialog"
                );
            }
        });


        // Question EditText
        EditText questionText = ((EditText) findViewById(R.id.create_question_text));
        questionText.setMovementMethod(LinkMovementMethod.getInstance());
    }


    /**
     * Creates a new answer for the question using the specified text and adds it to the list of answers.
     *
     * @param answerText The text for the new answer.
     */
    public void createNewAnswer(String answerText)
    {
        // only adds the answer to the list of answers if there are non-whitespace text entered.
        if (!answerText.trim().equals(""))
        {
            _listItems.add(answerText);
            _adapter.notifyDataSetChanged();
        }
    }


    /**
     * Edits the text for an answer already added to the list of answers.
     *
     * @param i The index of the answer to be edited.
     * @param newAnswerText The new text of the specified answer.
     */
    public void editAnswerText(int i, String newAnswerText)
    {
        _listItems.set(i, newAnswerText);
        _adapter.notifyDataSetChanged();
    }
}

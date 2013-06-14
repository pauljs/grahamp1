package com.grahamp1.polldance ;

import android.app.Activity ;
import android.content.Intent;
import android.os.Bundle ;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Activity for the Question Selection Screen
 *
 * EF, MG
 */
public class QuestionSelectionActivity extends Activity
{
    private static final int QUESTIONS_XML = R.raw.questions ;
    private static final String NEWLINE = "\n" ;

    private ArrayList<Question> _questions ;

    private ListView _listView ;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState ) ;
        setContentView( R.layout.activity_question_selection ) ;

        // parse xml
        _questions = importXmlQuestions( QUESTIONS_XML ) ;


        // DISPLAY
        // array of questions for display
        String[] questionsList = new String[_questions.size()] ;

        int i = 0 ;
        for( Question q : _questions )
        {
            questionsList[i] = q.getText() ;
            i ++ ;
        }

        // load questions to ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this , android.R.layout.simple_list_item_single_choice , questionsList ) ;
        _listView = (ListView) findViewById( R.id.qs_listView ) ;
        _listView.setAdapter( adapter ) ;

        // response when an item is selected
        _listView.setClickable( true ) ;
        _listView.setChoiceMode( ListView.CHOICE_MODE_SINGLE ) ;
    }


    /* --- Question Selected ----------------------------------------------------------------------------------------- */

    /**
     * Opens the selected question for client response.
     *
     * @param view
     */
    public void openQuestion( View view )
    {
        int selected = _listView.getCheckedItemPosition();

        if (selected > -1) {
            Intent intent = new Intent( this , ClientResponseActivity.class ) ;
            intent.putExtra( "question_object" , _questions.get(selected) ) ;

            startActivity( intent ) ;
        } else {
            Toast.makeText(this, "Please select a question.", Toast.LENGTH_SHORT).show();
        }
    }


    /* --- XML PARSING ----------------------------------------------------------------------------------------------- */

    private ArrayList<Question> importXmlQuestions( int resource )
    {
        XMLParser parser = new XMLParser();
        ArrayList<Question> ret = new ArrayList<Question>();

        try
        {
            ret = parser.getQuestions(getXmlString(resource));
        }
        catch (Exception e)
        {}
        return ret ;
    }

    private String getXmlString( int resource )
    {
        InputStream stream = getResources().openRawResource(resource) ;
        InputStreamReader streamReader = new InputStreamReader(stream) ;
        BufferedReader buffRead = new BufferedReader(streamReader);

        StringBuilder builder  = new StringBuilder();
        String line;

        try
        {
            while ((line = buffRead.readLine()) != null)
            {
                builder.append(line + NEWLINE);
            }
        }
        catch (IOException e)
        {}

        return builder.toString();
    }
}

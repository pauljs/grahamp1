package com.grahamp1.polldance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by demouser on 6/12/13.
 */
public class ResultsActivity extends Activity {

    private ListView _listView;
    private ArrayList<String> _listItems = new ArrayList<String>();
    private ArrayAdapter<String> _adapter;

    private PieChartView _pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        _adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _listItems);
        _listView = (ListView) findViewById(R.id.results_answer_list);
        _listView.setAdapter(_adapter);

        // get data from ClientResponseActivity
        Bundle extras = getIntent().getExtras();
        ArrayList<Answer> answers = (ArrayList<Answer>) extras.get("answer_list");
        int[] votes = (int[]) extras.get("scores_list");
        String questionName = (String) extras.get("question_name");
        Question q = new Question(questionName, answers);

        // convert votes array to a list
        ArrayList<Integer> votesList = new ArrayList<Integer>();
        for (int n : votes)
            votesList.add(n);

        // make pie chart; add it to the pie_chart_pane
        _pieChart = new PieChartView(this, answers, votesList);
        FrameLayout pane = (FrameLayout) findViewById(R.id.pie_chart_pane);
        pane.addView(_pieChart);

        setQuestion(q);
    }

    public void setQuestion(Question question) {
        TextView questionView = (TextView) findViewById(R.id.results_question_text);
        questionView.setText(Html.fromHtml(question.getText()));
        questionView.setMovementMethod(LinkMovementMethod.getInstance());

        List<Answer> answers = question.getAnswers();

        for (int i = 0; i < answers.size(); i++) {
            Answer answer = answers.get(i);

            _listItems.add(String.valueOf(_pieChart.getPercentage(i)) + "%\t" + answer.getText());
            _adapter.notifyDataSetChanged();
            if (answer.getIsCorrect()) {
                _adapter.getView(_listItems.size() - 1, null, _listView)
                        .setBackgroundColor(Color.GREEN);
            }
        }
        _adapter.notifyDataSetChanged();

    }

    public void addVote(int index) {
        _pieChart.addVote(index);

        String[] splitItem = _listItems.get(index).split("\\s+");
        String newItem = String.valueOf(_pieChart.getPercentage(index)) + "%\t";
        for (int i = 1; i < splitItem.length; i++)
            newItem = newItem + splitItem[i];

        _listItems.set(index, newItem);
        _adapter.notifyDataSetChanged();
    }

    public void goToSplash(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

//    public void addRandomVote(View view) {
//        addVote((int)(Math.random()*_listItems.size()));
//        _pieChart.postInvalidate();
//    }

}

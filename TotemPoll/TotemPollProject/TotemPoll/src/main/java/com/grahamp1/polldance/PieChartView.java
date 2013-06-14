package com.grahamp1.polldance;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by demouser on 6/13/13.
 */
public class PieChartView extends View {

    private Paint _paint = new Paint();
    private List<Answer> _answers;
    private List<Integer> _votes; // number of votes for each answer
    private List<Integer> _colors; // color for each answer in the pie chart

    public PieChartView(Context context, List<Answer> answers, List<Integer> votes) {
        super(context);
        _answers = answers;
        _votes = votes;
        _paint.setStyle(Paint.Style.FILL);
        _paint.setColor(Color.CYAN);

        Random r = new Random(12343);
        _colors = new ArrayList<Integer>(_answers.size());
        for (Answer a : _answers) {
            _colors.add(Color.rgb(randColorValue(r), randColorValue(r), randColorValue(r)));
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int totalVotes = getTotalVotes();

        // frame of background rectangle
        int x = 0,
                y = 0,
                width = canvas.getWidth(),
                height = canvas.getHeight();

        // paint gray background rectangle
        _paint.setColor(Color.LTGRAY);
        _paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, x+width, y+height, _paint);

        int centerX = x + width/2;
        int centerY = y + height/2;
        int radius = (int)(0.95 * Math.min(centerX - x, centerY - y));
        RectF rectF = new RectF(centerX - radius, centerY - radius,
                centerX + radius, centerY + radius);

        double currAngle = 0.0;

        // paint pie slices
        for (int i = 0; i < _answers.size(); i++) {
            int numVotes = _votes.get(i);
            double angleSweep = 360.0 * numVotes / totalVotes;

            _paint.setColor(_colors.get(i));
            canvas.drawArc(rectF, (float)currAngle, (float)angleSweep, true, _paint);

            currAngle += angleSweep;
        }

        // paint circle outline
        _paint.setColor(Color.WHITE);
        _paint.setStyle(Paint.Style.STROKE);
        _paint.setStrokeWidth(5);
        canvas.drawArc(rectF, 0, 360, true, _paint);
    }

    public void addVote(int index) {
        if (index < _votes.size())
            _votes.set(index, _votes.get(index) + 1);
    }

    public int getColor(int index) {
        return _colors.get(index);
    }

    public int getPercentage(int index) {
        return (int)Math.round(100.0 * _votes.get(index) / getTotalVotes());
    }

    private int randColorValue(Random r) {
        return r.nextInt(255);
    }

    private int getTotalVotes() {
        int count = 0;
        for (Integer n : _votes)
            count += n;
        return count;
    }

    private ArrayList<Integer> getSortedVotesList() {
        ArrayList<Integer> votesCopy = new ArrayList<Integer>();
        for (Integer i : _votes)
            votesCopy.add(0);
        Collections.copy(votesCopy, _votes);
        return votesCopy;
    }

}

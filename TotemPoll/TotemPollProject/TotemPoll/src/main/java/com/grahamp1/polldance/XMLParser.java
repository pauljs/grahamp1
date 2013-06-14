package com.grahamp1.polldance;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;


/**
 * Parses a well-formed and exact .xml file.
 *
 * @author Google Android Camp 2013, Graham + 1
 * @version 14th June 2013
 */
public class XMLParser
{
    // Tag that wraps around all the answers in the .xml file.
    public static String TAG = "XMLParser";


    /**
     * Parses a {@code String} of text and returns the questions and their respective answers, in an {@code ArrayList}
     * of {@code Question} objects.
     *
     * @param text The text to be parsed.
     *
     * @return The questions and their respective answers, in an {@code Arraylist} of {@code Question} objects.
     *
     * @throws XmlPullParserException
     * @throws IOException
     */
    public ArrayList<Question> getQuestions(String text) throws XmlPullParserException, IOException
    {
        ArrayList <Question> questions = new ArrayList<Question>();
        ArrayList <Answer> tempAnswers = new ArrayList<Answer>();
        String tempQuestionText = " ";

        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(new StringReader(text));
        parser.nextTag();parser.nextTag();

        //our parser is now looking at the first question now
        //assumes well-formed and exact XML.
        try{
            while(true){
                tempQuestionText = parser.getAttributeValue(0);
                parser.nextTag();
                while(parser.getName().equals("answer")){
                    String tempAnswerText = parser.getAttributeValue(0);
                    boolean tempAnswerIsCorrect = Boolean.valueOf(parser.getAttributeValue(1));
                    tempAnswers.add(new Answer(tempAnswerText,tempAnswerIsCorrect));
                    parser.nextTag();parser.nextTag();
                }
                questions.add(new Question(tempQuestionText,tempAnswers));
                tempAnswers.clear();
                parser.nextTag();
            }
        }
        catch(Exception e){}//we are using an exception as a 'break', lel

        return questions;
    }
}

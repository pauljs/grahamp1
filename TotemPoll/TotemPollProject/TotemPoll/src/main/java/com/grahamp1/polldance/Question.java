package com.grahamp1.polldance ;

import java.io.Serializable ;
import java.util.ArrayList ;

/**
 * A wrapper class for a question/poll.
 *
 * @author Google Android Camp 2013, Graham + 1
 * @version 14th June 2013
 */
public class Question implements Serializable
{
    String text;
    ArrayList <Answer> answers;

    /**
     * Creates a {@code Question} object with the specified question and corresponding {@code ArrayList} of answers.
     *
     * @param text The question.
     * @param answers The {@code ArrayList} of answers corresponding to this question.
     */
    public Question(String text, ArrayList<Answer> answers)
    {
        this.text = text;
        this.answers = new ArrayList<Answer>(answers);
    }


    /* --- GETTERS ----------------------------------------------------------------------------------- */

    /**
     * Returns the question asked.
     *
     * @return The question asked.
     */
    public String getText()
    {
        return text;
    }

    /**
     * Returns the {@code Arraylist} of answers corresponding to this question.
     *
     * @return The {@code Arraylist} of answers corresponding to this question.
     */
    public ArrayList<Answer> getAnswers()
    {
        return answers;
    }


    /* --- SETTERS -------------------------------------------------------------------------------- */

    /**
     * Sets the text for this question.
     *
     * @param text The test to be asked by this question.
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * Sets the list of answers corresponding to this question.
     *
     * @param answers The list of answers.
     */
    public void setAnswers(ArrayList <Answer> answers)
    {
        this.answers = answers;
    }
}

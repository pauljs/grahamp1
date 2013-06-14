package com.grahamp1.polldance ;

import java.io.Serializable ;


/**
 * A wrapper class for an answer option for a question.
 *
 * @author Google Android Camp 2013, Graham + 1
 * @version 14th June 2013
 */
public class Answer implements Serializable
{
    String text ;
    boolean isCorrect ;


    /**
     * Creates a new {@code Answer} object with the specified text and {@code true} if this answer is the correct answer
     * to its question, {@code false} otherwise.
     *
     * @param text The text for this answer.
     * @param isCorrect {@code true} if this answer is the correct answer to its question, {@code false} otherwise.
     */
    public Answer(String text, boolean isCorrect)
    {
        this.text = text;
        this.isCorrect = isCorrect;
    }


    /* -- GETTERS -------------------------------------------------------------------------------------------------- */

    /**
     * Returns the text of this answer.
     *
     * @return The text of this answer.
     */
    public String getText()
    {
        return text;
    }

    /**
     * Returns {@code true} if this answer is the correct answer to its question, {@code false} otherwise.
     *
     * @return {@code true} if this answer is the correct answer to its question, {@code false} otherwise.
     */
    public boolean getIsCorrect(){
        return isCorrect;
    }


    /* --- SETTERS ------------------------------------------------------------------------------------------------- */

    /**
     * Sets the text for this answer.
     *
     * @param text The text to be set to this answer.
     */
    public void setText(String text){
        this.text = text;
    }

    /**
     * Sets this answer to be correct or not.
     *
     * @param isCorrect {@code true} if this answer is the correct answer to its question, {@code false} otherwise.
     */
    public void setIsCorrect(boolean isCorrect){
        this.isCorrect = isCorrect;
    }
}

package com.grahamp1.polldance ;

/**
 * A wrapper class that wraps an answer and whether the answer is correct.
 *
 * EF
 */
public class Answer
{
    // The answer.
    private String answer ;

    // Whether this answer is correct or not.
    private boolean isCorrect ;


    /**
     * Constructs an answer object.
     *
     * @param answer The answer.
     * @param isCorrect Whether the answer is correct or not.
     */
    public Answer( String answer , boolean isCorrect )
    {
        this.answer = answer ;
        this.isCorrect = isCorrect ;
    }


    /**
     * Returns the answer of this answer option.
     *
     * @return The answer of this answer option.
     */
    public String getText()
    {
        return answer ;
    }

    /**
     * Returns {@code true} if this answer is correct, {@code false} otherwise.
     *
     * @return {@code true} if this answer is correct, {@code false} otherwise.
     */
    public boolean isCorrect()
    {
        return isCorrect ;
    }
}
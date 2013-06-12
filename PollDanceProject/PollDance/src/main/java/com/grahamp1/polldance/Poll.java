package com.grahamp1.polldance ;

import java.util.List ;
import java.util.ArrayList ;

/**
 * Stores information regarding a poll.
 *
 * EF
 */
public class Poll
{
    // initial question if none is passed into the constructor
    private static final String INIT_QUESTION = "" ;

    // The question the poll is asking
    private String _question ;

    // The list of potential answers
    private List<Answer> _answers ;


    /* --- CONSTRUCTORS ------------------------------------------------------- */

    /**
     * Initialises an empty poll with the default initial question, {@code ""}.
     */
    public Poll()
    {
        this( INIT_QUESTION ) ;
    }


    /**
     * Initialises an empty poll with the specified question, {@code question}.
     *
     * @param question The question the poll asks.
     */
    public Poll( String question )
    {
        _question = question ;
        _answers = new ArrayList<Answer>() ;
    }


    /* --- FUNCTIONS ---------------------------------------------------------- */

    /**
     * Sets the question of the poll.
     *
     * @param question The question the poll asks.
     */
    public void setQuestion( String question )
    {
        _question = question ;
    }


    /**
     * Creates an answer option for the poll.
     *
     * @param answer The answer.
     * @param isCorrect {@code true} if this answer is correct, {@code false} otherwise.
     */
    public void setAnswer( String answer , boolean isCorrect )
    {
        Answer tmp = new Answer( answer , isCorrect ) ;
        _answers.add( tmp ) ;
    }


    /* --- PRIVATE CLASSES ---------------------------------------------------- */

    /**
     * A wrapper class that wraps an answer and whether the answer is correct.
     */
    private class Answer
    {
        private String answer ;
        private boolean isCorrect ;

        /**
         * Constructs an answer object.
         *
         * @param answer The answer.
         * @param isCorrect Whether the answer is correct or not.
         */
        private Answer( String answer , boolean isCorrect )
        {
            this.answer = answer ;
            this.isCorrect = isCorrect ;
        }
    }
}

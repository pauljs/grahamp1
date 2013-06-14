package com.grahamp1.polldance;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores the results of a poll.
 *
 * EF
 */
public class Result
{
    // Total number of responses expected and the number of responses received
    private int _expected , _counter ;

    // Map of answer numbers and the number of people who selected each answer.
    private Map<Integer,Integer> _responses ;


    /**
     * Initialises the results object with the number of answers there are in the poll.
     *
     * @param expected The expected number of responses.
     * @param numAnswers The number of answers the poll has.
     */
    public Result( int expected , int numAnswers )
    {
        _expected = expected ;
        _responses = new HashMap<Integer,Integer>( numAnswers ) ;
    }


    /* --- RECEIVING RESPONSES ---------------------------------------------------- */

    /**
     * Adds a response.
     *
     * @param answerNum The selected answer number.
     */
    public void addResponse( int answerNum )
    {
        Integer existing = _responses.get( answerNum ) ;

        if( existing == null )
        {
            _responses.put( answerNum , 0 ) ;
        }
        else
        {
            _responses.put( answerNum , existing + 1 ) ;
        }

        _counter ++ ;
    }


    /* --- DISPLAYING RESULTS ----------------------------------------------------- */

    /**
     * Returns the number of responses received for the specified answer.
     *
     * @param answerNum The answer whose number of responses is to be returned.
     *
     * @return The number of responses received for the specified answer.
     */
    public int getNumResponses( int answerNum )
    {
        Integer num = _responses.get( answerNum ) ;

        if( num == null )
        {
            return 0 ;
        }
        else
        {
            return num.intValue() ;
        }
    }


    /**
     * Returns the number of people that did not submit a response.
     *
     * @return The number of people that did not submit a response.
     */
    public int getNumUndecided()
    {
        return _expected - _counter ;
    }
}

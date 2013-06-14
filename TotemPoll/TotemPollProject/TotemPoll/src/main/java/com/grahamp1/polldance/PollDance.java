package com.grahamp1.polldance;

import android.app.Application;

import java.io.OutputStream;

/**
 * Created by demouser on 6/13/13.
 */
public class PollDance extends Application {
    OutputStream outputStream;

    public OutputStream getOutputStream(){
        return outputStream;
    }

    public void setOutputStream(OutputStream os){
        outputStream = os;
    }
}


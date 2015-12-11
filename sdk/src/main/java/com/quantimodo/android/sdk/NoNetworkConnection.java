package com.quantimodo.android.sdk;

/**
 * Thrown if there is no internet connection
 */
public class NoNetworkConnection extends Exception{
    public NoNetworkConnection(){
        super("No network connection");
    }
}

package org.jaatadia.subsync.model.exceptions;

public class InvalidRangeException extends Exception {

    public InvalidRangeException(String range){
        super("Time Range is not valid: "+range);
    }
}

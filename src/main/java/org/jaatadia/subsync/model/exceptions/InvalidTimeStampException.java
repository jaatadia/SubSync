package org.jaatadia.subsync.model.exceptions;

public class InvalidTimeStampException extends Exception {

    public InvalidTimeStampException(String range){
        super("Timestamp is not valid: "+range);
    }
}

package org.jaatadia.subsync.model.exceptions;

public class InvalidTimeRangeException extends InvalidRequestException {

    public InvalidTimeRangeException(String range){
        super("Time Range is not valid: "+range);
    }
}

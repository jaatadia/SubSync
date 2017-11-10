package org.jaatadia.subsync.model.exceptions;

public class InvalidTimeRangeException extends InvalidSubtitleException {

    public InvalidTimeRangeException(String range){
        super("Time Range is not valid: "+range);
    }
}

package org.jaatadia.subsync.model.exceptions;

public class InvalidTimeStampException extends InvalidSubtitleException {

    public InvalidTimeStampException(String timestamp){
        super("Timestamp is not valid: "+timestamp);
    }
}

package org.jaatadia.subsync.model.exceptions;

public class InvalidTimeStampException extends InvalidRequestException {

    public InvalidTimeStampException(String timestamp){
        super("Timestamp is not valid: "+timestamp);
    }
}

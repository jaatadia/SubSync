package org.jaatadia.subsync.model.exceptions;

public class InvalidSubtitleException extends InvalidRequestException {
    public InvalidSubtitleException(String sub){
        super("SubtitleConstruction is not valid: "+sub);
    }
}

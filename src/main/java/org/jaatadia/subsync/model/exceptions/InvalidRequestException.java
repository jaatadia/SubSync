package org.jaatadia.subsync.model.exceptions;

public abstract class InvalidRequestException extends Exception {

    public InvalidRequestException(String msg){
        super(msg);
    }

}

package com.CL3RamirezAquinoClever.ExamenCL3.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
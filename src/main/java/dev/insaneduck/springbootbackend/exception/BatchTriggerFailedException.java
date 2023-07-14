package dev.insaneduck.springbootbackend.exception;

public class BatchTriggerFailedException extends RuntimeException{
    public BatchTriggerFailedException(String message)
    {
        super(message);
    }

}

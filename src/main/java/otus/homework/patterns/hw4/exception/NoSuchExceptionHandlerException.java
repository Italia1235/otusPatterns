package otus.homework.patterns.hw4.exception;

public class NoSuchExceptionHandlerException extends RuntimeException{

    public NoSuchExceptionHandlerException(String message) {
        super(message);
    }

    public NoSuchExceptionHandlerException(Exception e) {
        super(e);
    }
}

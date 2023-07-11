package otus.homework.patterns.hw4.handler;

import otus.homework.patterns.hw2.intrf.Command;

public interface ExceptionHandlerStrategy {
    String getExceptionHandler(Exception exception, Command command);
}

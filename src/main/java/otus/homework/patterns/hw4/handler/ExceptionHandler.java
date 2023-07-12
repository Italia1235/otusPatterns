package otus.homework.patterns.hw4.handler;

import otus.homework.patterns.hw2.intrf.Command;

public interface  ExceptionHandler {
    void handle(Exception exception, Command command);

}

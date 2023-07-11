package otus.homework.patterns.hw4.handler;

import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw4.command.RepeatCommand;

public class RepeatThanLogExceptionHandlerStrategy implements  ExceptionHandlerStrategy {

    @Override
    public String getExceptionHandler(Exception exception, Command command) {
        if (command instanceof RepeatCommand) {
            return LogExceptionHandler.class.getName();
        } else {
            return RepeatExceptionHandler.class.getName();
        }
    }


}

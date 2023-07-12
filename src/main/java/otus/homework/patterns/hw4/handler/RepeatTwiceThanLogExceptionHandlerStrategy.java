package otus.homework.patterns.hw4.handler;

import otus.homework.patterns.hw2.intrf.Command;

public class RepeatTwiceThanLogExceptionHandlerStrategy implements ExceptionHandlerStrategy  {

    @Override
    public String getExceptionHandler(Exception exception, Command command) {
        if (command instanceof Command) {
            return LogExceptionHandler.class.getName();
        } else {
            return RepeatExceptionHandler.class.getName();
        }
    }

}

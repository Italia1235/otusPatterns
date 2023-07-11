package otus.homework.patterns.hw4.handler;

import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw2.intrf.CommandQueue;
import otus.homework.patterns.hw4.command.LogCommand;

public class LogExceptionHandler implements ExceptionHandler {

    private final CommandQueue commandQueue;

    public LogExceptionHandler(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void handle(Exception exception, Command command) {
        commandQueue.addLast(new LogCommand(exception, command));
    }
}

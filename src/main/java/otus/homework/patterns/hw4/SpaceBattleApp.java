package otus.homework.patterns.hw4;

import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw2.intrf.CommandQueue;
import otus.homework.patterns.hw4.handler.ExceptionHandlerStrategy;
import otus.homework.patterns.hw4.handler.RouterExceptionHandler;

public class SpaceBattleApp {

    private final CommandQueue commandQueue;
    private final RouterExceptionHandler exceptionHandler;

    public SpaceBattleApp(CommandQueue commandQueue, ExceptionHandlerStrategy exceptionHandlerStrategy) {
        this.commandQueue = commandQueue;
        this.exceptionHandler = new RouterExceptionHandler(commandQueue, exceptionHandlerStrategy);
    }

    public void process() {
        Command command;
        while ((command = commandQueue.readFirst()) != null) {
            try {
                command.execute();
            } catch (Exception exception) {
                exceptionHandler.handle(exception, command);
            }
        }
    }
}

package otus.homework.patterns.hw4.handler;

import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw2.intrf.CommandQueue;
import otus.homework.patterns.hw4.command.RepeatCommand;
import otus.homework.patterns.hw4.command.TwiceRepeatCommand;

public class RepeatExceptionHandler  implements ExceptionHandler  {
    private final CommandQueue commandQueue;

    public RepeatExceptionHandler(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void handle(Exception exception, Command command) {
        if (command instanceof RepeatCommand) {
            commandQueue.addLast(new TwiceRepeatCommand(command));
        } else {
            commandQueue.addLast(new RepeatCommand(command));
        }
    }


}

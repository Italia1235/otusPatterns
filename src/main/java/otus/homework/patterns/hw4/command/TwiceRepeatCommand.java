package otus.homework.patterns.hw4.command;

import otus.homework.patterns.hw2.intrf.Command;

public class TwiceRepeatCommand extends RepeatCommand{
    public TwiceRepeatCommand(Command command) {
        super(command);
    }

}

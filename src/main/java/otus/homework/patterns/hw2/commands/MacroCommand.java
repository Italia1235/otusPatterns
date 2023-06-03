package otus.homework.patterns.hw2.commands;

import otus.homework.patterns.hw2.exepiton.CommandException;
import otus.homework.patterns.hw2.intrf.Command;

import java.util.ArrayList;
import java.util.List;


public class MacroCommand implements Command {
    List<Command> commandList;

    public MacroCommand(List<Command> commands) {
        this.commandList = commands;
    }


    @Override
    public void execute() {
        try {

            for (Command command : commandList) {
                command.execute();
            }
        } catch (Exception ex) {
            throw new CommandException(ex);
        }
    }

}

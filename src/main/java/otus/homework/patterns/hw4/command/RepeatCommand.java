package otus.homework.patterns.hw4.command;
import otus.homework.patterns.hw2.intrf.Command;
public class RepeatCommand implements Command {

    private final Command command;

    public RepeatCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }
}

package otus.homework.patterns.hw2.exepiton;

public class CommandException extends RuntimeException {

    public CommandException(String message) {
        super(message);
    }

    public CommandException(Exception e) {
        super(e);
    }
}
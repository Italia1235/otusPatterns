package otus.homework.patterns.hw2.intrf;

import otus.homework.patterns.hw2.intrf.Command;

public interface CommandQueue {

    void addLast(Command command);

    Command readFirst();
}

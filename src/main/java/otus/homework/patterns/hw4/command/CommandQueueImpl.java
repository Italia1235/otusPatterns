package otus.homework.patterns.hw4.command;

import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw2.intrf.CommandQueue;

import java.util.Deque;
import java.util.LinkedList;

public class CommandQueueImpl implements CommandQueue {
    private final Deque<Command> deque;

    public CommandQueueImpl() {
        this.deque = new LinkedList<>();
    }

    @Override
    public void addLast(Command object) {
        deque.addLast(object);
    }

    @Override
    public Command readFirst() {
        return deque.pollFirst();
    }


}

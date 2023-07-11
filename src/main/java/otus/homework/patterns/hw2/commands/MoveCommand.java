package otus.homework.patterns.hw2.commands;

import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw3.Coordinates;
import otus.homework.patterns.hw3.Movable;

public class MoveCommand implements Command {
    private final Movable movable;

    public MoveCommand(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute() {
        if (movable == null) {
            throw new IllegalArgumentException("Object is null");
        }
        if (movable.getPosition() == null) {
            throw new IllegalArgumentException("Can not get position");
        }
        if (movable.getVelocity() == null) {
            throw new IllegalArgumentException("Can not get velocity");
        }
        movable.setPosition(Coordinates.plus(movable.getPosition(), movable.getVelocity()));
    }
}
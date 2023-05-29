package otus.homework.patterns.hw3;

public class Movement {

    private final Movable movable;

    public Movement(Movable movable) {
        this.movable = movable;
    }

    public void execute() {
        if (movable == null) {
            throw new IllegalStateException("Object is null");
        }
        if (movable.getPosition() == null) {
            throw new IllegalStateException("Can not get position");
        }
        if (movable.getVelocity() == null) {
            throw new IllegalStateException("Can not get velocity");
        }
        movable.setPosition(Coordinates.plus(movable.getPosition(), movable.getVelocity()));
    }
}

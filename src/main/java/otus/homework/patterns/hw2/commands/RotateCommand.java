package otus.homework.patterns.hw2.commands;

import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw3.Rotatable;

public class RotateCommand implements Command {

    public Rotatable rotatable;

    public RotateCommand(Rotatable rotatable){
        this.rotatable = rotatable;
    }
    @Override
    public void execute() {
        if (rotatable == null) {
            throw new IllegalArgumentException("Object is null");
        }
        if (rotatable.getDirectionsNum() == 0) {
            throw new IllegalArgumentException("Directions num is zero");
        }
        rotatable.setDirection((rotatable.getDirection() + rotatable.getAngularVelocity()) % rotatable.getDirectionsNum());
    }

}

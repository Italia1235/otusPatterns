package otus.homework.patterns.hw2.commands;

import otus.homework.patterns.hw2.exepiton.CommandException;
import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw2.intrf.FuelBurnable;

public class BurnFuelCommand implements Command {
    private final FuelBurnable fuelBurnable;

    public BurnFuelCommand(FuelBurnable fuelBurnable) {
        this.fuelBurnable = fuelBurnable;
    }

    @Override
    public void execute() {
        if (fuelBurnable == null) {
            throw new CommandException("object is null");
        }
        int level = fuelBurnable.getFuelLevel() - fuelBurnable.getFuelBurnVelocity();

        if(level <0){
            throw new CommandException("fuel is end");
        }


        fuelBurnable.setFuelLevel(level);
    }
}

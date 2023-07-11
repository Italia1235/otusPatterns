package otus.homework.patterns.hw2.commands;

import otus.homework.patterns.hw2.exepiton.CommandException;
import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw2.intrf.FuelCheking;

public class CheckFuelCommand implements Command {
    private final FuelCheking fuelCheking;

    public CheckFuelCommand(FuelCheking fuelCheking) {
        this.fuelCheking = fuelCheking;
    }

    @Override
    public void execute() {
        if (fuelCheking==null){
            throw new CommandException("object is null ");

        }

        if (fuelCheking.getFuellvl() < fuelCheking.getFuelBurnVelocity()) {
            throw new CommandException("fuel is end");
        }
    }
}

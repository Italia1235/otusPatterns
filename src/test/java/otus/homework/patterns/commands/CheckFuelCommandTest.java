package otus.homework.patterns.commands;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import otus.homework.patterns.hw2.commands.CheckFuelCommand;
import otus.homework.patterns.hw2.exepiton.CommandException;
import otus.homework.patterns.hw2.intrf.FuelCheking;

import static org.mockito.Mockito.*;
public class CheckFuelCommandTest {

    @Mock
    private FuelCheking fuelCheking;
    private CheckFuelCommand checkFuelCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        checkFuelCommand = new CheckFuelCommand(fuelCheking);
    }


    @Test
    public void shoutDoNothungWhenFuelisEnd() {
        when(fuelCheking.getFuellvl()).thenReturn(10);
        when(fuelCheking.getFuelBurnVelocity()).thenReturn(5);
        checkFuelCommand.execute();
        verify(fuelCheking, times(1)).getFuellvl();

    }

@Test
    public void shouldThrowExceptionWhenNotEnoughFuelToBurn() {
        when(fuelCheking.getFuellvl()).thenReturn(1);
        when(fuelCheking.getFuelBurnVelocity()).thenReturn(2);
        Assert.assertThrows(CommandException.class, () -> {
            checkFuelCommand.execute();
        });

    }
}

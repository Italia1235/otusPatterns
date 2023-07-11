package otus.homework.patterns.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import otus.homework.patterns.hw2.commands.BurnFuelCommand;
import otus.homework.patterns.hw2.exepiton.CommandException;
import otus.homework.patterns.hw2.intrf.FuelBurnable;
import static org.mockito.Mockito.*;
public class BurnFuelCommandTest {
    @Mock
    private FuelBurnable fuelBurnable;
    private BurnFuelCommand burnFuelCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burnFuelCommand = new BurnFuelCommand(fuelBurnable);
    }


    @Test
    public void shouldBurnFuelToCorrectLevel() {
        when(fuelBurnable.getFuelLevel()).thenReturn(10);
        when(fuelBurnable.getFuelBurnVelocity()).thenReturn(5);
        burnFuelCommand.execute();

        verify(fuelBurnable, times(1)).setFuelLevel((5));
    }

    @Test
    public void shouldThrowExceptionWhenNotEnoughFuelToBurn() {
        when(fuelBurnable.getFuelLevel()).thenReturn(1);
        when(fuelBurnable.getFuelBurnVelocity()).thenReturn(2);
        Assert.assertThrows(CommandException.class, () -> {
            burnFuelCommand.execute();
        });
    }
}
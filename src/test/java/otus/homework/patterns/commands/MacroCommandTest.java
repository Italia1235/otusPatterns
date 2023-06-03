package otus.homework.patterns.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import otus.homework.patterns.hw2.commands.BurnFuelCommand;
import otus.homework.patterns.hw2.commands.CheckFuelCommand;
import otus.homework.patterns.hw2.commands.MacroCommand;
import otus.homework.patterns.hw2.exepiton.CommandException;
import otus.homework.patterns.hw2.intrf.FuelBurnable;

import static org.mockito.Mockito.*;

import java.util.List;

public class MacroCommandTest {


    private MacroCommand macroCommand;

    private BurnFuelCommand burnFuelCommand;
    @Mock
    private FuelBurnable fuelBurnable;
    @Mock
    private CheckFuelCommand checkFuelCommand;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        burnFuelCommand = new BurnFuelCommand(fuelBurnable);
        macroCommand = new MacroCommand(List.of(burnFuelCommand,checkFuelCommand));
    }


    //проверям что выполнилась последняя команда в списке
    @Test public void commandsExecuteWhenMacroExecute() {
        macroCommand.execute();
        verify(checkFuelCommand, times(1)).execute();
    }

        @Test public void shouldCommandStopWhenThrowExeption(){
            when(fuelBurnable.getFuelLevel()).thenReturn(1);
            when(fuelBurnable.getFuelBurnVelocity()).thenReturn(2);
            Assert.assertThrows(CommandException.class, () -> {
                macroCommand.execute();
            });
            verify(checkFuelCommand,never()).execute();



        }
}

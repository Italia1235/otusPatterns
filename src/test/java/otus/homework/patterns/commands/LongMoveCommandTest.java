package otus.homework.patterns.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import otus.homework.patterns.hw2.commands.LongMoveCommand;
import otus.homework.patterns.hw2.commands.MoveCommand;
import otus.homework.patterns.hw2.exepiton.CommandException;
import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw2.intrf.CommandQueue;
import static org.mockito.Mockito.*;
public class LongMoveCommandTest {

    @Mock
    private MoveCommand moveCommand;

    @Mock
    private CommandQueue commandQueue;
    private  LongMoveCommand longMoveCommand;



    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        longMoveCommand = new LongMoveCommand(moveCommand,commandQueue );
    }

    @Test
    public void shouldExecuteCheckFuelMoveBurnFuelCommands() {
        longMoveCommand.execute();

        verify(moveCommand, times(1)).execute();
        verify(commandQueue, times(1)).addLast(argThat(c -> c == longMoveCommand));

        InOrder inOrder = inOrder(moveCommand, commandQueue);
        inOrder.verify(moveCommand).execute();
        inOrder.verify(commandQueue).addLast(any(Command.class));
    }

    @Test
    public void shouldStopInCaseOfException() {
        RuntimeException exception = new RuntimeException("");
        doThrow(exception).when(moveCommand).execute();

        Assert.assertThrows(CommandException.class,()->{
            longMoveCommand.execute();
        });

    }


}

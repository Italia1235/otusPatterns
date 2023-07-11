package otus.homework.patterns.hw4Test;
import org.junit.Before;
import org.junit.Test;
import otus.homework.patterns.hw2.intrf.CommandQueue;
import otus.homework.patterns.hw4.command.RepeatCommand;
import otus.homework.patterns.hw4.handler.RepeatExceptionHandler;

import static org.mockito.Mockito.*;

public class RepeatExceptionHandlerTest {
    private CommandQueue commandQueue;
    private RepeatExceptionHandler repeatExceptionHandler;

    @Before
    public void setUp() {
        commandQueue = mock(CommandQueue.class);
        repeatExceptionHandler = new RepeatExceptionHandler(commandQueue);
    }


    @Test
    public void shouldAddRepeatCommandToQueue() {
        repeatExceptionHandler.handle(new Exception("Test"), () -> { });
        verify(commandQueue).addLast(any(RepeatCommand.class));
    }
}

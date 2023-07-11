package otus.homework.patterns.hw4Test;
import org.junit.Before;
import org.junit.Test;
import otus.homework.patterns.hw2.intrf.CommandQueue;
import otus.homework.patterns.hw4.command.LogCommand;
import otus.homework.patterns.hw4.handler.LogExceptionHandler;

import static org.mockito.Mockito.*;
public class LogExceptionHandlerTest {
    private CommandQueue commandQueue;
    private LogExceptionHandler logExceptionHandler;

    @Before
    public void setUp() {
        commandQueue = mock(CommandQueue.class);
        logExceptionHandler = new LogExceptionHandler(commandQueue);
    }


    @Test
    public void shouldAddLogCommandToQueue() {
        logExceptionHandler.handle(new Exception("Test"), () -> { });
        verify(commandQueue).addLast(any(LogCommand.class));
    }
}

package otus.homework.patterns.hw4Test;

import org.junit.Test;
import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw4.command.RepeatCommand;
import static org.mockito.Mockito.*;
public class RepeatCommandTest {
    @Test
    public void shouldRepeatFailedCommand() {
        Command failedCommand = mock(Command.class);
        RepeatCommand repeatCommand = new RepeatCommand(failedCommand);
        repeatCommand.execute();
        verify(failedCommand, times(1)).execute();
    }

}


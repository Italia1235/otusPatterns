package otus.homework.patterns.hw4Test;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw2.intrf.CommandQueue;
import otus.homework.patterns.hw4.SpaceBattleApp;
import otus.homework.patterns.hw4.command.CommandQueueImpl;
import otus.homework.patterns.hw4.command.LogCommand;
import otus.homework.patterns.hw4.command.RepeatCommand;

import otus.homework.patterns.hw4.handler.RepeatThanLogExceptionHandlerStrategy;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
public class SpaceBattleAppTest {

    @Test
    public void shouldRepeatThanLog() {
        CommandQueue commandQueue = spy(new CommandQueueImpl());

        SpaceBattleApp app = new SpaceBattleApp(commandQueue, new RepeatThanLogExceptionHandlerStrategy());

        RuntimeException thrownException = new RuntimeException("test");
        Command command = () -> { throw thrownException; };
        commandQueue.addLast(command);

        app.process();

        ArgumentCaptor<Command> commandCaptor = ArgumentCaptor.forClass(Command.class);
        verify(commandQueue, times(3)).addLast(commandCaptor.capture());
        List<Command> commandsAdded = commandCaptor.getAllValues();
        assertThat(commandsAdded.get(0)).isEqualTo(command);
        assertThat(commandsAdded.get(1).getClass()).isEqualTo(RepeatCommand.class);
        assertThat(commandsAdded.get(2).getClass()).isEqualTo(LogCommand.class);
    }


}

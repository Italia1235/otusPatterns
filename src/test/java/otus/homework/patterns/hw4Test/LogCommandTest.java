package otus.homework.patterns.hw4Test;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import otus.homework.patterns.hw2.intrf.Command;
import otus.homework.patterns.hw4.command.LogCommand;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
public class LogCommandTest {
    @Test
    public void shouldLogCommandException() {
        Logger commandLogger = (Logger) LoggerFactory.getLogger(LogCommand.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        commandLogger.addAppender(listAppender);

        Command command = mock(Command.class);
        Exception exception = new IllegalStateException("shouldLogCommandException");

        LogCommand logCommand = new LogCommand(exception, command);
        logCommand.execute();

        List<ILoggingEvent> logsList = listAppender.list;

        assertThat(logsList.size()).isEqualTo(1);
        assertThat(logsList.get(0).getLevel()).isEqualTo(Level.ERROR);
        assertThat(logsList.get(0).getFormattedMessage()).isEqualTo(String.format("Exception type=%s message=%s was thrown while executing command=%s",
                exception.getClass().getName(), exception.getMessage(), command.getClass().getName()));
    }
}


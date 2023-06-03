package otus.homework.patterns;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import otus.homework.patterns.hw3.Coordinates;
import otus.homework.patterns.hw3.Movable;
import otus.homework.patterns.hw3.Movement;



public class MovementTest {
    @Mock
    private Movable movable;
    private Movement movement;

    @Before
    public void setUp() {
     MockitoAnnotations.openMocks(this);
        movement = new Movement(movable);
    }

    @Test
    public void shouldMoveObjectToCorrectPosition() {

        Mockito.when(movable.getPosition()).thenReturn(new Coordinates(12, 5));
        Mockito.when(movable.getVelocity()).thenReturn(new Coordinates(-7, 3));
        movement.execute();
        Mockito.verify(movable, Mockito.times(1)).setPosition(Mockito.argThat(coords -> coords.getX() == 5 && coords.getY() == 8));
    }

    @Test
    public void shouldThrowExceptionWhenCanNotReadPosition() {
        Mockito.when(movable.getPosition()).thenReturn(null);

        Assert.assertThrows(IllegalStateException.class, () -> {
            movement.execute();
        });

    }


    @Test
    public void shouldThrowExceptionWhenCanNotReadVelocity() {
        Mockito.when(movable.getPosition()).thenReturn(new Coordinates(12, 5));
        Mockito.when(movable.getVelocity()).thenReturn(null);
        Assert.assertThrows(IllegalStateException.class, () -> {
            movement.execute();
        });
    }


    @Test
    public void shouldThrowExceptionWhenCanNotChangePosition() {
        Mockito.when(movable.getPosition()).thenReturn(new Coordinates(12, 5));
        Mockito.when(movable.getVelocity()).thenReturn(new Coordinates(-7, 3));
        Mockito.doThrow(new RuntimeException("")).when(movable).setPosition(Mockito.any());

        Assert.assertThrows(RuntimeException.class, () -> {
            movement.execute();
        });

    }



}
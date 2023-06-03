package otus.homework.patterns;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import otus.homework.patterns.hw1.QuadraticEquation;


public class QuadraticEquationTest {
    private QuadraticEquation quadraticEquation;
    final double accuracy = 1e-6;
    @Before
   public void setUp(){
        this.quadraticEquation = new QuadraticEquation(1e-6);
    }
  @Test
  public void shouldHaveNoRootsWhenDiscriminantIsLessZero() {
        double a = 1d;
        double b = 0d;
        double c = 1d;
        double[] result = quadraticEquation.solve(a, b, c);

      Assert.assertEquals(0,result.length);
    }


    @Test
    public void shouldHaveTwoDifferentRootsWhenDiscriminantIsMoreZero() {
        double a = 1d;
        double b = 0d;
        double c = -1d;
        double[] result = quadraticEquation.solve(a, b, c);
        Assert.assertEquals(2,result.length);
        Assert.assertEquals(1,result[0],accuracy);
        Assert.assertEquals(-1,result[1],accuracy);

    }

    @Test
    public void shouldHaveTwoSameRootsWhenDiscriminantIsEqualZero() {
        double a = 1d + 1e-10;
        double b = 2d + 1e-10;
        double c = 1d + 1e-10;
        double[] result = quadraticEquation.solve(a, b, c);
        Assert.assertEquals(2,result.length);
        Assert.assertEquals(-1,result[0],accuracy);
        Assert.assertEquals(-1,result[1],accuracy);
          }

  @Test
  public void shouldThrowExceptionWhenCoefficientAIsEqualZero() {
      double a = accuracy / 2d;
      double b = 2d;
      double c = 1d;
      Assert.assertThrows(IllegalArgumentException.class,() -> {
          quadraticEquation.solve(a, b, c);
      });
  }

    @Test
    public void shouldThrowExceptionWhenCoefficientIsInfinite() {
        for (double[] coefficients: new double[][] {
                new double[] {Double.POSITIVE_INFINITY, 1d, 1d},
                new double[] {1d, Double.POSITIVE_INFINITY, 1d},
                new double[] {1d, 1d, Double.POSITIVE_INFINITY},
                new double[] {Double.NEGATIVE_INFINITY, 1d, 1d},
                new double[] {1d, Double.NEGATIVE_INFINITY, 1d},
                new double[] {1d, 1d, Double.NEGATIVE_INFINITY}
        }) {
            Assert.assertThrows(IllegalArgumentException.class,() -> {
                quadraticEquation.solve(coefficients[0], coefficients[1], coefficients[2]);
            });
        }
    }


}

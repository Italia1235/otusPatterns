package otus.homework.patterns.hw5Test;
import org.junit.Test;
import otus.homework.patterns.hw5.SortingProgram;
import java.io.*;

import static org.junit.Assert.assertEquals;
public class SortingProgramTest {
    @Test
    public void testSortingProgram() {
                try {
                    String inputFilePath = "src/test/java/otus/homework/patterns/hw5Test/input.txt";
                    String outputFilePath = "src/test/java/otus/homework/patterns/hw5Test/output.txt";

                    BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                    String input = reader.readLine();
                    reader.close();


                    SortingProgram.main(new String[]{"selection",inputFilePath,outputFilePath});

                    // Чтение ожидаемых результатов из файла output.txt
                    reader = new BufferedReader(new FileReader(outputFilePath));
                    StringBuilder expectedOutputBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        expectedOutputBuilder.append(line);
                    }
                    reader.close();
                    String expectedOutput = expectedOutputBuilder.toString().trim();

                    // Чтение фактических результатов из файла output.txt
                    reader = new BufferedReader(new FileReader(outputFilePath));
                    StringBuilder actualOutputBuilder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        actualOutputBuilder.append(line);
                    }
                    reader.close();
                    String actualOutput = actualOutputBuilder.toString().trim();
                    assertEquals(expectedOutput, actualOutput);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
}

package otus.homework.patterns.hw5;

import lombok.Data;

import java.io.*;
@Data
public class SortingProgram {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java SortingProgram <sorting_algorithm> <input_file> <output_file>");
            return;
        }

        String sortingAlgorithmType = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        SortingFactory sortingFactory;
        if (sortingAlgorithmType.equalsIgnoreCase("selection")) {
            sortingFactory = new SelectionSortFactory();
        } else if (sortingAlgorithmType.equalsIgnoreCase("insertion")) {
            sortingFactory = new InsertionSortFactory();
        } else if (sortingAlgorithmType.equalsIgnoreCase("merge")) {
            sortingFactory = new MergeSortFactory();
        } else {
            System.out.println("Invalid sorting algorithm specified.");
            return;
        }


        int[] inputData = readInputData(inputFile);
        SortingAlgorithm sortingAlgorithm = sortingFactory.createSortingAlgorithm();
        sortingAlgorithm.sort(inputData);

        // Запись результатов в выходной файл
        writeResults(outputFile, sortingAlgorithmType, inputData);
    }

    private static int[] readInputData(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine();
            String[] numbers = line.split(",");
            int[] inputData = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                inputData[i] = Integer.parseInt(numbers[i].trim());
            }

            return inputData;
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input file.");
            return new int[0];
        }
    }

    private static void writeResults(String outputFile, String sortingAlgorithmType, int[] sortedData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Sorting Algorithm: " + sortingAlgorithmType + "\n");
            writer.write("Sorted Data: ");
            for (int sortedDatum : sortedData) {
                writer.write(sortedDatum + " ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the results to the output file.");
        }
    }
}

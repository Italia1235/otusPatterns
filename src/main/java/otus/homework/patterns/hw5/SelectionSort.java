package otus.homework.patterns.hw5;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            int minValue = array[i];
            for (int j = i + 1; j < n; j++) {
                if (array[j] < minValue) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = minValue;
            }
        }
    }
}
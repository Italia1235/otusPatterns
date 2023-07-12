package otus.homework.patterns.hw5;

public class InsertionSortFactory implements SortingFactory {
    @Override
    public SortingAlgorithm createSortingAlgorithm() {
        return new InsertionSort();
    }
}

package otus.homework.patterns.hw5;

public class SelectionSortFactory implements SortingFactory{
    @Override
    public SortingAlgorithm createSortingAlgorithm() {
        return new SelectionSort();
    }
}

package otus.homework.patterns.hw5;

public class MergeSortFactory implements SortingFactory{

    @Override
    public SortingAlgorithm createSortingAlgorithm() {
        return new MergeSort();
    }
}

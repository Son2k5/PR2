package Tut5.problem4;

class QuickSort extends IntSortingAlgorithm {
    public QuickSort(int[] array) {
        super("Quick Sort", array);
    }

    @Override
    public void sort() {
        quickSort(0, sortedArray.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = sortedArray[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (sortedArray[j] < pivot) {
                i++;
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[j];
                sortedArray[j] = temp;
            }
        }
        int temp = sortedArray[i + 1];
        sortedArray[i + 1] = sortedArray[high];
        sortedArray[high] = temp;
        return i + 1;
    }
}
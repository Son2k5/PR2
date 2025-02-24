package Tut5.problem4;

class BubbleSort extends IntSortingAlgorithm {
    public BubbleSort(int[] array) {
        super("Bubble Sort", array);
    }

    @Override
    public void sort() {
        int n = sortedArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
    }
}


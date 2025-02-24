package Tut5.problem4;

class MergeSort extends IntSortingAlgorithm {
    public MergeSort(int[] array) {
        super("Merge Sort", array);
    }

    @Override
    public void sort() {
        mergeSort(0, sortedArray.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (sortedArray[i] <= sortedArray[j]) {
                temp[k++] = sortedArray[i++];
            } else {
                temp[k++] = sortedArray[j++];
            }
        }

        while (i <= mid) temp[k++] = sortedArray[i++];
        while (j <= right) temp[k++] = sortedArray[j++];

        System.arraycopy(temp, 0, sortedArray, left, temp.length);
    }
}
package Tut5.problem4;

public class maintest {
    public static void main(String[] args) {
        int[] testArray = { 5, 2, 9, 1, 5, 6 };

// Testing Bubble Sort
        BubbleSort bubbleSort = new BubbleSort(testArray);
        System.out.println("BubbleSort Is Sorted? " + bubbleSort.isSorted());
        bubbleSort.sort();
        System.out.println(bubbleSort);
        System.out.println("BubbleSort Is Sorted? " + bubbleSort.isSorted());

// Testing Quick Sort
        QuickSort quickSort = new QuickSort(testArray);
        System.out.println("QuickSort Is Sorted? " + quickSort.isSorted());
        quickSort.sort();
        System.out.println(quickSort);
        System.out.println("QuickSort Is Sorted? " + quickSort.isSorted());

// Testing Merge Sort
        MergeSort mergeSort = new MergeSort(testArray);
        System.out.println("MergeSort Is Sorted? " + quickSort.isSorted());
        mergeSort.sort();
        System.out.println(mergeSort);
        System.out.println("MergeSort Is Sorted? " + mergeSort.isSorted());
    }
}

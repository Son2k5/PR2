package Tut5.problem4;

abstract class IntSortingAlgorithm {
    protected String name;
    protected int[] array;
    protected int[] sortedArray;

    public IntSortingAlgorithm(String name, int[] array) {
        this.name = name;
        this.array = array.clone(); // Sao chép mảng gốc để không làm thay đổi dữ liệu gốc
        this.sortedArray = array.clone();
    }

    // Phương thức trừu tượng cho các thuật toán con
    public abstract void sort();

    // Kiểm tra xem mảng đã được sắp xếp đúng hay chưa
    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " Sorted Array: [");
        for (int i = 0; i < sortedArray.length; i++) {
            sb.append(sortedArray[i]);
            if (i < sortedArray.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

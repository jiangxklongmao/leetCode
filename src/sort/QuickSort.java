package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(" i  == " + i);
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int base = array[end];
        int left = start, right = end - 1;

        while (left < right) {
            while (array[left] <= base && left < right) left++;
            while (array[left] >= base && left < right) right--;
            swap(array, left, right);
        }
        if (array[left] >= array[end]) {
            swap(array, left, end);
        } else {
            left++;
        }
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}

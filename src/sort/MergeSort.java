package sort;

public class MergeSort {
    public static void main(String[] args) {
        mergeSort(new int[]{6, 5, 3, 1, 8, 7, 2, 4});
    }

    private static void mergeSort(int[] array) {
        sortRecursive(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(" i  == " + i);
        }
    }

    private static void sortRecursive(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sortRecursive(array, start, mid);
        sortRecursive(array, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int k = 0, i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }
}

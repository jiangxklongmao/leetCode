package offer;

public class Offer_11 {
    //region 剑指 Offer 11. 旋转数组的最小数字

    /*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

    示例 1：
    输入：[3,4,5,1,2]
    输出：1

    示例 2：
    输入：[2,2,2,0,1]
    输出：0*/

    //endregion
    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 2, 0, 1};

        System.out.println("min  = " + minArray2(array));
    }

    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int min = numbers[0];
        if (min < numbers[numbers.length - 1]) {
            return min;
        }
        int index = 1;
        while (index < numbers.length) {
            if (numbers[index] < numbers[index - 1]) {
                return numbers[index];
            }
            index++;
        }
        return min;
    }

    public static int minArray2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        if (numbers[0] < numbers[numbers.length - 1]) {
            return numbers[0];
        }
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high--;
            }

        }
        return numbers[low];
    }


}

package offer;

import java.util.HashMap;

public class Offer_03 {

    //region 剑指 Offer 03. 数组中重复的数字

   /* 找出数组中重复的数字。
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    请找出数组中任意一个重复的数字。
*/
    //endregion

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 5, 6, 7, 7, 8, 8, 2};
        System.out.println(findRepeatNumber2(array));
    }

    private static int findRepeatNumber(int[] nums) {
        HashMap hashMap = new HashMap<Integer, Boolean>();
        for (int value : nums) {
            if (hashMap.containsKey(value)) {
                return value;
            } else {
                hashMap.put(value, false);
            }
        }
        return 0;
    }

    private static int findRepeatNumber2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] result = new int[nums.length];
        for (int value : nums) {
            result[value] = result[value] + 1;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 1) {
                return i;
            }
        }
        return 0;
    }


}

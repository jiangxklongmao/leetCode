package simple.string

class Simple_Number_1 {

    //region 1、两数之和
    /*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]*/
    //endregion

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(2, 7, 11, 15)
            val sum = 9
            val result = sumOfTwoNumber2(nums, sum)
            println(result.contentToString())
        }

        /**
         * 双重循环
         * @param array IntArray
         * @param sum Int
         * @return IntArray
         */
        private fun sumOfTwoNumber(array: IntArray, sum: Int): IntArray {
            if (array.isEmpty()) {
                return IntArray(0)
            }

            for ((index1, value1) in array.withIndex()) {
                for ((index2, value2) in array.withIndex()) {
                    if ((value1 + value2 == sum) && index1 != index2) {
                        return intArrayOf(index1, index2)
                    }
                }
            }
            return IntArray(0)
        }

        /**
         * 差值 存储序号
         * @param array IntArray
         * @param sum Int
         * @return IntArray
         */
        private fun sumOfTwoNumber2(array: IntArray, sum: Int): IntArray {
            if (array.isEmpty()) {
                return IntArray(0)
            }
            var map = hashMapOf<Int, Int?>()
            for ((index, value) in array.withIndex()) {
                val diff = sum - value
                map[diff]?.let {
                    return intArrayOf(it, index)
                }
                map[value] = index
            }
            return IntArray(0)
        }
    }

}
package simple.string

class Simple_Number_31 {
    //region 31. 下一个排列

    /*实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

    必须原地修改，只允许使用额外常数空间。

    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1*/

    //endregion
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1, 2, 3)
            nextPermutation(nums)
            println(nums.contentToString())
        }

        private fun nextPermutation(nums: IntArray): Unit {
            var right = nums.size - 2

            while (right >= 0 && nums[right + 1] <= nums[right]) {
                right--
            }

            if (right >= 0) {
                var bigger = nums.size - 1
                while (bigger >= 0 && nums[bigger] <= nums[right]) {
                    bigger--
                }
                swap(nums, bigger, right)
            }
            reverse(nums, right + 1)
        }


        private fun swap(nums: IntArray, i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        private fun reverse(nums: IntArray, start: Int) {
            var start = start
            var end = nums.size - 1
            while (start < end) {
                swap(nums, start++, end--)
            }
        }

    }
}
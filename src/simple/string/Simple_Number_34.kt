package simple.string

class Simple_Number_34 {
    //region 34. 在排序数组中查找元素的第一个和最后一个位置
    /*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

    你的算法时间复杂度必须是 O(log n) 级别。

    如果数组中不存在目标值，返回 [-1, -1]。

    示例 1:

    输入: nums = [5,7,7,8,8,10], target = 8
    输出: [3,4]
    示例 2:

    输入: nums = [5,7,7,8,8,10], target = 6
    输出: [-1,-1]*/
    //endregion

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var result = searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
            println("result = ${result.contentToString()}")
            result = searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6)
            println("result = ${result.contentToString()}")
        }

        private fun searchRange(nums: IntArray, target: Int): IntArray {
            val mid = binarySearch(nums, target, 0, nums.size - 1)
            if (mid == -1) {
                return intArrayOf(-1, -1)
            }
            var start = mid
            var end = mid
            while (start >= 0 && nums[start] == target) {
                start--
            }
            while (end < nums.size && nums[end] == target) {
                end++
            }

            return intArrayOf(start + 1, end - 1)
        }

        private fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
            if (nums.isEmpty()) {
                return -1
            }
            var left = left
            var right = right

            while (left <= right) {
                val mid = left + (right - left) / 2
                when {
                    nums[mid] == target -> return mid
                    nums[mid] < target -> left = mid + 1
                    nums[mid] > target -> right = mid - 1
                }
            }
            return -1
        }
    }
}
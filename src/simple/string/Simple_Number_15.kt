package simple.string

import java.util.*

class Simple_Number_15 {
    //region 15.三数之和

    /*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    示例：

    给定数组 nums = [-1, 0, 1, 2, -1, -4]，

    满足要求的三元组集合为：
    [
    [-1, 0, 1],
    [-1, -1, 2]
    ]*/

    //endregion

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(threeSum2(intArrayOf(-1, 0, 1, 2, -1, -4)))
        }

        /**
         * 暴力破解 排序之后 三重循环
         * @param nums IntArray
         * @return List<List<Int>>
         */
        fun threeSum(nums: IntArray): List<List<Int>> {
            Arrays.sort(nums)
            val threeList = mutableListOf<List<Int>>()
            for (i in nums.indices) {
                if (i == 0 || nums[i] != nums[i - 1])
                    for (j in i + 1 until nums.size) {
                        if (j == i + 1 || nums[j] != nums[j - 1]) {
                            for (k in j + 1 until nums.size) {
                                if (k == j + 1 || nums[k] != nums[k - 1]) {
                                    if (nums[i] + nums[j] + nums[k] == 0) {
                                        val list = listOf<Int>(nums[i], nums[j], nums[k])
                                        threeList.add(list)
                                    }
                                }
                            }
                        }

                    }
            }
            return threeList
        }

        /**
         * 排序 加 双指针
         * @param nums IntArray
         * @return List<List<Int>>
         */
        fun threeSum2(nums: IntArray): List<List<Int>> {
            Arrays.sort(nums)
            val threeList = mutableListOf<List<Int>>()
            val size = nums.size

            for (first in 0 until size) {
                //和前一次不等 防止重复
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue
                }

                //指向最后一个
                var third = size - 1
                var target = -nums[first]

                for (second in first + 1 until size) {
                    //和前一次不等 防止重复
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue
                    }

                    //second 指针在 third 左边  有序的情况下，和太大向左移动 third
                    while (second < third && nums[second] + nums[third] > target) {
                        third--
                    }

                    if (second == third) {
                        break
                    }

                    if (nums[second] + nums[third] == target) {
                        val list = listOf<Int>(nums[first], nums[second], nums[third])
                        threeList.add(list)
                    }

                }

            }
            return threeList
        }


        private fun print(listOfList: List<List<Int>>) {
            println("[")
            for (list in listOfList) {
                print("   [")
                for (i in list) {
                    print("$i,")
                }
                println("],")
            }
            print("]")
        }
    }
}
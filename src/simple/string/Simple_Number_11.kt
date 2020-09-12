package simple.string

import kotlin.math.max
import kotlin.math.min

class Simple_Number_11 {

    //region 11.盛最多水的容器

    /*给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器，且 n 的值至少为 2。

    图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

     
    示例：

    输入：[1,8,6,2,5,4,8,3,7]
    输出：49*/

    //endregion


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxArea2(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
        }

        /**
         * 暴力解法 双循环遍历
         * @param heights IntArray
         * @return Int
         */
        private fun maxArea(heights: IntArray): Int {
            if (heights.size < 2) {
                return 0
            }
            var maxArea = 0
            for (i in 0..heights.size) {
                for (j in i + 1 until heights.size) {
                    val long = j - i
                    val height = min(heights[i], heights[j])
                    val area = long * height
                    if (maxArea < area) maxArea = area
                }
            }

            return maxArea
        }

        /**
         * 双指针 向内扫描
         * @param heights IntArray
         * @return Int
         */
        private fun maxArea2(heights: IntArray): Int {
            if (heights.size < 2) {
                return 0
            }
            var maxArea = 0
            var left = 0
            var right = heights.size - 1

            while (left < right) {
                maxArea = max(maxArea, min(heights[left], heights[right]) * (right - left))
                if (heights[left] > heights[right]) {
                    right--
                } else {
                    left++
                }
            }
            return maxArea
        }

    }
}
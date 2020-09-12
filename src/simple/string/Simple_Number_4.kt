package simple.string

class Simple_Number_4 {

    //region 4. 寻找两个正序数组的中位数

    /*给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

    请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

    你可以假设 nums1 和 nums2 不会同时为空。

     

    示例 1:

    nums1 = [1, 3]
    nums2 = [2]

    则中位数是 2.0
    示例 2:

    nums1 = [1, 2]
    nums2 = [3, 4]

    则中位数是 (2 + 3)/2 = 2.5*/

    //endregion
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val median = findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4))
            println("median = $median")
        }

        /**
         *
         * @param nums1 IntArray
         * @param nums2 IntArray
         * @return Double
         */
        private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val intArray = merge(nums1, nums2)

            println(intArray.contentToString())

            return if (intArray.size % 2 == 0) {
                (intArray[intArray.size / 2 - 1] + intArray[intArray.size / 2]) / 2.0
            } else {
                intArray[(intArray.size - 1) / 2].toDouble()
            }
        }

        private fun merge(nums1: IntArray, nums2: IntArray): IntArray {
            var i = 0
            var j = 0
            var index = 0
            var intArray = IntArray(nums1.size + nums2.size)

            while (i < nums1.size && j < nums2.size) {
                if (nums1[i] < nums2[j]) {
                    intArray[index] = nums1[i++]
                } else {
                    intArray[index] = nums2[j++]
                }
                index++
            }

            while (i < nums1.size) {
                intArray[index] = nums1[i++]
                index++
            }

            while (j < nums2.size) {
                intArray[index] = nums2[j++]
                index++
            }

            return intArray
        }
    }
}
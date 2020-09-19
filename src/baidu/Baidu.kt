package baidu

import java.util.*

class Baidu {

    //百度面试题 查找数组中 最大的第K个数

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val array = intArrayOf(2, 4, 6, 7, 9, 10, 3)
            val result = findNumber(array, 2)
            println("result = $result")
        }

        private fun findNumber(array: IntArray, index: Int): Int {
            if (index <= 0 || index >= array.size) {
                return -1
            }
            sort(array, 0, array.size - 1)

            return array[index - 1]
        }

        private fun sort(array: IntArray, start: Int, end: Int) {
            if (start == end) {
                return
            }
            var mid = start + (end - start) / 2
            sort(array, start, mid)
            sort(array, mid + 1, end)
            val result = IntArray(end - start + 1)
            var left = start
            var right = mid + 1
            var k = 0;

            while (left <= mid && right <= end) {
                result[k++] = if (array[left] > array[right]) array[left++] else array[right++]
            }
            while (left <= mid) {
                result[k++] = array[left++]
            }
            while (right <= end) {
                result[k++] = array[right++]
            }

            for ((index, value) in result.withIndex()) {
                array[start + index] = value
            }

        }


    }
}
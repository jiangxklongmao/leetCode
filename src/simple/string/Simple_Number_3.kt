package simple.string

import kotlin.math.max

class Simple_Number_3 {

    //region 3. 无重复字符的最长子串
    /* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

     示例 1:

     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:

     输入: "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:

     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
          请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
    //endregion

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("maxLength = ${lengthOfLongestSubstring("pwwkew")}")
        }

        /**
         * 滑动窗口
         * @param string String
         */
        private fun lengthOfLongestSubstring(string: String): Int {
            if (string.isNullOrEmpty()) {
                return 0
            }
            var size = string.length
            var maxLength = 0

            var start = 0
            var end = 0
            val map = hashMapOf<Char, Int>()
            while (end < size) {
                val char = string[end]
                if (map.containsKey(char)) {
                    start = max(map[char] ?: 0, start)
                }
                maxLength = max(maxLength, end - start + 1)
                map[char] = end + 1
                end++
            }
            return maxLength
        }
    }
}
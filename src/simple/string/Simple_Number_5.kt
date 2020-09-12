package simple.string

class Simple_Number_5 {
    //region 5. 最长回文子串

    /* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

     示例 1：

     输入: "babad"
     输出: "bab"
     注意: "aba" 也是一个有效答案。
     示例 2：

     输入: "cbbd"
     输出: "bb"*/


    //endregion
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(longestPalindrome("babad"))
            println(longestPalindrome1("babad"))
        }


        /**
         * 暴力破解
         * @param s String
         * @return String
         */
        private fun longestPalindrome(s: String): String {
            val length = s.length
            if (length < 2) {
                return s
            }

            var maxLength = 0
            var start = 0
            var charArray = s.toCharArray()
            for (i in 0 until length) {
                for (j in i + 1 until length) {
                    if (j - i + 1 > maxLength && isPalindrome(charArray, i, j)) {
                        maxLength = j - i + 1
                        start = i
                    }
                }
            }

            return s.substring(start, start + maxLength)
        }

        private fun isPalindrome(charArray: CharArray, left: Int, right: Int): Boolean {
            var begin = left
            var end = right
            while (begin < end) {
                if (charArray[begin++] != charArray[end--]) {
                    return false
                }
            }
            return true
        }

        /**
         * 中心扩散 思想
         * @param s String
         */
        private fun longestPalindrome1(s: String): String {
            if (s.length < 2) {
                return s
            }
            var maxLength = 0
            var maxString = s.substring(0, 1)
            for (index in 0 until s.length - 1) {
                //奇数
                val oddStr = createSpread(s, index, index)
                //偶数
                val evenStr = createSpread(s, index, index + 1)

                val maxStr = if (oddStr.length > evenStr.length) oddStr else evenStr

                if (maxStr.length > maxLength) {
                    maxLength = maxStr.length
                    maxString = maxStr
                }
            }

            return maxString
        }

        /**
         * 中心扩展逻辑
         * @param s String
         * @param left Int
         * @param right Int
         * @return String
         */
        private fun createSpread(s: String, left: Int, right: Int): String {
            // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
            // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数

            val length = s.length
            var start = left
            var end = right

            while (start >= 0 && end < length) {
                if (s[start] == s[end]) {
                    start--
                    end++
                } else {
                    break
                }
            }

            return s.substring(start + 1, end)
        }
    }
}
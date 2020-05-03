package simple.string

/**
 * 14.最长公共前缀
 */
class Simple_Number_14 {

    //region 题目 最长公共前缀
//    编写一个函数来查找字符串数组中的最长公共前缀。
//
//    如果不存在公共前缀，返回空字符串 ""。
//
//    示例 1:
//
//    输入: ["flower","flow","flight"]
//    输出: "fl"
//    示例 2:
//
//    输入: ["dog","racecar","car"]
//    输出: ""
//    解释: 输入不存在公共前缀。
//    说明:
//
//    所有输入只包含小写字母 a-z 。
    //endregion

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            print("\"${longestCommonPrefix(arrayOf("dog", "racecar", "car"))}\"")
            print(
                "\"${longestCommonPrefix(
                    arrayOf(
                        "aa",
                        "a"
                    )
                )}\""
            )
        }

        /**
         * 最长公共前缀
         * @param stringArray Array<String>
         * @return String
         */
        private fun longestCommonPrefix(stringArray: Array<String>): String {
            if (stringArray.isNullOrEmpty()) return ""
            if (stringArray.size == 1) return stringArray[0]

            var longest = stringArray[0]
            for (i in 1 until stringArray.size) {
                val string = stringArray[i]
                if (string.isEmpty()) {
                    return ""
                }
                if (string.length < longest.length) {
                    longest = longest.substring(0, string.length)
                }
                for (index in string.indices) {
                    if (longest.length <= index) {
                        break
                    }
                    if (longest[index] != string[index]) {
                        longest = longest.substring(0, index)
                    }
                }
            }
            return longest
        }

    }

}
package simple.string

class Simple_Number_17 {
    //region 17.电话号码的字母组合

    /* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

     给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 


     示例:

     输入："23"
     输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     说明:
     尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。*/


    //endregion

    companion object {
        private val _2 = "abc"
        private val _3 = "def"
        private val _4 = "ghi"
        private val _5 = "jkl"
        private val _6 = "mno"
        private val _7 = "pqrs"
        private val _8 = "tuv"
        private val _9 = "wxyz"


        @JvmStatic
        fun main(args: Array<String>) {
            val result = letterCombinations("23")
            print(result)
        }


        private fun letterCombinations(digits: String): List<String> {
            if (digits.isNullOrEmpty()) {
                return listOf()
            }

            var resultList = mutableListOf<String>()
            for (digit in digits) {
                resultList = letterCombinations(resultList, digit)
            }
            return resultList
        }

        private fun letterCombinations(originalList: MutableList<String>, numberChar: Char): MutableList<String> {
            val list = arrayListOf<String>()
            if (originalList.isEmpty()) {
                val charArray = getCharByNumber(numberChar)
                for (c in charArray) {
                    list.add(c.toString())
                }
            } else {
                val charArray = getCharByNumber(numberChar)
                for (s in originalList) {
                    for (c in charArray) {
                        list.add(s + c)
                    }
                }
            }
            return list
        }

        private fun getCharByNumber(numberChar: Char): CharArray {
            return when (numberChar) {
                '2' -> {
                    return _2.toCharArray()
                }
                '3' -> {
                    return _3.toCharArray()
                }
                '4' -> {
                    return _4.toCharArray()
                }
                '5' -> {
                    return _5.toCharArray()
                }
                '6' -> {
                    return _6.toCharArray()
                }
                '7' -> {
                    return _7.toCharArray()
                }
                '8' -> {
                    return _8.toCharArray()
                }
                '9' -> {
                    return _9.toCharArray()
                }
                else -> charArrayOf()
            }
        }

        private fun print(list: List<String>) {
            print("[")
            for (s in list) {
                print("\"$s\",")
            }
            print("]")
        }

    }
}
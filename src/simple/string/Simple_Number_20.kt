package simple.string

import java.util.*


/**
 * 20. 有效的括号
 */
class Simple_Number_20 {

    //region 20. 有效的括号
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。
//
//    示例 1:
//
//    输入: "()"
//    输出: true
//    示例 2:
//
//    输入: "()[]{}"
//    输出: true
//    示例 3:
//
//    输入: "(]"
//    输出: false
//    示例 4:
//
//    输入: "([)]"
//    输出: false
//    示例 5:
//
//    输入: "{[]}"
//    输出: true

    //endregion

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(isValid("{[]}"))
        }

        private fun isValid(s: String): Boolean {
            if (s.isNullOrEmpty()) return true
            val stack = Stack<Char>()
            for (c in s) {
                if (isLeftBracket(c)) {
                    stack.push(c)
                } else if (isRightBracket(c)) {
                    if (stack.empty()) {
                        return false
                    }
                    val left = stack.peek()
                    if (isPairing(left, c)) {
                        stack.pop()
                    } else {
                        return false
                    }
                }
            }
            return stack.isEmpty()
        }

        /**
         * 左括号
         * @param char Char
         * @return Boolean
         */
        fun isLeftBracket(char: Char): Boolean {
            return when (char) {
                '(' -> true
                '[' -> true
                '{' -> true
                else -> false
            }
        }

        /**
         * 右括号
         * @param char Char
         * @return Boolean
         */
        private fun isRightBracket(char: Char): Boolean {
            return when (char) {
                ')' -> true
                ']' -> true
                '}' -> true
                else -> false
            }
        }

        /**
         * 左右括号是否匹配
         * @param left Char
         * @param right Char
         * @return Boolean
         */
        private fun isPairing(left: Char, right: Char): Boolean {
            return when (left) {
                '(' -> right == ')'
                '[' -> right == ']'
                '{' -> right == '}'
                else -> false
            }
        }
    }
}
package simple.string

class Simple_Number_32 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s1 = "(()"
            println(longestValidParentheses(s1))
            val s2 = ")()())"
            println(longestValidParentheses(s2))
        }

        fun longestValidParentheses(s: String): Int {
            for (index in 0..s.length) {

            }
            return 0
        }

        private fun createSpread(s: String, i: Int, j: Int): String {
            var start = i
            var end = j




            return s.substring(start, end)
        }

        private fun isValidParentheses(){

        }

    }
}
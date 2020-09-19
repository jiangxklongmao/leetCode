package offer

import kotlin.math.max

class Offer_63 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
            println(maxProfit(intArrayOf(7, 6, 5, 4, 3, 2, 1)))
        }

        fun maxProfit(prices: IntArray): Int {
            if (prices.isEmpty()) {
                return 0
            }
            var result = 0
            var min = prices[0]
            for (price in prices) {
                if (price <= min) {
                    min = price
                } else {
                    result = max(result, price - min)
                }
            }
            return result
        }
    }
}
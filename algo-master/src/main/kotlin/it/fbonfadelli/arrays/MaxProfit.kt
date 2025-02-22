package it.fbonfadelli.arrays

class MaxProfit {

    companion object {
        fun main() {
            val maxProfit = MaxProfit()
            val input1 = intArrayOf(7,1,5,3,6,4)
            val input2 = intArrayOf(7,6,4,3,1)

            println("MOVE ZEROES")

            println("CASE 1:")
            println("Input: [" + input1.joinToString((",")) + "]")
            val output1 = maxProfit.maxProfit(input1)
            println("Output: [" + output1 + "]")

            println()

            println("CASE 2:")
            println("Input: [" + input2.joinToString((",")) + "]")
            val output2 = maxProfit.maxProfit(input2)
            println("Output: [" + output2 + "]")
        }
    }

    fun maxProfit(prices: IntArray): Int {
        var minPrice = Integer.MAX_VALUE
        var maxProfit = 0

        for (i in 0..(prices.size-1)) {
            if (prices[i] < minPrice)
                minPrice = prices[i]

            if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice
        }

        return maxProfit
    }
}
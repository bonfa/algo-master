package it.fbonfadelli.arrays

import it.fbonfadelli.print

class MaxProfit {

    companion object {
        private val maxProfit = MaxProfit()

        fun main() {
            println("MOVE ZEROES")

            val inputs = listOf(
                intArrayOf(7,1,5,3,6,4),
                intArrayOf(7,6,4,3,1),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.print())
            val output = maxProfit.maxProfit(input)
            println("Output: $output")
            println()
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
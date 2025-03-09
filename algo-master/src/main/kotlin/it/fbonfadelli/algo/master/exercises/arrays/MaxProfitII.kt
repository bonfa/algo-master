package it.fbonfadelli.algo.master.exercises.arrays

import it.fbonfadelli.algo.master.utils.printable

class MaxProfitII {

    companion object {
        private val maxProfitII = MaxProfitII()

        fun main() {
            println("MAX PROFIT II")

            val inputs = listOf(
                intArrayOf(7,1,5,3,6,4),
                intArrayOf(1,2,3,4,5),
                intArrayOf(7,6,4,3,1),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.printable())
            val output = maxProfitII.version2(input)
            println("Output: $output")
            println()
        }
    }

    fun version2(prices: IntArray): Int {
        var profit = 0
        var prevPrice = prices[0]
        for(i in 1..prices.size-1) {
            if (prices[i] > prevPrice) {
                val gain = prices[i] - prevPrice
                profit = profit + gain
            }

            prevPrice = prices[i]
        }

        return profit
    }

    fun version1(prices: IntArray): Int {
        if (prices.size < 2)
            return 0

        var previousPrice = prices[0]
        var profit = 0

        for (i in 1..prices.size-1) {
            val currentPrice = prices[i]
            if (currentPrice > previousPrice) {
                profit = profit + currentPrice - previousPrice
            }
            previousPrice = currentPrice
        }

        return profit
    }
}
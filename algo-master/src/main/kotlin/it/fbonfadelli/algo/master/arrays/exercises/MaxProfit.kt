package it.fbonfadelli.algo.master.arrays.exercises

import it.fbonfadelli.algo.master.utils.printable

class MaxProfit {

    companion object {
        private val maxProfit = MaxProfit()

        fun main() {
            println("MAX PROFIT")

            val inputs = listOf(
                intArrayOf(7,1,5,3,6,4),
                intArrayOf(7,6,4,3,1),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.printable())
            val output = maxProfit.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(prices: IntArray): Int {
        var maxProfit = 0
        var minPrice = prices[0]
        for (i in 1..prices.size - 1) {
            val currentPrice = prices[i]
            if (currentPrice <= minPrice) {
                minPrice = currentPrice
            }

            if (currentPrice > minPrice) {
                val profit = currentPrice - minPrice
                if (profit > maxProfit)
                    maxProfit = profit
            }
        }

        return maxProfit
    }
}
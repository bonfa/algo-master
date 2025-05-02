package it.fbonfadelli.algo.master.arrays.exercises

import it.fbonfadelli.algo.master.utils.printable

class NumberOfZeroFilledSubArrays {

    companion object {
        private val numberOfZeroFilledSubArrays = NumberOfZeroFilledSubArrays()

        fun main() {
            println("NUMBER OF ZERO FILLED SUB ARRAYS")

            val inputs = listOf(
                intArrayOf(1,3,0,0,2,0,0,4),
                intArrayOf(0,0,0,2,0,0),
                intArrayOf(2,10,2019),
                intArrayOf(0,0,0,0),
                intArrayOf(0,0,0,0,0,0,0,0,0,0),
                IntArray(100_000),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.printable())
            val me = numberOfZeroFilledSubArrays.execute(input)
            println("Output: $me")
            println()
        }
    }

    fun execute(nums: IntArray): Long {
        var count = 0L
        var numOfPreviousZeros = 0L
        for (num in nums) {
            if (num != 0) {
                count += (numOfPreviousZeros * (numOfPreviousZeros+1) / 2)
                numOfPreviousZeros = 0
            } else {
                numOfPreviousZeros++
            }
        }

        count += (numOfPreviousZeros * (numOfPreviousZeros+1) / 2)

        return count
    }
}
package it.fbonfadelli.algo.master.exercises.arrays

import it.fbonfadelli.algo.master.utils.print

class NumberOfZeroFilledSubArrays {

    companion object {
        private val numberOfZeroFilledSubArrays = NumberOfZeroFilledSubArrays()

        fun main() {
            println("NUMBER_OF_ZERO_FILLED_SUBARRAYS")

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
            println("Input: " + input.print())
            val me = numberOfZeroFilledSubArrays.numberOfZeroFilledSubArrays(input)
            println("Output: $me")
            println()
        }
    }

    fun numberOfZeroFilledSubArrays(nums: IntArray): Long {
        var occurrences = 0L
        var lengthOfZeroSequence = 0L

        for (i in 0..nums.size - 1) {
            val num = nums[i]
            if (num == 0) {
                lengthOfZeroSequence++
            }

            if (num != 0 || i == nums.size - 1) {
                val occurrensesForCurrentSequence: Long = lengthOfZeroSequence * (lengthOfZeroSequence + 1) / 2
                occurrences = occurrences + occurrensesForCurrentSequence
                lengthOfZeroSequence = 0
            }
        }
        return occurrences
    }

    // [0,0,0] --> 3 * [0] + 2 * [0,0] + 1 * [0,0,0] --> 3 * (3+1) / 2 = 6
    // for each sequence of 0s,
    //   - I calculate the length
    //   - apply the formula
    // checking the edge cases
    // - [0] --> 1 --> 1*2 / 2 = 1
    // - [] --> 0

    // checking edge cases (100_000 items)
    //   705_082_704
    // 5_000_050_000
    // Integer.MAX_VALUE 2_147_483_647
}
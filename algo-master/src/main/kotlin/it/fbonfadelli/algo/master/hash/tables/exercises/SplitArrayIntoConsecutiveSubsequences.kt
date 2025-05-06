package it.fbonfadelli.algo.master.hash.tables.exercises

import it.fbonfadelli.algo.master.utils.printable

class SplitArrayIntoConsecutiveSubsequences {
    companion object {
        private val splitArrayIntoConsecutiveSubsequences = SplitArrayIntoConsecutiveSubsequences()

        fun main() {
            println("SPLIT ARRAY INTO CONSECUTIVE SUBSEQUENCES")

            val inputs = listOf(
                intArrayOf(1,2,3,3,4,5),
                intArrayOf(1,2,3,3,4,4,5,5),
                intArrayOf(1,2,3,4,4,5),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: '${input.printable()}'")
            val output = splitArrayIntoConsecutiveSubsequences.isPossible(input)
            println("Output: $output")
            println()
        }
    }

    fun isPossible(nums: IntArray): Boolean {
        val ranges: MutableList<IntArray> = mutableListOf()

        for (num in nums) {
            var candidate: IntArray? = null
            for (range in ranges) {
                if (range[1] == num - 1 && (candidate == null || (range[1] - range[0]) < (candidate[1] - candidate[0]))) {
                    candidate = range
                }
            }
            if (candidate == null)
                ranges.add(intArrayOf(num, num))
            else {
                candidate[1] = num
            }
        }

        return ranges.all { it[1] - it[0] + 1 >= 3 }
    }
}

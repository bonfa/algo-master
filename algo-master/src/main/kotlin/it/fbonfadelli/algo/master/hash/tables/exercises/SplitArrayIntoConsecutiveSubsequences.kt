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
            val output = splitArrayIntoConsecutiveSubsequences.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray): Boolean {
        val subsequences = mutableListOf<MutableList<Int>>()

        var i = nums.size - 1
        while (i >= 0) {
            val num = nums[i]

            var added = false
            val validSubsequences = mutableListOf<MutableList<Int>>()
            for (subsequence in subsequences) {
                if (subsequence.last() > num + 1 && subsequence.first() - subsequence.last() < 2)
                    return false

                if (subsequence.last() == num + 1) {
                    validSubsequences.add(subsequence)
                }
            }

            if (validSubsequences.isNotEmpty()) {
                validSubsequences.sortBy{ it.size }
                validSubsequences.first().add(num)
                added = true
            }

            if (!added) {
                subsequences.add(mutableListOf(num))
            }

            i--
        }

        return subsequences.all { subsequence -> subsequence.first() - subsequence.last() >= 2 }
    }
}

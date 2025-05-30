package it.fbonfadelli.algo.master.arrays.exercises

import it.fbonfadelli.algo.master.utils.printable

class RemoveDuplicates {

    companion object {
        private val removeDuplicates = RemoveDuplicates()

        fun main() {
            println("REMOVE DUPLICATES")

            val inputs = listOf(
                intArrayOf(1, 1, 2),
                intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.printable())
            val length = removeDuplicates.removeDuplicates(input)
            println("Output: " + input.take(length).printable())
            println()
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        var lastChangedIndex = 0
        for (i in 1..nums.size-1) {
            if (nums[i] > nums[lastChangedIndex]) {
                lastChangedIndex++
                nums[lastChangedIndex] = nums[i]
            }
        }

        return lastChangedIndex + 1
    }
}
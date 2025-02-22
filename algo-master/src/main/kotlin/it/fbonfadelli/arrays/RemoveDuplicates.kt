package it.fbonfadelli.arrays

import it.fbonfadelli.print

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
            println("Input: " + input.print())
            val length = removeDuplicates.removeDuplicates(input)
            println("Output: " + input.take(length).print())
            println()
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        var positionToOverride = 0
        var currentPosition = 1
        while (true) {
            if (currentPosition >= nums.size)
                break

            if (nums[positionToOverride] == nums[currentPosition]) {
                currentPosition++
            } else {
                positionToOverride++
                nums[positionToOverride] = nums[currentPosition]
                currentPosition++
            }
        }

        return positionToOverride+1
    }
}
package it.fbonfadelli.algo.master.exercises.arrays

import it.fbonfadelli.algo.master.utils.printable

class IncreasingTriplet {

    companion object {
        private val increasingTriplet = IncreasingTriplet()

        fun main() {
            println("INCREASING TRIPLET")

            val inputs = listOf(
                intArrayOf(1,2,3,4,5),
                intArrayOf(5,4,3,2,1),
                intArrayOf(2,1,5,0,4,6),
                intArrayOf(2,1,5,7),
                intArrayOf(1,2,6,9),
                intArrayOf(1,1,1,1,1),
                intArrayOf(1,2,1,2,1,2,1,2,1,2),
                intArrayOf(1,10,2,4),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.printable())
            val output = increasingTriplet.increasingTriplet(input)
            println("Output: $output")
            println()
        }
    }

    fun increasingTriplet(nums: IntArray): Boolean {
        var firstItem: Int? = null
        var secondItem: Int? = null

        for (i in 0..nums.size - 1) {
            val num = nums[i]

            if (firstItem == null || nums[i] < firstItem) {
                firstItem = nums[i]
                continue
            }

            if (firstItem != null && nums[i] > firstItem && (secondItem == null || nums[i] < secondItem!!)) {
                secondItem = nums[i]
                continue
            }

            if (firstItem != null && secondItem != null && nums[i] > secondItem!!)
                return true
        }

        return false
    }
}
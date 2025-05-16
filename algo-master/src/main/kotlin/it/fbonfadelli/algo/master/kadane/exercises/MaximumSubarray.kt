package it.fbonfadelli.algo.master.kadane.exercises

import it.fbonfadelli.algo.master.utils.printable
import kotlin.math.max

class MaximumSubarray {

    companion object {
        private val maximumSubArray = MaximumSubarray()

        fun main() {
            println("MAXIMUM SUB ARRAY")

            val inputs = listOf(
                intArrayOf(-2,1,-3,4,-1,2,1,-5,4),
                intArrayOf(1),
                intArrayOf(5,4,-1,7,8),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = maximumSubArray.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray): Int {
        var currentSum = nums[0]
        var maxSum = nums[0]

        var r = 1
        while(r < nums.size) {
            currentSum = max(currentSum + nums[r],nums[r])
            maxSum = max(currentSum, maxSum)
            r++
        }

        return maxSum
    }
}
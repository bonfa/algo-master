package it.fbonfadelli.algo.master.kadane.exercises

import it.fbonfadelli.algo.master.utils.printable

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
            val output = maximumSubArray.maxSubArray(input)
            println("Output: $output")
            println()
        }
    }

    fun maxSubArray(nums: IntArray): Int {
        var currentSum = nums[0]
        var maxSum = nums[0]

        var r = 1
        while(r < nums.size) {
            currentSum = (currentSum + nums[r]).coerceAtLeast(nums[r])
            maxSum = Math.max(currentSum, maxSum)
            r++
        }

        return maxSum
    }
}
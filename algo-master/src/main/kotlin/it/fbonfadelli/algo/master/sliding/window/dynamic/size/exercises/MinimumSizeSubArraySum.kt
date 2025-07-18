package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

import kotlin.math.min

class MinimumSizeSubArraySum {

    companion object {
        private val minimumSizeSubArraySum = MinimumSizeSubArraySum()

        fun main() {
            println("MINIMUM SIZE SUB ARRAY SUM")

            val inputs = listOf(
                Input(7, intArrayOf(2,3,1,2,4,3)),
                Input(4, intArrayOf(1,4,4)),
                Input(11, intArrayOf(1,1,1,1,1,1,1,1)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = minimumSizeSubArraySum.execute(input.target, input.nums)
            println("Output: $output")
            println()
        }
    }

    fun execute(target: Int, nums: IntArray): Int {
        var l = 0
        var r = 0
        var minLength = Integer.MAX_VALUE
        var currentSum = 0

        while(r < nums.size) {
            val num = nums[r]

            currentSum += num
            while (currentSum >= target) {
                minLength = min(minLength, r + 1 - l)
                val toRemove = nums[l]
                currentSum -= toRemove
                l++
            }

            r++
        }

        return if (minLength == Integer.MAX_VALUE) 0 else minLength
    }


    private data class Input(val target: Int, val nums: IntArray)
}
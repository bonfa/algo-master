package it.fbonfadelli.algo.master.sliding.window.exercises

class MaximumAverageSubArrayI {

    companion object {
        private val maximumAverageSubArrayI = MaximumAverageSubArrayI()

        fun main() {
            println("MAXIMUM AVERAGE SUB ARRAY I")

            val inputs = listOf(
                Input(intArrayOf(1,12,-5,-6,50,3), 4),
                Input(intArrayOf(5), 1),
                Input(intArrayOf(0,1,1,3,3), 4),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = maximumAverageSubArrayI.findMaxAverage(input.array, input.k)
            println("Output: $output")
            println()
        }
    }

    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var left = 0
        var right = left + k

        var sum = 0
        for (i in left until right) {
            sum += nums[i]
        }

        var maxAvg = sum.toDouble() / k.toDouble()

        while(right < nums.size) {
            sum = sum - nums[left] + nums[right]
            maxAvg = Math.max(maxAvg, sum.toDouble() / k.toDouble())
            left++
            right++
        }

        return maxAvg
    }

    private data class Input(val array: IntArray, val k: Int)
}
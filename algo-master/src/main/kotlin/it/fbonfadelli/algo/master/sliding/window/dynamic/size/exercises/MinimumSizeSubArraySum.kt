package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

class MinimumSizeSubArraySum {

    companion object {
        private val minimumSizeSubArraySum = MinimumSizeSubArraySum()

        fun main() {
            println("MINIMUM SIZE SUB ARRAY SUM")

            val inputs = listOf(
                Input(7, intArrayOf(2,3,1,2,4,3)),
                Input(4, intArrayOf(1,4,4)),
                Input(1, intArrayOf(1,1,1,1,1,1,1,1)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = minimumSizeSubArraySum.minSubArrayLen(input.target, input.nums)
            println("Output: $output")
            println()
        }
    }

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        TODO()
    }

    private data class Input(val target: Int, val nums: IntArray)
}
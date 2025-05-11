package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

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
        var minLength = Integer.MAX_VALUE
        var sum = 0
        var l = 0
        var r = 0

        while(r < nums.size) {
            val toAdd = nums[r]
            sum += toAdd
            if (sum >= target) {
                minLength = Math.min(minLength, r - l + 1)
            }

            //compression
            while(sum >= target) {
                val toRemove = nums[l]
                sum -= toRemove
                l++
                if (sum >= target) {
                    minLength = Math.min(minLength, r - l + 1)
                }
            }

            r++
        }



        return if (minLength == Integer.MAX_VALUE) 0 else minLength
    }


    private data class Input(val target: Int, val nums: IntArray)
}
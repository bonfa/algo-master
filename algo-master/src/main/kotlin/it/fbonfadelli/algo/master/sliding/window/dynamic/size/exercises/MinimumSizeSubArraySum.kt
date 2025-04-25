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
            val output = minimumSizeSubArraySum.minSubArrayLen(input.target, input.nums)
            println("Output: $output")
            println()
        }
    }

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.size == 1 && nums[0] >= target) {
            return 1
        } else if (nums.size == 1 && nums[0] < target) {
            return 0
        } else {
            var minLength = Int.MAX_VALUE
            var l = 0
            var r = l+1
            var currentSum = nums[l]

            if (currentSum >= target)
                return 1

            while(r < nums.size) {
                currentSum += nums[r]
                if (currentSum >= target) {
                    minLength = Math.min(minLength, r - l + 1)
                }

                while ((currentSum - nums[l]) >= target && l <= r) {
                    currentSum -= nums[l]
                    l++
                    minLength = Math.min(minLength, r - l + 1)
                }

                if (minLength == 1) {
                    break
                }

                r++
            }

            return if (minLength == Int.MAX_VALUE) 0 else minLength
        }
    }

    private data class Input(val target: Int, val nums: IntArray)
}
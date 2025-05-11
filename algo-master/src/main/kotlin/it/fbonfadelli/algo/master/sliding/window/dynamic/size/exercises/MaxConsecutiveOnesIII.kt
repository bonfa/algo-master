package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

class MaxConsecutiveOnesIII {

    companion object {
        private val maxConsecutiveOnesIII = MaxConsecutiveOnesIII()

        fun main() {
            println("MAX CONSECUTIVE ONES III")

            val inputs = listOf(
                Input(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), 2),
                Input(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1), 3),
                Input(intArrayOf(0,0), 2),
                Input(intArrayOf(0,0,0), 2),
                Input(intArrayOf(1,1), 2),
                Input(intArrayOf(0,0,1,1,1,0,0), 0),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = maxConsecutiveOnesIII.execute(input.nums, input.k)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray, k: Int): Int {
        var maxLength = 0
        var countOfZeroes = 0
        var l = 0
        var r = 0

        while(r < nums.size) {
            val toAdd = nums[r]
            if (toAdd == 0) {
                countOfZeroes++
            }

            while(countOfZeroes > k) {
                val toRemove = nums[l]
                if (toRemove == 0) {
                    countOfZeroes--
                }
                l++
            }

            maxLength = Math.max(maxLength, r - l + 1)

            r++
        }

        return maxLength
    }

    private data class Input(val nums: IntArray, val k: Int)
}
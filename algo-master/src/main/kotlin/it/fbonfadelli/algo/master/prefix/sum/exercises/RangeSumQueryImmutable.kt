package it.fbonfadelli.algo.master.prefix.sum.exercises

class RangeSumQueryImmutable {

    companion object {
        fun main() {
            println("RANGE SUM QUERY IMMUTABLE")

            val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))

            val inputs = listOf(
                Input(0,2),
                Input(2,5),
                Input(0,5),
            )

            inputs.forEachIndexed { index, input -> execute(index, numArray, input) }
        }

        private fun execute(index: Int, numArray: NumArray, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = numArray.sumRange(input.left, input.right)
            println("Output: $output")
            println()
        }
    }

    class NumArray(nums: IntArray) {
        private val prefixSum: IntArray = IntArray(nums.size)

        init {
            prefixSum[0] = nums[0]
            var i = 1
            while (i < prefixSum.size) {
                prefixSum[i] = prefixSum[i - 1] + nums[i]
                i++
            }
        }

        fun sumRange(left: Int, right: Int): Int {
            return if (left == 0)
                prefixSum[right]
            else
                prefixSum[right] - prefixSum[left - 1]
        }
    }

    private data class Input(val left: Int, val right:Int)
}
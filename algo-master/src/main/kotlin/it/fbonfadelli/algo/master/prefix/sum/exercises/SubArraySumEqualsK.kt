package it.fbonfadelli.algo.master.prefix.sum.exercises

class SubArraySumEqualsK {

    companion object {
        private val subArraySumEqualsK = SubArraySumEqualsK()

        fun main() {
            println("SUB ARRAY SUM EQUALS K")

            val inputs = listOf(
                Input(intArrayOf(1,1,1), 2),
                Input(intArrayOf(1,2,3), 3),
                Input(intArrayOf(1,1,1,1), 2),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = subArraySumEqualsK.subArraySum(input.array, input.k)
            println("Output: ${output}")
            println()
        }
    }

    fun subArraySum(nums: IntArray, k: Int): Int {
        var result = 0

        for (i in 1..nums.size-1) {
            nums[i] = nums[i] + nums[i-1]
        }

        for (i in 0..nums.size-1) {
            if (nums[i] == k)
                result++
            for (j in i+1..nums.size-1) {
                if (nums[j]-nums[i] == k)
                    result++
            }
        }

        return result
    }

    private data class Input(val array: IntArray, val k: Int)
}
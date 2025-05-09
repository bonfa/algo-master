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
            println("Input: $input")
            val output = subArraySumEqualsK.execute(input.array, input.k)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray, k: Int): Int {
        var currentSum = 0
        var count = 0

        val sums = mutableMapOf<Int, Int>()
        sums[0] = 1

        for (num in nums) {
            currentSum += num

            if (sums.containsKey(currentSum - k)) {
                count += sums[currentSum - k]!!
            }

            sums[currentSum] = sums.getOrDefault(currentSum, 0) + 1
        }

        return count
    }

    private data class Input(val array: IntArray, val k: Int)
}
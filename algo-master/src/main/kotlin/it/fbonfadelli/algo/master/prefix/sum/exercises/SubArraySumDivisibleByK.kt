package it.fbonfadelli.algo.master.prefix.sum.exercises

class SubArraySumDivisibleByK {

    companion object {
        private val subArraySumDivisibleByK = SubArraySumDivisibleByK()

        fun main() {
            println("SUB ARRAY SUM DIVISIBLE BY K")

            val inputs = listOf(
                Input(intArrayOf(4,5,0,-2,-3,1), 5),
                Input(intArrayOf(5), 9),
                Input(intArrayOf(-1,2,9), 2),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = subArraySumDivisibleByK.execute(input.array, input.k)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray, k: Int): Int {
        var sum = 0
        var count = 0

        val reminderCounts = mutableMapOf<Int, Int>()
        reminderCounts[0] = 1

        nums.forEach { num ->
            sum = sum + num
            var remainder = sum % k
            if (remainder < 0)
                remainder += k;

            if (reminderCounts.containsKey(remainder)) {
                count += reminderCounts[remainder]!!
            }

            reminderCounts[remainder] = (reminderCounts[remainder] ?: 0) + 1
        }

        return count
    }

    private data class Input(val array: IntArray, val k: Int)
}
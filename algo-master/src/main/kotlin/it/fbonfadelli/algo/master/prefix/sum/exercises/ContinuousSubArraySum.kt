package it.fbonfadelli.algo.master.prefix.sum.exercises

class ContinuousSubArraySum {

    companion object {
        private val continuousSubArraySum = ContinuousSubArraySum()

        fun main() {
            println("CONTINUOUS SUB ARRAY SUM")

            val inputs = listOf(
                Input(intArrayOf(23,2,4,6,7), 6),
                Input(intArrayOf(23,2,6,4,7), 6),
                Input(intArrayOf(23,2,6,4,7), 13),
                Input(intArrayOf(0,6), 6),
                Input(intArrayOf(1,6), 6),
                Input(intArrayOf(0), 6),
                Input(intArrayOf(5,0,0,0), 3),
                Input(intArrayOf(1,0), 2),
                Input(intArrayOf(1,0,1,0,1), 4),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = continuousSubArraySum.checkSubArraySum(input.array, input.k)
            println("Output: ${output}")
            println()
        }
    }

    fun checkSubArraySum(nums: IntArray, k: Int): Boolean {

        var sum = 0
        val reminderFirstIndex = mutableMapOf<Int, Int>()
        reminderFirstIndex[0] = -1

        nums.forEachIndexed { i, num ->
            sum += num

            var remainder = sum % k

            if (reminderFirstIndex.containsKey(remainder)) {
                if (i - reminderFirstIndex[remainder]!! > 1)
                    return true
            } else {
                reminderFirstIndex[remainder] = i
            }
        }

        return false
    }

    private data class Input(val array: IntArray, val k: Int)
}
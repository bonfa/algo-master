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
        var sum = 0
        var count = 0

        val counts = mutableMapOf<Int, Int>()
        counts[0] = 1

        nums.forEach { num ->
            sum = sum + num

            if (counts.containsKey(sum - k)) {
                count += counts[sum - k]!!
            }

            counts[sum] = (counts[sum] ?: 0) + 1
        }

        return count
    }

    private fun bruteForce(nums: IntArray, k: Int): Int {
        for (i in 1 until nums.size) {
            nums[i] = nums[i-1] + nums[i]
        }
        //nums now contains the cumulative sum

        var count = 0
        for (i in 0 until nums.size) {
            if (nums[i] == k)
                count++

            for (j in i+1 until nums.size) {
                if (nums[j]-nums[i] == k)
                    count++
            }
        }

        return count
    }

    private data class Input(val array: IntArray, val k: Int)
}
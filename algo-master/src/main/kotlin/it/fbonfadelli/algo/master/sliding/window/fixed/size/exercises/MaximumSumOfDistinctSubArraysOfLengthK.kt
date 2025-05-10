package it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises

class MaximumSumOfDistinctSubArraysOfLengthK {

    companion object {
        private val maximumSumOfDistinctSubArraysOfLengthK = MaximumSumOfDistinctSubArraysOfLengthK()

        fun main() {
            println("MAXIMUM SUM OF DISTINCT SUB ARRAYS OF LENGTH K")

            val inputs = listOf(
                Input(intArrayOf(1,5,4,2,9,9,9), 3),
                Input(intArrayOf(4,4,4), 3),
                Input(intArrayOf(1,2,2), 2),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = maximumSumOfDistinctSubArraysOfLengthK.execute(input.array, input.k)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray, k: Int): Long {
        var currentSum = 0L
        val numMap = mutableMapOf<Int, Int>()

        var i = 0
        while (i < k) {
            val num = nums[i]

            currentSum += num
            numMap[num] = numMap.getOrDefault(num, 0) + 1

            i++
        }

        var maxSum = 0L
        if (numMap.keys.size == k) {
            maxSum = currentSum
        }

        i = k
        while(i < nums.size) {
            val toRemove = nums[i - k]
            val toAdd = nums[i]

            currentSum = currentSum + toAdd - toRemove

            if (numMap[toRemove] == 1) {
                numMap.remove(toRemove)
            } else {
                numMap[toRemove] = numMap[toRemove]!! - 1
            }

            numMap[toAdd] = numMap.getOrDefault(toAdd, 0) + 1

            if (numMap.keys.size == k) {
                maxSum = Math.max(maxSum, currentSum)
            }

            i++
        }


        return maxSum
    }

    private data class Input(val array: IntArray, val k: Int)
}
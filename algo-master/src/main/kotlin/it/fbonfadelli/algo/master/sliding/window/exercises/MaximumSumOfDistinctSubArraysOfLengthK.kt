package it.fbonfadelli.algo.master.sliding.window.exercises

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
            val output = maximumSumOfDistinctSubArraysOfLengthK.maximumSubArraySum(input.array, input.k)
            println("Output: $output")
            println()
        }
    }

    fun maximumSubArraySum(nums: IntArray, k: Int): Long {
        return version2(k, nums)
    }

    private fun version2(k: Int, nums: IntArray): Long {
        var i = 0
        val freq = mutableMapOf<Int, Int>()
        var sum: Long = 0L
        while(i < k) {
            val num = nums[i]
            freq[num] = freq.getOrDefault(num, 0) + 1
            sum += num.toLong()
            i++
        }

        var maxSum: Long = if (freq.keys.size == k) sum else 0L

        i = 0
        while (i + k < nums.size) {
            val toRemove = nums[i]
            sum -= toRemove.toLong()
            if (freq[toRemove]!! == 1)
                freq.remove(toRemove)
            else {
                freq[toRemove] = freq[toRemove]!! - 1
            }

            val toAdd = nums[i + k]
            sum += toAdd.toLong()
            freq[toAdd] = freq.getOrDefault(toAdd, 0) + 1

            if (freq.keys.size == k) {
                maxSum = Math.max(maxSum, sum)
            }

            i++
        }

        return maxSum
    }

    private fun version1(k: Int, nums: IntArray): Long {
        val numFrequency = IntArray(100_001)
        var sum = 0L
        var validSum = 0L
        for (i in 0 until k) {
            val num = nums[i]
            numFrequency[num]++
            sum += num
        }

        if (hasOneItemWithValueHigherThanOne(numFrequency)) {
            validSum = 0L
        } else {
            validSum = sum
        }


        for (i in 0 until nums.size - k) {
            val numToRemove = nums[i]
            val numToAdd = nums[i + k]
            var needToRecomputeValidity = true

            numFrequency[numToRemove]--
            numFrequency[numToAdd]++
            if (numFrequency[numToAdd] > 1) {
                needToRecomputeValidity = false
            }

            sum = sum + numToAdd - numToRemove
            if (needToRecomputeValidity && hasOneItemWithValueHigherThanOne(numFrequency).not()) {
                validSum = Math.max(validSum, sum)
            }
        }

        return validSum
    }

    private fun hasOneItemWithValueHigherThanOne(nums: IntArray): Boolean {
        for (i in 0 until nums.size) {
            if (nums[i] > 1)
                return true
        }

        return false
    }

    private data class Input(val array: IntArray, val k: Int)
}
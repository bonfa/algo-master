package it.fbonfadelli.arrays

import it.fbonfadelli.print

class MajorityElement {

    companion object {
        private val majorityElement = MajorityElement()

        fun main() {
            println("MAJORITY ELEMENT")

            val inputs = listOf(
                intArrayOf(3,2,3),
                intArrayOf(2,2,1,1,1,2,2),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.print())
            val me = majorityElement.majorityElement(input)
            println("Output: $me")
            println()
        }
    }

    fun majorityElement(nums: IntArray): Int {
        return boyerMooreVotingAlgorithm(nums)
    }

    private fun boyerMooreVotingAlgorithm(nums: IntArray): Int {
        var candidate = nums[0]
        var count = 1
        for (i in 1..nums.size-1) {
            if (count == 0)
                candidate = nums[i]

            if (nums[i] == candidate)
                count++
            else
                count--
        }

        return candidate
    }

    private fun mapBased(nums: IntArray): Int {
        val counts = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            if (counts[num] == null)
                counts[num] = 1
            else
                counts[num] = counts[num]!! + 1
        }

        val key = counts.entries.maxBy { (k, v) -> v }.key

        return key
    }
}
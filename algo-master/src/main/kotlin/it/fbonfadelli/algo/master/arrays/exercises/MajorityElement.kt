package it.fbonfadelli.algo.master.arrays.exercises

import it.fbonfadelli.algo.master.utils.printable

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
            println("Input: " + input.printable())
            val me = majorityElement.majorityElement(input)
            println("Output: $me")
            println()
        }
    }

    fun majorityElement(nums: IntArray): Int {
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
}
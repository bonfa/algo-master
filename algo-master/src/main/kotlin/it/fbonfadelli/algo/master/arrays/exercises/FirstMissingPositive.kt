package it.fbonfadelli.algo.master.arrays.exercises

import it.fbonfadelli.algo.master.utils.printable

class FirstMissingPositive {

    companion object {
        private val firstMissingPositive = FirstMissingPositive()

        fun main() {
            println("FIRST MISSING POSITIVE")

            val inputs = listOf(
                intArrayOf(1,2,0),
                intArrayOf(3,4,-1,1),
                intArrayOf(7,8,9,11,12),
                intArrayOf(1),
                intArrayOf(0),
                intArrayOf(1,2,3,4,6),
                intArrayOf(2,3,4,6),
                intArrayOf(2,1),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.printable())
            val output = firstMissingPositive.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray): Int {
        if (nums.size == 1) {
            if (nums[0] == 1)
                return 2
            else
                return 1
        }


        var containsSize = false
        for (i in 0..nums.size - 1) {
            if (nums[i] == nums.size) {
                containsSize = true
                nums[i] = 0
                continue
            }
            if (nums[i] < 0 || nums[i] > nums.size) {
                nums[i] = 0
            }
        }

        for (i in 0..nums.size - 1) {
            var num = nums[i]
            nums[i] = 0
            while (num != nums[num]) {
                val temp = nums[num]
                nums[num] = num
                num = temp
            }
        }

        for (i in 1..nums.size - 1) {
            if (nums[i] == 0)
                return i
        }

        if (containsSize)
            return nums.size + 1
        else
            return nums.size
    }
}
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
                intArrayOf(2),
                intArrayOf(1,2,3,4,6),
                intArrayOf(2,3,4,6),
                intArrayOf(2,1),
                intArrayOf(1,2),
                intArrayOf(0,-1,3,1),
                intArrayOf(1,1),
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
        var containsZero = false
        var containsSize = false

        for (i in 0 until nums.size) {
            var toMove = nums[i]
            if (toMove == 0) {
                containsZero = true
            }
            if (toMove == nums.size) {
                containsSize = true
            }
            while (toMove > 0 && toMove < nums.size && nums[toMove] != toMove) {
                val temp = nums[toMove]

                if (temp == 0) {
                    containsZero = true
                }
                if (temp == nums.size) {
                    containsSize = true
                }

                nums[toMove] = toMove
                toMove = temp
            }
        }

        //now I have all the elements with the value which is same as the index
        for (i in 1 until nums.size) {
            if (nums[i] != i)
                return i
        }

        return if (containsSize && !containsZero)
            nums.size + 1
        else
            nums.size
    }
}
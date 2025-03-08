package it.fbonfadelli.algo.master.exercises.arrays

import it.fbonfadelli.algo.master.utils.printable

class MoveZeroes {

    companion object {
        private val moveZeroes = MoveZeroes()

        fun main() {
            println("MOVE ZEROES")

            val inputs = listOf(
                intArrayOf(0, 1, 0, 3, 12),
                intArrayOf(0)
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.printable())
            moveZeroes.moveZeroes(input)
            println("Output: " + input.printable())
            println()
        }
    }

    fun moveZeroes(nums: IntArray): Unit {
        twoPointersBest(nums)
    }

    private fun twoPointersBest(nums: IntArray): Unit {
        var lastZeroPosition = 0;

        for (i in 0..nums.size-1) {
            if (nums[i] != 0) {
                val temp = nums[lastZeroPosition]
                nums[lastZeroPosition] = nums[i]
                nums[i] = temp

                lastZeroPosition++
            }
        }
    }

    //old implementation
    private fun twoPointers(nums: IntArray): Unit {
        var indexOfValueToChange: Int = 0;

        for (i in 0..nums.size-1) {
            if (nums[i] != 0) {
                nums[indexOfValueToChange] = nums[i]
                indexOfValueToChange++
            }
        }

        for (i in indexOfValueToChange..nums.size-1)
            nums[i] = 0
    }

    //old implementation
    private fun withCounters(nums: IntArray): Unit {
        var numberOfZeroes = 0
        val nonZeroesIndexes = mutableListOf<Int>()

        nums.forEachIndexed { index, value ->
            if (value == 0)
                numberOfZeroes++
            else
                nonZeroesIndexes.add(index)
        }

        for (i in 0..nonZeroesIndexes.size-1) {
            nums[i] = nums[nonZeroesIndexes[i]]
        }
        for (j in nonZeroesIndexes.size..nums.size-1) {
            nums[j] = 0
        }
    }

    //old implementation
    private fun nestedLoop(nums: IntArray): Unit {
        for (i in 0..nums.size-1) {
            if (nums[i] == 0) {
                for (j in i+1..nums.size-1) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j]
                        nums[j] = 0
                        break;
                    }
                    //else
                    // nothing to do
                }
            }
            //else
            // nothing to do
        }
    }
}
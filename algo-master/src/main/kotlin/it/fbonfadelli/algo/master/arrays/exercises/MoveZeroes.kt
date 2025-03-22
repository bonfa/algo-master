package it.fbonfadelli.algo.master.arrays.exercises

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
        latestSolution(nums)
    }

    private fun latestSolution(nums: IntArray): Unit {
        var zeroIdx = -1

        for (i in 0..nums.size - 1) {
            if (nums[i] == 0 && zeroIdx == -1)
                zeroIdx = i

            if (nums[i] != 0 && zeroIdx != -1) {
                //swap
                nums[zeroIdx] = nums[i]
                nums[i] = 0

                //update properly zero index
                for (j in zeroIdx..i) {
                    if (nums[j] == 0) {
                        zeroIdx = j
                        break
                    }
                }
            }
        }
    }

    private fun algoMasterTwoPointersBest(nums: IntArray): Unit {
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
    private fun algoMasterTwoPointers(nums: IntArray): Unit {
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
package it.fbonfadelli.algo.master.arrays.exercises

import it.fbonfadelli.algo.master.utils.printable

class MoveZeroes {

    companion object {
        private val moveZeroes = MoveZeroes()

        fun main() {
            println("MOVE ZEROES")

            val inputs = listOf(
                intArrayOf(0, 1, 0, 3, 12),
                intArrayOf(0),
                intArrayOf(2),
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
        var indexToChange = -1

        var i = 0
        while(i < nums.size) {
            if (nums[i] == 0 && indexToChange == -1) {
                indexToChange = i
            } else if (nums[i] != 0 && indexToChange != -1) {
                nums[indexToChange] = nums[i]
                indexToChange++
            }

            i++
        }

        if (indexToChange != -1) {
            var j = indexToChange
            while(j < nums.size) {
                nums[j] = 0

                j++
            }
        }
    }
}
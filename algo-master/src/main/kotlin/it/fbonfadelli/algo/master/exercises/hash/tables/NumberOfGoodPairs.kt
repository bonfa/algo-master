package it.fbonfadelli.algo.master.exercises.hash.tables

import it.fbonfadelli.algo.master.utils.printable

class NumberOfGoodPairs {

    companion object {
        private val numberOfGoodPairs = NumberOfGoodPairs()

        fun main() {
            println("NUMBER OF GOOD PAIRS")

            val inputs = listOf(
                intArrayOf(1,2,3,1,1,3),
                intArrayOf(1,1,1,1),
                intArrayOf(1,2,3),
                intArrayOf(5,5,1,77,96,96,89,80,12,23,1,6,3,66,39,88,48,38,44,32,44,36,60,87,53,77,72,49,13,39,60,60,71,68,80,75,79,38,4,14,59,75,6,91,87,95,25,55,83,18,26,59,53,100,42,96,76,22,21,4,22,46,34,39,98,82,54,73,52,33,47,73,54,23,82,98,13,51,52,1,96,69,76)
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = numberOfGoodPairs.numIdenticalPairs(input)
            println("Output: $output")
            println()
        }
    }

    fun numIdenticalPairs(nums: IntArray): Int {
        val firstIndexes = IntArray(101)

        var counts = 0
        nums.forEach { num ->
            if (firstIndexes[num] == 0)
                firstIndexes[num] = 1
            else {
                counts += firstIndexes[num]
                firstIndexes[num] = firstIndexes[num] + 1
            }

        }

        return counts
    }
}
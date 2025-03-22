package it.fbonfadelli.algo.master.bit.manipulation.exercises

import it.fbonfadelli.algo.master.utils.printable

class SingleNumber {
    companion object {
        private val singleNumber = SingleNumber()

        fun main() {
            println("SINGLE NUMBER")

            val inputs: List<IntArray> = listOf(
                intArrayOf(2,2,1),
                intArrayOf(4,1,2,1,2),
                intArrayOf(1),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = singleNumber.singleNumber(input)
            println("Output: $output")
            println()
        }
    }

    fun singleNumber(nums: IntArray): Int =
        nums.reduce { a, b -> a xor b }
}
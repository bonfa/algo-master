package it.fbonfadelli.algo.master.prefix.sum.exercises

import it.fbonfadelli.algo.master.utils.printable

class ContinguousArray {

    companion object {
        private val continguousArray = ContinguousArray()

        fun main() {
            println("CONTIGUOUS ARRAY")

            val inputs = listOf(
                intArrayOf(0,1),
                intArrayOf(0,1,0),
                intArrayOf(0,1,1,1,1,1,0,0,0),
                intArrayOf(1,1,1,1,0),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = continguousArray.findMaxLength(input)
            println("Output: $output")
            println()
        }
    }

    fun findMaxLength(nums: IntArray): Int {
        var sum = 0
        var maxLength = 0

        val sumIndex = mutableMapOf<Int, Int>()
        sumIndex[0] = -1

        nums.forEachIndexed { i, num ->

            sum += if (num == 0) -1 else 1

            if (sumIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumIndex[sum]!!)
            } else {
                sumIndex[sum] = i
            }
        }

        return maxLength
    }
}
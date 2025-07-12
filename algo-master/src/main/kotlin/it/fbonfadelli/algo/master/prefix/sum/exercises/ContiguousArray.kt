package it.fbonfadelli.algo.master.prefix.sum.exercises

import it.fbonfadelli.algo.master.utils.printable
import kotlin.math.max

class ContiguousArray {

    companion object {
        private val contiguousArray = ContiguousArray()

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
            val output = contiguousArray.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray): Int {
        val idxMap = mutableMapOf<Int, Int>()
        idxMap[0] = -1

        var sum = 0
        var maxLength = 0
        for (i in 0 until nums.size) {
            val num = if (nums[i] == 0) -1 else nums[i] // -1 or 1

            sum += num
            if (idxMap.containsKey(sum)) {
                maxLength = max(maxLength, i - idxMap[sum]!!)
            } else {
                idxMap[sum] = i
            }
        }

        return maxLength
    }
}
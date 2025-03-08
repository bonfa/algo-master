package it.fbonfadelli.algo.master.exercises.bits

import it.fbonfadelli.algo.master.utils.printable

class SingleNumberIII {
    companion object {
        private val singleNumberIII = SingleNumberIII()

        fun main() {
            println("SINGLE NUMBER III")

            val inputs: List<IntArray> = listOf(
                intArrayOf(1,2,1,3,2,5),
                intArrayOf(-1,0),
                intArrayOf(0,1),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = singleNumberIII.singleNumber(input)
            println("Output: ${output.printable()}")
            println()
        }
    }

    fun singleNumber(nums: IntArray): IntArray {
        return withMap(nums)
    }

    private fun withMap(nums: IntArray): IntArray {
        val counts: MutableMap<Int, Int> = mutableMapOf()
        nums.toList().forEach { num ->
            if (counts[num] == null)
                counts[num] = 1
            else
                counts[num] = counts[num]!!+1
        }

        return counts.filter { (k,v) -> v == 1 }.map { it.key }.toIntArray()
    }
}
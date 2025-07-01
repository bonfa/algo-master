package it.fbonfadelli.algo.master.bit.manipulation.exercises

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
            val output = singleNumberIII.execute(input)
            println("Output: ${output.printable()}")
            println()
        }
    }

    fun execute(nums: IntArray): IntArray {
        var xxor = nums[0]
        var i = 1
        while(i < nums.size) {
            xxor = xxor xor nums[i]
            i++
        }

        var firstDifferentBit = xxor
        var numberOfShifts = 0

        while(firstDifferentBit and 1 == 0) {
            firstDifferentBit = firstDifferentBit shr 1
            numberOfShifts++
        }

        firstDifferentBit = 1 shl numberOfShifts

        i = 0
        var num1 = 0
        var num2 = 0
        while(i < nums.size) {
            if (nums[i] and firstDifferentBit == 0) {
                num1 = num1 xor nums[i]
            } else {
                num2 = num2 xor nums[i]
            }
            i++
        }
        return intArrayOf(num1, num2)
    }
}
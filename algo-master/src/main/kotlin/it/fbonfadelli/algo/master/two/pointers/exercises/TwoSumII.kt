package it.fbonfadelli.algo.master.two.pointers.exercises

import it.fbonfadelli.algo.master.utils.printable

class TwoSumII {

    companion object {
        private val twoSumII = TwoSumII()

        fun main() {
            println("Two Sum II - Input Array Is Sorted")

            val inputs = listOf(
                Input(intArrayOf(2,7,11,15),3),
                Input(intArrayOf(2,3,4),6),
                Input(intArrayOf(-1,0),-1),
                Input(intArrayOf(3,24,50,79,88,150,345),200),
                Input(intArrayOf(-3,3,4,90),0),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = twoSumII.twoSum(input.nums, input.target)
            println("Output: ${output.printable()}")
            println()
        }
    }

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        if (numbers.size==2)
            return intArrayOf(1,2)

        var idx1 = 0
        var idx2 = numbers.size-1
        while(true) {
            if (numbers[idx1] + numbers[idx2] == target) {
                return intArrayOf(idx1+1, idx2+1)
            }

            if (numbers[idx1 + 1] + numbers[idx2] <= target)
                idx1++
            else
                idx2--
        }
    }

    private data class Input(val nums: IntArray, val target:Int)
}
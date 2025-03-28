package it.fbonfadelli.algo.master.two.pointers.exercises

import it.fbonfadelli.algo.master.utils.printable

class ThreeSum {

    companion object {
        private val threeSum = ThreeSum()

        fun main() {
            println("THREE SUM")

            val inputs = listOf(
                intArrayOf(-1,0,1,2,-1,-4),
                intArrayOf(0,1,1),
                intArrayOf(0,0,0),
                intArrayOf(-2,0,1,1,2),
                intArrayOf(0,0,0,0),
                intArrayOf(1,-1,-1,0),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = threeSum.threeSum(input)
            println("Output: ${output.printable()}")
            println()
        }
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        return bruteForce(nums)
    }

    private fun bruteForce(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()

        for (i in 0..nums.size-1) {
            for (j in i+1..nums.size-1) {
                for (k in j+1..nums.size-1) {
                    if (nums[i] + nums[j] + nums[k] == 0 && i!=j && j!=k)
                        result.add(listOf(nums[i], nums[j], nums[k]).sorted())
                }
            }
        }

        return result.map { it }
    }
}
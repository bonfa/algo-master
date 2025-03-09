package it.fbonfadelli.algo.master.exercises.arrays

import it.fbonfadelli.algo.master.utils.printable

class ProductOfArrayExceptSelf {

    companion object {
        private val productOfArrayExceptSelf = ProductOfArrayExceptSelf()

        fun main() {
            println("PRODUCT OF ARRAY EXCEPT SELF")

            val inputs = listOf(
                intArrayOf(1,2,3,4),
                intArrayOf(-1,1,0,-3,3),
                intArrayOf(1,2),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: " + input.printable())
            val output = productOfArrayExceptSelf.productExceptSelf(input)
            println("Output: ${output.printable()}")
            println()
        }
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val prefix = IntArray(nums.size)
        val suffix = IntArray(nums.size)
        val products = IntArray(nums.size)

        prefix[0] = 1
        for (i in 1..nums.size - 1) {
            prefix[i] = prefix[i-1] * nums[i-1]
        }

        suffix[nums.size - 1] = 1
        for (i in (nums.size - 2).downTo(0)) {
            suffix[i] = suffix[i+1] * nums[i+1]
        }

        for (i in 0..nums.size-1) {
            products[i] = suffix[i] * prefix[i]
        }

        return products
    }
}
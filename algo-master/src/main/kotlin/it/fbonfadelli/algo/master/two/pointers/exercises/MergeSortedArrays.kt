package it.fbonfadelli.algo.master.two.pointers.exercises

import it.fbonfadelli.algo.master.utils.printable

class MergeSortedArrays {

    companion object {
        private val mergeSortedArrays = MergeSortedArrays()

        fun main() {
            println("MERGE SORTED ARRAYS")

            val inputs = listOf(
                Input(intArrayOf(1,2,3,0,0,0),3, intArrayOf(2,5,6), 3),
                Input(intArrayOf(1),1, intArrayOf(), 0),
                Input(intArrayOf(0),0, intArrayOf(1), 1),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            mergeSortedArrays.execute(input.nums1, input.m, input.nums2, input.n)
            println("Output: ${input.nums1.printable()}")
            println()
        }
    }

    fun execute(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        val temp = IntArray(m + n)
        var p1 = 0
        var p2 = 0

        for(i in 0 until m + n) {
            if (p1 >= m || (p2 < n && nums1[p1] > nums2[p2])) {
                temp[i] = nums2[p2]
                p2++
            } else {
                temp[i] = nums1[p1]
                p1++
            }
        }

        for(i in 0 until m + n) {
            nums1[i] = temp[i]
        }
    }


    private data class Input(val nums1: IntArray, val m:Int, val nums2: IntArray, val n: Int)
}
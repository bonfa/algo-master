package it.fbonfadelli.algo.master.two.pointers.exercises

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
            println("Input: " + input)
            val output = mergeSortedArrays.merge(input.nums1, input.m, input.nums2, input.n)
            println("Output: $output")
            println()
        }
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        //create result
        val result = IntArray(m+n)
        var i = 0
        var j = 0
        var k = 0
        while (true) {
            var num1: Int? = null
            if (i < m) {
                num1 = nums1[i]
            }

            var num2: Int? = null
            if (j < n) {
                num2 = nums2[j]
            }

            if (num1 == null) {
                result[k] = num2!!
                j++
            } else if (num2 == null) {
                result[k] = num1!!
                i++
            } else if (num1!! <= num2!!) {
                result[k] = num1
                i++
            } else {
                result[k] = num2
                j++
            }

            k++

            if (i >= m && j>=n)
                break
        }


        //copy result in nums1
        for (i in 0..result.size-1) {
            nums1[i] = result[i]
        }
    }

    private data class Input(val nums1: IntArray, val m:Int, val nums2: IntArray, val n: Int)
}
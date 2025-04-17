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
            mergeSortedArrays.merge(input.nums1, input.m, input.nums2, input.n)
            println("Output: ${input.nums1.printable()}")
            println()
        }
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        version2(m, n, nums1, nums2)
    }

    private fun version2(m: Int, n: Int, nums1: IntArray, nums2: IntArray) {
        if (n == 0)
            return

        var p1 = 0
        var p2 = 0

        while (p1 < m+n) {
            if (p1 < m && p2 < n) {
                if (nums1[p1] <= nums2[p2]) {
                    p1++
                } else {
                    var temp = nums1[p1]
                    nums1[p1] = nums2[p2]
                    nums2[p2] = temp

                    var p2Temp = p2
                    while(p2Temp < n-1 && nums2[p2Temp+1] < nums2[p2Temp]) {
                        var t = nums2[p2Temp]
                        nums2[p2Temp] = nums2[p2Temp+1]
                        nums2[p2Temp+1] = t
                        p2Temp++
                    }
                }
            } else {
                nums1[p1] = nums2[p2]
                p1++
                p2++
            }
        }
    }


    private fun version1(m: Int, n: Int, nums1: IntArray, nums2: IntArray) {
        //create result
        val result = IntArray(m + n)
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

            if (i >= m && j >= n)
                break
        }


        //copy result in nums1
        for (i in 0..result.size - 1) {
            nums1[i] = result[i]
        }
    }

    private data class Input(val nums1: IntArray, val m:Int, val nums2: IntArray, val n: Int)
}
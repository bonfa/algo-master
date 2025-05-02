package it.fbonfadelli.algo.master.arrays.exercises

import it.fbonfadelli.algo.master.utils.printable

class RotateArray {

    companion object {
        private val rotateArray = RotateArray()

        fun main() {
            println("ROTATE ARRAY")

            val inputs = listOf(
                Input(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3),
                Input(intArrayOf(-1, -100, 3, 99), 2),
                Input(intArrayOf(1, 2, 3), 4),
                Input(intArrayOf(1, 2, 3,4,5), 2),
                Input(intArrayOf(1, 2, 3,4), 2),
                Input(intArrayOf(1, 2, 3), 2),
                Input(intArrayOf(1, 2, 3, 4, 5, 6), 3),
                Input(intArrayOf(1), 0),
                Input(intArrayOf(1,2), 0),
                Input(intArrayOf(1,2), 2),
                Input(
                    intArrayOf(
                        1,
                        2,
                        3,
                        4,
                        5,
                        6,
                        7,
                        8,
                        9,
                        10,
                        11,
                        12,
                        13,
                        14,
                        15,
                        16,
                        17,
                        18,
                        19,
                        20,
                        21,
                        22,
                        23,
                        24,
                        25,
                        26,
                        27,
                        28,
                        29,
                        30,
                        31,
                        32,
                        33,
                        34,
                        35,
                        36,
                        37,
                        38,
                        39,
                        40,
                        41,
                        42,
                        43,
                        44,
                        45,
                        46,
                        47,
                        48,
                        49,
                        50,
                        51,
                        52,
                        53,
                        54
                    ), 45
                ),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index + 1}:")
            println("Input: " + input.array.printable() + "   k=${input.k}")
            rotateArray.rotate(input.array, input.k)
            println("Output: " + input.array.printable())
            println()
        }
    }

    fun rotate(nums: IntArray, k: Int) {
        val fixedK = if (k > nums.size) k % nums.size else k

        if (fixedK == nums.size) return

        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, fixedK - 1)
        reverse(nums, fixedK, nums.size - 1)
    }

    private fun reverse(arr: IntArray, from: Int, to: Int) {
        var p1 = from
        var p2 = to
        while(p1 < p2) {
            val temp = arr[p1]
            arr[p1] = arr[p2]
            arr[p2] = temp

            p1++
            p2--
        }
    }

    private data class Input(val array: IntArray, val k: Int)
}
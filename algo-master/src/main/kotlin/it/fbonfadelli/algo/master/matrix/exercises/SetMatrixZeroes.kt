package it.fbonfadelli.algo.master.matrix.exercises

import it.fbonfadelli.algo.master.utils.printable

class SetMatrixZeroes {

    companion object {
        private val setMatrixZeroes = SetMatrixZeroes()

        fun main() {
            println("SET MATRIX ZEROES")

            val inputs = listOf(
                arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1)),
                arrayOf(intArrayOf(0, 1, 2, 0), intArrayOf(3, 4, 5, 2), intArrayOf(1, 3, 1, 5)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Array<IntArray>) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            setMatrixZeroes.execute(input)
            println("Output: ${input.printable()}")
            println()
        }
    }

    fun execute(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix[0].size

        val colSet = mutableSetOf<Int>()
        val rawSet = mutableSetOf<Int>()

        for (y in 0 until m) {
            for (x in 0 until n) {
                if (matrix[y][x] == 0) {
                    rawSet.add(y)
                    colSet.add(x)
                }
            }
        }

        for (y in 0 until m) {
            if (rawSet.contains(y)) {
                for (x in 0 until n) {
                    matrix[y][x] = 0
                }
            }
        }

        for (x in 0 until n) {
            if (colSet.contains(x)) {
                for (y in 0 until m) {
                    matrix[y][x] = 0
                }
            }
        }
    }
}
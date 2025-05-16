package it.fbonfadelli.algo.master.matrix.exercises

import it.fbonfadelli.algo.master.utils.printable

class SpiralMatrix {

    companion object {
        private const val INCREASE_X = 0
        private const val INCREASE_Y = 1
        private const val DECREASE_X = 2
        private const val DECREASE_Y = 3

        private val spiralMatrix = SpiralMatrix()

        fun main() {
            println("SPIRAL MATRIX")

            val inputs = listOf(
                arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
                arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Array<IntArray>) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = spiralMatrix.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(matrix: Array<IntArray>): List<Int> {
        var operation = INCREASE_X
        var minY = 0
        var maxY = matrix.size

        var minX = 0
        var maxX = matrix[0].size

        val numbers = mutableListOf<Int>()

        while(minX != maxX && minY != maxY) {
            if (operation == INCREASE_X) {
                for (x in minX until maxX) {
                    numbers.add(matrix[minY][x])
                }
                minY++
                operation = INCREASE_Y
            } else if (operation == INCREASE_Y) {
                for (y in minY until maxY) {
                    numbers.add(matrix[y][maxX - 1])
                }
                maxX--
                operation = DECREASE_X
            } else if (operation == DECREASE_X) {
                for (x in (maxX-1).downTo(minX)) {
                    numbers.add(matrix[maxY - 1][x])
                }
                maxY--
                operation = DECREASE_Y
            } else if (operation == DECREASE_Y) {
                for (y in (maxY-1).downTo(minY)) {
                    numbers.add(matrix[y][minX])
                }
                minX++
                operation = INCREASE_X
            }
        }

        return numbers
    }
}
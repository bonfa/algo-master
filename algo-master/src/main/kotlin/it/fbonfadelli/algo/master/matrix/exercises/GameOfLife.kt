package it.fbonfadelli.algo.master.matrix.exercises

import it.fbonfadelli.algo.master.utils.printable
import kotlin.math.max
import kotlin.math.min

class GameOfLife {

    companion object {
        private val gameOfLife = GameOfLife()

        fun main() {
            println("GAME OF LIFE")

            val inputs = listOf(
                arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 0, 0)
                ),
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 0),
                ),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Array<IntArray>) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            gameOfLife.execute(input)
            println("Output: ${input.printable()}")
            println()
        }
    }

    fun execute(board: Array<IntArray>) {
        val copy: Array<IntArray> = Array(board.size) { IntArray(board[0].size) }

        for (y in 0 until board.size) {
            for (x in 0 until board[y].size) {
                val cell = board[y][x]
                val aliveNeighbourhoods = numberOfAliveNeighbourhoods(board, y, x)
                if (aliveNeighbourhoods == 3 || (aliveNeighbourhoods == 2 && cell == 1)) {
                    copy[y][x] = 1
                }
            }
        }

        for (y in 0 until board.size) {
            for (x in 0 until board[y].size) {
                board[y][x] = copy[y][x]
            }
        }
    }

    private fun numberOfAliveNeighbourhoods(board: Array<IntArray>, currY: Int, currX: Int): Int {
        var count = 0

        for (y in max(0, currY - 1) until min(board.size, currY + 2)) {
            for (x in max(0, currX - 1) until min(board[0].size, currX + 2)) {
                if (board[y][x] == 1)
                    count++
            }
        }

        if (board[currY][currX] == 1)
            count--

        return count
    }
}
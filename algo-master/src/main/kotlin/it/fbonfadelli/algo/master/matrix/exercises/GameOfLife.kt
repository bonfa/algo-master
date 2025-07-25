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

    private val dead = 0
    private val alive = 1

    fun execute(board: Array<IntArray>) {
        val aliveInTheNextState = mutableSetOf<Coord>()

        for (y in 0 until board.size) {
            for (x in 0 until board[y].size) {
                val numberOfAliveNeighbours = numberOfAliveNeighbours(board, y, x)
                if (numberOfAliveNeighbours == 3 || (numberOfAliveNeighbours == 2 && board[y][x] == alive)) {
                    aliveInTheNextState.add(Coord(y,x))
                }
            }
        }

        for (y in 0 until board.size) {
            for (x in 0 until board[y].size) {
                if (aliveInTheNextState.contains(Coord(y,x)))
                    board[y][x] = alive
                else
                    board[y][x] = dead
            }
        }
    }

    private fun numberOfAliveNeighbours(board: Array<IntArray>, yCell: Int, xCell:Int): Int {
        val minX = max(0, xCell - 1)
        val maxX = min(xCell + 2, board[yCell].size)
        val minY = max(0, yCell - 1)
        val maxY = min(yCell + 2, board.size)

        var count = 0
        for (y in minY until maxY) {
            for (x in minX until maxX) {
                if (x == xCell && y == yCell)
                    continue
                if (board[y][x] == alive)
                    count++
            }
        }
        return count
    }

    private data class Coord(val y:Int, val x:Int)
}
package it.fbonfadelli.algo.master.matrix.exercises

import it.fbonfadelli.algo.master.utils.printable

class ValidSudoku {

    companion object {
        private val validSudoku = ValidSudoku()

        fun main() {
            println("VALID SUDOKU")

            val inputs = listOf(
                arrayOf(
                    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                ),
                arrayOf(
                    charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                ),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Array<CharArray>) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = validSudoku.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(board: Array<CharArray>): Boolean {
        val digits = IntArray(9)

        //validating rows
        for (y in 0 until 9) {
            val row = board[y]
            clear(digits)
            for (x in 0 until 9) {
                val digit = row[x]
                if (digit != '.') {
                    if (digits[digit - '1'] != 0)
                        return false
                    else
                        digits[digit - '1']++
                }
            }
        }

        //validating columns
        for (x in 0 until 9) {
            clear(digits)
            for (y in 0 until 9) {
                val digit = board[y][x]
                if (digit != '.') {
                    if (digits[digit - '1'] != 0)
                        return false
                    else
                        digits[digit - '1']++
                }
            }
        }

        //validating subsquares
        for (xOfs in 0 until 3) {
            for (yOfs in 0 until 3) {
                clear(digits)
                for (y in 0 until 3) {
                    for (x in 0 until 3) {
                        val digit = board[yOfs * 3 + y][xOfs * 3 + x]
                        if (digit != '.') {
                            if (digits[digit - '1'] != 0)
                                return false
                            else
                                digits[digit - '1']++
                        }
                    }
                }
            }
        }

        return true
    }

    private fun clear(digits: IntArray) {
        for (i in 0 until 9) {
            digits[i] = 0
        }
    }
}
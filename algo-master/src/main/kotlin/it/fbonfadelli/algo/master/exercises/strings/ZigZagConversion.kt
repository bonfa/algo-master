package it.fbonfadelli.algo.master.exercises.strings

class ZigZagConversion {

    companion object {
        private val zigZagConversion = ZigZagConversion()

        fun main() {
            println("ZIG ZAG CONVERSION")

            val inputs = listOf(
                Input("PAYPALISHIRING", 3),
                Input("PAYPALISHIRING", 4),
                Input("A", 1),
                Input("A", 2),
                Input("AB", 3),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = zigZagConversion.convert(input.str, input.numRows)
            println("Output: $output")
            println()
        }
    }

    fun convert(s: String, numRows: Int): String {
        //edge case
        if (s.length == 1 || numRows == 1 || s.length <= numRows)
            return s

        //create empty structure
        val lines = Array<StringBuilder>(numRows) { StringBuilder("") }

        // fill support structure
        var y = 0
        var incrementing = true
        for (i in 0..s.length - 1) {
            val char = s[i]

            lines[y].append(char)

            if (incrementing) {
                if (y == numRows - 1) {
                    y--
                    incrementing = false
                } else {
                    y++
                }
            } else {
                if (y == 0) {
                    y++
                    incrementing = true
                } else {
                    y--
                }
            }
        }

        return lines.map{ it.toString() }.joinToString("")
    }

    private data class Input(val str: String, val numRows: Int)
}
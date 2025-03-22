package it.fbonfadelli.algo.master.bit.manipulation.exercises

class NumberOf1Bits {
    companion object {
        private val numberOf1Bits = NumberOf1Bits()

        fun main() {
            println("NUMBER OF 1 BITS")

            val inputs: List<Int> = listOf(
                11,
                128,
                2147483645
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Int) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = numberOf1Bits.numberOf1Bits(input)
            println("Output: $output")
            println()
        }
    }

    fun numberOf1Bits(n: Int): Int {
        var count = 0
        var num = n

        while (num > 0) {
            if (num and 1 == 1)
                count++

            num = num shr 1
        }

        return count
    }
}
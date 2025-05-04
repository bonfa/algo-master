package it.fbonfadelli.algo.master.bit.manipulation.exercises

import it.fbonfadelli.algo.master.utils.printable

class CountingBits {

    companion object {
        private val countingBits = CountingBits()

        fun main() {
            println("COUNTING BITS")

            val inputs = listOf(
                2,
                5
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Int) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = countingBits.countBits(input)
            println("Output: ${output.printable()}")
            println()
        }
    }

    fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1)

        ans[0] = 0
        var pow = 1
        var i = 1
        while (i <= n) {
            if (i == pow) {
                ans[i] = 1
                pow = pow * 2
            } else {
                ans[i] = 1 + ans[i - pow / 2]
            }

            i++
        }

        return ans
    }
}
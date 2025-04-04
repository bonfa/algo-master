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
        return optimalVersionWithDecentNames(n)
    }

    private fun optimalVersionWithDecentNames(n: Int): IntArray {
        val res = IntArray(n + 1)
        var nextPow = 1
        var currPow = 1

        for (i in 1..n) {
            if (i == nextPow) {
                nextPow = nextPow * 2
                currPow = i
            }

            val k = i - currPow
            res[i] = res[k] + 1
        }

        return res
    }

    fun version1(n: Int): IntArray {
        val ans = IntArray(n+1)

        for (i in 0..n) {
            val countOfOnes:Int = countOnesIn(i)
            ans[i] = countOfOnes
        }

        return ans
    }

    private fun countOnesIn(n:Int): Int {
        var num = n
        var count = 0

        while (num != 0) {
            num = num and (num-1)
            count++
        }

        return count
    }
}
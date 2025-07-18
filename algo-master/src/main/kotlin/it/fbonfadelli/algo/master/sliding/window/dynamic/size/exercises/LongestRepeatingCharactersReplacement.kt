package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

import kotlin.math.max

class LongestRepeatingCharactersReplacement {

    companion object {
        private val longestRepeatingCharactersReplacement = LongestRepeatingCharactersReplacement()

        fun main() {
            println("LONGEST REPEATING CHARACTERS REPLACEMENT")

            val inputs = listOf(
                Input("ABAB", 2),
                Input("AABABBA", 1),
                Input("ABAB", 0),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = longestRepeatingCharactersReplacement.execute(input.str, input.k)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String, k: Int): Int {
        val charMap = IntArray(26)

        var l = 0
        var r = 0
        var maxCount = 0
        var count = 0
        var greaterThanZero = 0

        while(r < s.length) {
            val c = s[r]
            if (charMap[c - 'A'] == 0)
                greaterThanZero++
            charMap[c - 'A']++
            count++

            if (needToShrink(charMap, k, count, greaterThanZero)) {
                val cl = s[l]
                charMap[cl - 'A']--
                if (charMap[cl - 'A'] == 0)
                    greaterThanZero--
                l++
                count--
            }

            maxCount = max(maxCount, r + 1 - l)
            r++
        }

        return maxCount
    }

    private fun needToShrink(charMap: IntArray, k: Int, count: Int, greaterThanZero: Int): Boolean {
        if (greaterThanZero > k + 1)
            return true

        var max = 0
        for (v in charMap) {
            max = max(v, max)
        }

        return k != 0 && count - max > k
    }

    private data class Input(val str: String, val k: Int)
}
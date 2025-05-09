package it.fbonfadelli.algo.master.hash.tables.exercises

class ReorganizeString {

    companion object {
        private val reorganizeString = ReorganizeString()

        fun main() {
            println("REORGANIZE STRING")

            val inputs = listOf(
                "aab",
                "aaab",
                "a",
                "ababababa",
                "aabbcc",
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: String) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = reorganizeString.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String): String {
        val freq = IntArray(26)
        for (i in s.indices) {
            freq[s[i] - 'a']++
        }

        if (freq.max() > s.length / 2 + 1)
            return ""

        val output = CharArray(s.length)
        while (freq.max() > 0) {
            val max = freq.max()
            val idxOfMax = freq.indexOf(max)
            val maxChar = ('a'.code + idxOfMax).toChar()

            var freeCharIdx = -1
            for (i in 0 until output.size) {
                if (output[i] == 0x00.toChar() && (i == 0 || (i > 0 && output[i - 1] != maxChar))) {
                    freeCharIdx = i
                    break
                }
            }

            if (freeCharIdx == -1)
                return ""

            output[freeCharIdx] = maxChar
            freq[idxOfMax]--
        }

        return output.joinToString("")
    }
}
package it.fbonfadelli.algo.master.sliding.window.exercises

class PermutationInString {

    companion object {
        private val permutationInString = PermutationInString()

        fun main() {
            println("PERMUTATION IN STRING")

            val inputs = listOf(
                Input("ab", "eidbaooo"),
                Input("ab", "eidboaoo"),
                Input("a","ab"),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = permutationInString.checkInclusion(input.s, input.p)
            println("Output: $output")
            println()
        }
    }

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length)
            return false

        val s1Map = IntArray(26)
        val s2Map = IntArray(26)
        for (i in 0 until s1.length) {
            s1Map[s1[i] - 'a']++
            s2Map[s2[i] - 'a']++
        }

        if (s1Map.contentEquals(s2Map))
            return true

        for (i in s1.length until s2.length) {
            s2Map[s2[i-s1.length] - 'a']--
            s2Map[s2[i]-'a']++
            if (s1Map.contentEquals(s2Map))
                return true
        }

        return false
    }

    private data class Input(val s: String, val p: String)
}
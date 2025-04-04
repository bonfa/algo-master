package it.fbonfadelli.algo.master.sliding.window.exercises

class FindAllAnagramsInAString {

    companion object {
        private val findAllAnagramsInAString = FindAllAnagramsInAString()

        fun main() {
            println("FIND ALL ANAGRAMS IN A STRING")

            val inputs = listOf(
                Input("abc", "abc"),
                Input("abab", "ab"),
                Input("cbaebabacd", "abc"),
                Input("aaaaaaaaaa", "aaaaaaaaaaaaa"),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = findAllAnagramsInAString.findAnagrams(input.s, input.p)
            println("Output: $output")
            println()
        }
    }

    fun findAnagrams(s: String, p: String): List<Int> {
        val size = p.length
        if (s.length < p.length)
            return emptyList()

        val pCharCounts = mutableMapOf<Char, Int>()
        for (i in 0 until size) {
            val c = p[i]
            if (pCharCounts.containsKey(c))
                pCharCounts[c] = pCharCounts[c]!! + 1
            else
                pCharCounts[c] = 1
        }

        for (i in 0 until size) {
            val c = s[i]
            if (pCharCounts.containsKey(c)) {
                pCharCounts[c] = pCharCounts[c]!! - 1
                if (pCharCounts[c] == 0) {
                    pCharCounts.remove(c)
                }
            } else {
                pCharCounts[c] = -1
            }
        }

        val result = mutableListOf<Int>()

        if (pCharCounts.isEmpty()) {
            result.add(0)
        }

        for (i in 0 until s.length - size) {
            val charToRemove = s[i]
            val chatToAdd = s[i + size]

            if (pCharCounts.containsKey(charToRemove)) {
                pCharCounts[charToRemove] = pCharCounts[charToRemove]!! + 1
                if (pCharCounts[charToRemove] == 0) {
                    pCharCounts.remove(charToRemove)
                }
            } else {
                pCharCounts[charToRemove] = 1
            }

            if (pCharCounts.containsKey(chatToAdd)) {
                pCharCounts[chatToAdd] = pCharCounts[chatToAdd]!! - 1
                if (pCharCounts[chatToAdd] == 0) {
                    pCharCounts.remove(chatToAdd)
                }
            } else {
                pCharCounts[chatToAdd] = -1
            }

            if (pCharCounts.isEmpty()) {
                result.add(i+1)
            }
        }

        return result
    }

    private data class Input(val s: String, val p: String)
}
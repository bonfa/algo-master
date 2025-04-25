package it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises

class FindAllAnagramsInAString {

    companion object {
        private val findAllAnagramsInAString = FindAllAnagramsInAString()

        fun main() {
            println("FIND ALL ANAGRAMS IN A STRING")

            val inputs = listOf(
                Input("abc", "abc"),
                Input("cbaebabacd", "abc"),
                Input("abab", "ab"),
                Input("cbab", "ab"),
                Input("aa", "bb"),
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
        return version2(p, s)
    }

    private fun version2(p: String, s: String): List<Int> {
        if (p.length > s.length)
            return emptyList()

        val pFreq = IntArray(26)
        for (i in p.indices) {
            pFreq[p[i]-'a']++
        }

        val k = p.length

        val sFreq = IntArray(26)
        for (i in 0 until k) {
            sFreq[s[i]-'a']++
        }

        var anagramsIndices = mutableListOf<Int>()
        if (pFreq.contentEquals(sFreq)) {
            anagramsIndices.add(0)
        }

        var left = 0
        while(left + k < s.length) {
            sFreq[s[left]-'a']--
            sFreq[s[left + k]-'a']++

            if (pFreq.contentEquals(sFreq)) {
                anagramsIndices.add(left + 1)
            }

            left++
        }

        return anagramsIndices
    }

    private fun version1(p: String, s: String): List<Int> {
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
                result.add(i + 1)
            }
        }

        return result
    }

    private data class Input(val s: String, val p: String)
}
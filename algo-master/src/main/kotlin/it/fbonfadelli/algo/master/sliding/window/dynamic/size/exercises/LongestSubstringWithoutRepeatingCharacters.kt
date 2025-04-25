package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

class LongestSubstringWithoutRepeatingCharacters {

    companion object {
        private val longestSubstringWithoutRepeatingCharacters = LongestSubstringWithoutRepeatingCharacters()

        fun main() {
            println("FIND ALL ANAGRAMS IN A STRING")

            val inputs = listOf(
                "abcabcbb",
                "bbbbb",
                "pwwkew",
                "au",
                "",
                "dvdf",
                "tmmzuxt",
                "bbtablud",
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: String) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input)
            println("Output: $output")
            println()
        }
    }

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }

        val lastCharIndex = mutableMapOf<Char, Int>()

        var l = -1
        var maxCount = 0
        var r = 0
        while (r < s.length) {
            val c = s[r]
            if (!lastCharIndex.containsKey(c) || (lastCharIndex.containsKey(c) && lastCharIndex[c]!! < l)) {
                lastCharIndex[c] = r
            } else {
                maxCount = Math.max(r-l-1, maxCount)
                l = lastCharIndex[c]!!
                lastCharIndex[c] = r
            }
            r++
        }

        maxCount = Math.max(r-l-1, maxCount)

        return maxCount
    }

}
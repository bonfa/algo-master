package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

class LongestSubstringWithoutRepeatingCharacters {

    companion object {
        private val longestSubstringWithoutRepeatingCharacters = LongestSubstringWithoutRepeatingCharacters()

        fun main() {
            println("LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS")

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
            val output = longestSubstringWithoutRepeatingCharacters.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String): Int {
        if (s.length <= 1)
            return s.length

        val map = IntArray(128)

        var l = 0
        var r = 0
        var maxLength = 0

        while(r < s.length) {
            val toAdd = s[r]
            while (map[toAdd.code] > 0 && l < r) {
                val toRemove = s[l]
                map[toRemove.code] = map[toRemove.code] - 1
                l++
            }

            map[toAdd.code]++
            val currentLength = r - l + 1
            maxLength = Math.max(maxLength, currentLength)
            r++
        }


        return maxLength
    }

}
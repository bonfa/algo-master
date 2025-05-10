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
            println("Input: $input")
            val output = findAllAnagramsInAString.execute(input.s, input.p)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String, p: String): List<Int> {
        if (p.length > s.length)
            return emptyList()

        val pFreq = IntArray(26)
        val sFreq = IntArray(26)
        var i = 0
        val k = p.length
        while (i < k) {
            pFreq[p[i] - 'a']++
            sFreq[s[i] - 'a']++

            i++
        }

        val anagramsIndexes = mutableListOf<Int>()
        if (pFreq.contentEquals(sFreq)) {
            anagramsIndexes.add(0)
        }

        i = k
        while (i < s.length) {
            sFreq[s[i] - 'a']++
            sFreq[s[i - k] - 'a']--

            if (pFreq.contentEquals(sFreq)) {
                anagramsIndexes.add(i - k + 1)
            }

            i++
        }

        return anagramsIndexes
    }

    private data class Input(val s: String, val p: String)
}
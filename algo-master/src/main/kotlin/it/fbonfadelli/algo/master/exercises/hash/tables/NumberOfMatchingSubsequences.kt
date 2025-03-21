package it.fbonfadelli.algo.master.exercises.hash.tables

class NumberOfMatchingSubsequences {

    companion object {
        private val numberOfMatchingSubsequences = NumberOfMatchingSubsequences()

        fun main() {
            println("NUMBER OF MATCHING SUB SEQUENCES")

            val inputs = listOf(
                Input("abcde", arrayOf("a","bb","acd","ace")),
                Input("dsahjpjauf", arrayOf("ahjpjau","ja","ahbwzgqnuk","tnmlanowax"))
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = numberOfMatchingSubsequences.numMatchingSubseq(input.s, input.words)
            println("Output: $output")
            println()
        }
    }

    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val charMap: Array<MutableList<Int>> = charMap(s)
        val wordsMap: Map<String, Int> = createWordMap(words)

        var count = 0
        for ((w,c) in wordsMap) {
            if (w.length > s.length)
                continue
            else if (w == s)
                count+=c
            else if (canBuildFrom(w, charMap))
                count+=c
        }

        return count
    }

    private fun createWordMap(words: Array<String>): Map<String, Int> {
        val map = mutableMapOf<String, Int>()
        for (w in words) {
            if (map[w] != null)
                map[w] = map[w]!! + 1
            else {
                map[w] = 1
            }
        }
        return map
    }

    private fun charMap(s:String): Array<MutableList<Int>> {
        val arr: Array<MutableList<Int>> = Array(128) { mutableListOf<Int>() }

        for (i in 0..s.length-1) {
            arr[s[i]-'a']!!.add(i)
        }

        return arr
    }

    private fun canBuildFrom(word: String, charMap: Array<MutableList<Int>>): Boolean {
        var indexInS = -1
        var i = 0
        while (i < word.length) {
            val c = word[i]

            if (charMap[c-'a'].isEmpty())
                return false

            if (charMap[c-'a']!!.none { it > indexInS })
                return false

            indexInS = charMap[c-'a']!!.first { it > indexInS }!!

            i++
        }

        return true
    }

    private data class Input(val s:String, val words:Array<String>)
}
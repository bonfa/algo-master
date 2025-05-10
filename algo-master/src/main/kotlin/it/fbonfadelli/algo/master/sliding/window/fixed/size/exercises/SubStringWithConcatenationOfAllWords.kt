package it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises

class SubStringWithConcatenationOfAllWords {

    companion object {
        private val subStringWithConcatenationOfAllWords = SubStringWithConcatenationOfAllWords()

        fun main() {
            println("SUBSTRING WITH CONCATENATION OF ALL WORDS")

            val inputs = listOf(
                Input("barfoothefoobarman", arrayOf("foo","bar")),
                Input("wordgoodgoodgoodbestword", arrayOf("word","good","best","word")),
                Input("barfoofoobarthefoobarman", arrayOf("bar","foo","the")),
                Input("wordgoodgoodgoodbestword", arrayOf("word","good","best","good")),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = subStringWithConcatenationOfAllWords.execute(input.s, input.words)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String, words: Array<String>): List<Int> {
        val wordsFreq = mutableMapOf<String, Int>()
        for (word in words) {
            wordsFreq[word] = wordsFreq.getOrDefault(word, 0) + 1
        }

        val lengthOfSingleWord = words[0].length
        val numberOfWords = words.size

        var i = 0
        val matchingIndexes = mutableListOf<Int>()
        while (i < s.length) {

            if (matches(s, i, lengthOfSingleWord, wordsFreq, words.size))
                matchingIndexes.add(i)

            i++
        }

        return matchingIndexes
    }

    private fun matches(s: String, i: Int, lengthOfSingleWord: Int, wordsFreq: Map<String, Int>, numberOfWords: Int): Boolean {
        val candidateFreq = mutableMapOf<String, Int>()

        var n = 0
        var j = i
        while(n < numberOfWords && j + lengthOfSingleWord <= s.length) {
            val candidateWord = s.substring(j, j + lengthOfSingleWord)
            if (!wordsFreq.contains(candidateWord))
                return false

            candidateFreq[candidateWord] = candidateFreq.getOrDefault(candidateWord, 0) + 1
            j += lengthOfSingleWord
            n++
        }


        return mapEquals(candidateFreq, wordsFreq)
    }

    private fun mapEquals(m1: Map<String, Int>, m2: Map<String, Int>): Boolean {
        if (m1.keys != m2.keys)
            return false
        return m1.keys.all { m1[it] == m2[it] }
    }

    private data class Input(val s: String, val words: Array<String>)
}
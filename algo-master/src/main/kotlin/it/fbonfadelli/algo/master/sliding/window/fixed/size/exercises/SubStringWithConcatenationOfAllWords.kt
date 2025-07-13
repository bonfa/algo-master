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
                Input("lingmindraboofooowingdingbarrwingmonkeypoundcake", arrayOf("fooo","barr","wing","ding","wing")),
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
        val wordsMap = createWordsMap(words)
        val wl = words[0].length
        val ws = words.size
        val k = wl * ws

        val indexes = mutableListOf<Int>()

        var i = 0
        while(i + k <= s.length) {
            if (startsConcatenatedString(i, wl, ws, wordsMap, s)) {
                indexes.add(i)
            }
            i++
        }

        return indexes
    }

    private fun createWordsMap(words: Array<String>): Map<String, Int> {
        val map = mutableMapOf<String, Int>()

        for (word in words) {
            map[word] = map.getOrDefault(word, 0) + 1
        }

        return map
    }

    private fun startsConcatenatedString(
        startIdx: Int,
        wl: Int,
        ws: Int,
        wordsMap: Map<String, Int>,
        s: String
    ): Boolean {
        var i = startIdx
        val sMap = mutableMapOf<String, Int>()
        while (i < startIdx + wl * ws) {
            val sWord = s.substring(i, i + wl)
            if (!wordsMap.containsKey(sWord)) {
                return false
            } else { //wordsMap contains sword
                sMap[sWord] = sMap.getOrDefault(sWord, 0) + 1
                if (sMap[sWord]!! > wordsMap[sWord]!!) {
                    return false
                }
            }
            i += wl
        }
        return true
    }

    private data class Input(val s: String, val words: Array<String>)
}
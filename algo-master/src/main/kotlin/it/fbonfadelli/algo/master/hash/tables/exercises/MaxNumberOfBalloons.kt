package it.fbonfadelli.algo.master.hash.tables.exercises

class MaxNumberOfBalloons {

    companion object {
        private val maxNumberOfBalloons = MaxNumberOfBalloons()

        fun main() {
            println("MAX NUMBER OF BALLOONS")

            val inputs = listOf(
                "nlaebolko",
                "loonbalxballpoon",
                "leetcode",
                "lloo"
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: String) {
            println("CASE ${index+1}:")
            println("Input: '$input'")
            val output = maxNumberOfBalloons.maxNumberOfBalloons(input)
            println("Output: $output")
            println()
        }
    }

    private val balloonChars = "balon".toCharArray().toSet()

    fun maxNumberOfBalloons(text: String): Int {
        return withArray(text)
    }

    private fun withArray(text: String): Int {
        val frequencies = IntArray(5)

        for (i in text.indices) {
            when(text[i]) {
                'b' -> frequencies[0]++
                'a' -> frequencies[1]++
                'l' -> frequencies[2]++
                'o' -> frequencies[3]++
                'n' -> frequencies[4]++
            }
        }

        frequencies[2] = frequencies[2] / 2
        frequencies[3] = frequencies[3] / 2
        return frequencies.min()
    }

    private fun withMap(text: String): Int {
        val charCounts = mutableMapOf<Char, Int>()
        balloonChars.forEach { c -> charCounts.put(c, 0) }

        for (c in text) {
            if (c in balloonChars) {
                charCounts[c] = charCounts[c]!! + 1
            }
        }

        if (charCounts['l'] != null)
            charCounts['l'] = charCounts['l']!! / 2

        if (charCounts['o'] != null)
            charCounts['o'] = charCounts['o']!! / 2

        return charCounts.values.min()
    }
}
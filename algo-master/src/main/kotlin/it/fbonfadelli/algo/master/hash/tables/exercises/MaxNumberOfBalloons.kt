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
            val output = maxNumberOfBalloons.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(text: String): Int {
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
}
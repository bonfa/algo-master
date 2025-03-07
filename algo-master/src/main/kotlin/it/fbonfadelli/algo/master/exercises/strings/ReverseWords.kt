package it.fbonfadelli.algo.master.exercises.strings

class ReverseWords {

    companion object {
        private val reverseWords = ReverseWords()

        fun main() {
            println("REVERSE WORDS")

            val inputs = listOf(
                Input("the sky is blue"),
                Input("  hello world  "),
                Input("a good   example"),
                Input("  a  b  "),
                Input("EPY2giL"),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = reverseWords.reverseWords(input.str)
            println("Output: $output")
            println()
        }
    }

    fun reverseWords(s: String): String {
        var word = ""
        var reversed = ""
        for (i in 0..s.length-1) {
            if (s[i] == ' ') {
                if (word.isNotBlank()) {
                    if (reversed.isBlank()) {
                        reversed = word
                    } else {
                        reversed = word + " " + reversed
                    }

                    word = ""
                }
            } else {
                word = word + s[i]
            }
        }

        if (word.isNotBlank()) {
            if (reversed.isBlank()) {
                reversed = word
            } else {
                reversed = word + " " + reversed
            }
        }

        return reversed
    }

    private fun  withBuiltInFunctions(s: String): String {
        val words: List<String> = s.split(" ")

        val notEmpty = words.filterNot { it.isBlank() }

        val stringBuilder = StringBuilder()
        for (i in (notEmpty.size - 1).downTo(0)) {
            stringBuilder.append(notEmpty[i])
            if (i != 0) {
                stringBuilder.append(" ")
            }
        }

        return stringBuilder.toString()
    }

    private data class Input(val str: String)
}
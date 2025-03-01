package it.fbonfadelli.strings

class LongestCommonPrefix {

    companion object {
        private val longestCommonPrefix = LongestCommonPrefix()

        fun main() {
            println("LONGEST COMMON PREFIX")

            val inputs = listOf(
                Input(arrayOf("flower","flow","flight")),
                Input(arrayOf("dog","racecar","car")),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = longestCommonPrefix.longestCommonPrefix(input.strs)
            println("Output: $output")
            println()
        }
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = ""

        val minLength = strs.map { it.length }.min()

        var i = 0
        while(true) {
            if (i >= minLength)
                break

            val allCharsAtI = strs.map { it[i] }.toSet()

            if (allCharsAtI.size != 1)
                break

            prefix = prefix + allCharsAtI.first()

            i++
        }

        return prefix
    }

    private class Input(val strs: Array<String>) {
        override fun toString(): String {
            return "Input(strs=${strs.contentToString()})"
        }
    }
}
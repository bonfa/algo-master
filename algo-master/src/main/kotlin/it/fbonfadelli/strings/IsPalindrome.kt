package it.fbonfadelli.strings

class IsPalindrome {

    companion object {
        private val isPalindrome = IsPalindrome()

        fun main() {
            println("IS SUBSEQUENCE")

            val inputs = listOf(
                Input("A man, a plan, a canal: Panama"),
                Input("race a car"),
                Input(" "),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: " + "s=${input.s}")
            val output = isPalindrome.isPalindrome(input.s)
            println("Output: $output")
            println()
        }
    }

    fun isPalindrome(s: String): Boolean {
        var sanitized = s.toLowerCase().filter { ch -> ch in 'a'..'z' || ch in '0'..'9' }

        val length = sanitized.length

        if (length == 0)
            return true

        val even = length % 2 == 0
        for(i in 0..(if (even) length/2 else (length/2-1)))
        {
            if (sanitized[i] != sanitized[length - 1 - i])
                return false
        }

        return true
    }

    private data class Input(val s: String)
}
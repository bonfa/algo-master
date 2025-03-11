package it.fbonfadelli.algo.master.exercises.strings

class ValidPalindrome {

    companion object {
        private val validPalindrome = ValidPalindrome()

        fun main() {
            println("VALID PALINDROME")

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
            val output = validPalindrome.isPalindrome(input.s)
            println("Output: $output")
            println()
        }
    }

    fun isPalindrome(s: String): Boolean {
        return version2(s)
    }

    private fun version2(s: String): Boolean {
        if (s.length == 1)
            return true

        var i = 0
        var j = s.length - 1

        while (i < j) {
            if (s[i].isAlphanumeric() && s[j].isAlphanumeric()) {
                if (s[i].lowercase() != s[j].lowercase())
                    return false
                else {
                    i++
                    j--
                }
            } else {
                if (s[i].isAlphanumeric().not()) {
                    i++
                }

                if (s[j].isAlphanumeric().not()) {
                    j--
                }
            }
        }

        return true
    }

    private fun Char.isAlphanumeric(): Boolean =
        (this >= '0' && this <= '9') || (this>='a' && this <='z') || (this>='A' && this <='Z')

    fun version1(s: String): Boolean {
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
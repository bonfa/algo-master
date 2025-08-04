package it.fbonfadelli.algo.master.stack.exercises

class ValidParentheses {

    companion object {
        private val validParentheses = ValidParentheses()

        fun main() {
            println("VALID PARENTHESES")

            val inputs = listOf(
                "()",
                "()[]{}",
                "(]",
                "([])",
                "([)]",
                "]",
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: String) {
            println("CASE ${index+1}:")
            println("Input: " + "s=${input}")
            val output = validParentheses.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String): Boolean {
        val stack = mutableListOf<Char>()
        for (c in s) {
            when (c) {
                ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
                ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
                '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
                else -> stack.add(c)
            }
        }

        return stack.isEmpty()
    }

}
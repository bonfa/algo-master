package it.fbonfadelli.algo.master.stack.generic.exercises

class RemovingStarsFromAString {

    companion object {
        private val removingStarsFromAString = RemovingStarsFromAString()

        fun main() {
            println("REMOVING STARS FROM A STRING")

            val inputs = listOf(
                "leet**cod*e",
                "erase*****",
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: String) {
            println("CASE ${index+1}:")
            println("Input: " + "s='${input}'")
            val output = removingStarsFromAString.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String): String {
        val builder = StringBuilder()
        var i = 0
        while(i < s.length) {
            val c = s[i]
            if (c == '*') {
                builder.deleteAt(builder.length - 1)
                //do not add c to the stack
            } else {
                builder.append(c)
            }
            i++
        }
        return builder.toString()
    }

}
package it.fbonfadelli.algo.master.stack.generic.exercises

import kotlin.text.iterator

class RemoveAllAdjacentDuplicatesInString {

    companion object {
        private val removeAllAdjacentDuplicatesInString = RemoveAllAdjacentDuplicatesInString()

        fun main() {
            println("REMOVE ALL ADJACENT DUPLICATES IN STRING")

            val inputs = listOf(
                "abbaca",
                "azxxzy",
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: String) {
            println("CASE ${index+1}:")
            println("Input: " + "s='${input}'")
            val output = removeAllAdjacentDuplicatesInString.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String): String {
        val stack = mutableListOf<Char>()
        for (c in s) {
            if (stack.isNotEmpty() && stack.last() == c) {
                stack.removeLast()
                //do not add c
            } else {
                stack.add(c)
            }
        }

        val stringBuilder = StringBuilder()
        for (c in stack) {
            stringBuilder.append(c)
        }
        return stringBuilder.toString()
    }

}
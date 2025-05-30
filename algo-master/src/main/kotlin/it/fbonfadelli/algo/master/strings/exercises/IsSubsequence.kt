package it.fbonfadelli.algo.master.strings.exercises

class IsSubsequence {

    companion object {
        private val isSubsequence = IsSubsequence()

        fun main() {
            println("IS SUBSEQUENCE")

            val inputs = listOf(
                Input("abc", "ahbgdc"),
                Input("axc", "ahbgdc"),
                Input("", ""),
                Input("", "abc"),
                Input("b", ""),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: " + "s=${input.s} " + " t=${input.t}")
            val output = isSubsequence.isSubsequence(input.s, input.t)
            println("Output: $output")
            println()
        }
    }


    fun isSubsequence(s: String, t: String): Boolean {
        return version2(s, t)
    }

    private fun version2(s: String, t: String): Boolean {
        if (s.length == 0)
            return true
        if (s.length > t.length)
            return false
        if (s.length == t.length)
            return s == t

        // s.length < t.length

        var tIdx = 0
        var sIdx = 0
        while (tIdx < t.length) {
            if (s[sIdx] == t[tIdx])
                sIdx++

            tIdx++

            if (sIdx >= s.length)
                return true
        }

        return false
    }

    private fun version1(s: String, t: String): Boolean {
        if (s.length == 0)
            return true

        if (t.length == 0)
            return false

        var sIndex = 0
        var tIndex = 0
        while (true) {
            if (s[sIndex] == t[tIndex]) {
                sIndex++
            }

            tIndex++

            if (sIndex >= s.length)
                return true

            if (tIndex >= t.length)
                return false
        }

        return false
    }

    private data class Input(val s: String, val t: String)
}
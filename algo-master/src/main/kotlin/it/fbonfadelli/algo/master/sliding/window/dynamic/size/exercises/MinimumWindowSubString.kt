package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

class MinimumWindowSubString {

    companion object {
        private val minimumWindowSubString = MinimumWindowSubString()

        fun main() {
            println("MINIMUM WINDOW SUB STRING")

            val inputs = listOf(
                Input("ADOBECODEBANC", "ABC"),
                Input("a", "a"),
                Input("a", "aa"),
                Input("cabwefgewcwaefgcf", "cae"),
                Input("CWAEFG", "CAE"),
                Input("baBBba", "aB"),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = minimumWindowSubString.execute(input.s, input.t)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String, t: String): String {
        val tMap = map(t)

        var l = 0
        var r = 0
        var minIdx = -1
        var minLength = Integer.MAX_VALUE

        val sMap = IntArray(58)
        while(r < s.length) {
            val rc = s[r]
            sMap[rc - 'A']++

            while(canShrink(sMap, tMap)) {
                val currentLength = r + 1 - l
                if (currentLength < minLength) {
                    minIdx = l
                    minLength = currentLength
                }

                val lc = s[l]
                sMap[lc - 'A']--
                l++
            }

            r++
        }

        return if (minIdx == -1) "" else s.substring(minIdx, minIdx + minLength)
    }


    private fun map(t: String): IntArray {
        val map = IntArray(58)

        for (tc in t) {
            map[tc - 'A']++
        }

        return map
    }

    private fun canShrink(sMap: IntArray, tMap: IntArray): Boolean {
        for (i in 0 until tMap.size) {
            if (sMap[i] < tMap[i])
                return false
        }
        return true
    }


    private data class Input(val s: String, val t: String)
}
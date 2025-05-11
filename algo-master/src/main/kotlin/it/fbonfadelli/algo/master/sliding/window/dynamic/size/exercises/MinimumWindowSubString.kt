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
        val tMap = charMap(t)
        val tLength = t.length

        var l = 0
        var r = 0
        var minLength = Integer.MAX_VALUE
        var minSubString = ""
        val sMap = IntArray(52)
        while(r < s.length) {
            val toAdd = s[r]

            if (toAdd in 'A'..'Z')
                sMap[toAdd - 'A']++
            else
                sMap[toAdd.code + 1 - 'a'.code + 'Z'.code - 'A'.code]++

            //compression
            while(r - l + 1 >= tLength && contains(sMap, tMap)) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1
                    minSubString = s.substring(l, r + 1)
                }
                val toRemove = s[l]
                if (toRemove in 'A'..'Z')
                    sMap[toRemove - 'A']--
                else
                    sMap[toRemove.code + 1 - 'a'.code + 'Z'.code - 'A'.code]--


                l++
            }

            r++
        }

        return minSubString
    }

    private fun charMap(str: String): IntArray {
        val map = IntArray(52)
        for(c in str) {
            if (c in 'A'..'Z')
                map[c - 'A']++
            else
                map[c.code + 1 - 'a'.code + 'Z'.code - 'A'.code]++
        }
        return map
    }

    private fun contains(container: IntArray, contained: IntArray): Boolean {
        var i = 0
        while (i < container.size) {
            if (container[i] < contained[i])
                return false
            i++
        }

        return true
    }


    private data class Input(val s: String, val t: String)
}
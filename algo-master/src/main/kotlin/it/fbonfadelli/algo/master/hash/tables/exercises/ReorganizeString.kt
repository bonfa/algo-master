package it.fbonfadelli.algo.master.hash.tables.exercises

class ReorganizeString {

    companion object {
        private val reorganizeString = ReorganizeString()

        fun main() {
            println("REORGANIZE STRING")

            val inputs = listOf(
                "aab",
                "aaab",
                "a",
                "ababababa",
                "aabbcc",
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: String) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = reorganizeString.reorganizeString(input)
            println("Output: $output")
            println()
        }
    }

    fun reorganizeString(s: String): String {
        //fill map
        val charMap: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
        for (c in s) {
            if (charMap[c] == null)
                charMap[c] = 1
            else
                charMap[c] = charMap[c]!! + 1
        }

        // failure
        if (charMap.entries.any { (_,v) -> numberIsBiggerThan(v, s.length) })
            return ""

        // build output
        val output = CharArray(s.length)
        var j = 0
        charMap.entries
            .sortedByDescending { (_,v) -> v}
            .forEach { (char, count) ->
                var charCount = count
                while(charCount > 0) {
                    if (output[j] == 0.toChar()) {
                        output[j] = char
                        charCount--
                        if (charCount == 0)
                            j = (j+1) % s.length
                        else
                            j = (j+2) % s.length
                    } else {
                        for (k in 0..s.length-1) {
                            if (output[k] == 0.toChar()) {
                                j = k
                                break
                            }
                        }
                    }
                }
            }
        return output.joinToString("")
    }

    private fun numberIsBiggerThan(num: Int, length: Int): Boolean {
        return if (length % 2 == 0)
            num >= length / 2 + 1
        else
            num > (length + 1) / 2
    }
}
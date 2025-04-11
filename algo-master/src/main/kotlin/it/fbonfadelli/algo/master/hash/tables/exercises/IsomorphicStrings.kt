package it.fbonfadelli.algo.master.hash.tables.exercises

class IsomorphicStrings {

    companion object {
        private val isomorphicStrings = IsomorphicStrings()

        fun main() {
            println("ISOMORPHIC STRINGS")

            val inputs = listOf(
                Input("egg", "add"),
                Input("foo", "bar"),
                Input("paper", "title"),
                Input("bar", "foo"),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = isomorphicStrings.isIsomorphic(input.s, input.t)
            println("Output: $output")
            println()
        }
    }

    fun isIsomorphic(s: String, t: String): Boolean {
        return withArrays(s, t)
    }


    private fun withArrays(s: String, t: String): Boolean {
        val sToTMap = CharArray(128)
        val tToSMap = CharArray(128)

        for(i in s.indices){
            val sc = s[i]
            val tc = t[i]

            if (sToTMap[sc.code] == '\u0000')
                sToTMap[sc.code] = tc
            else if (sToTMap[sc.code] != tc)
                return false

            if (tToSMap[tc.code] == '\u0000')
                tToSMap[tc.code] = sc
            else if (tToSMap[tc.code] != sc)
                return false
        }

        return true
    }

    private fun withMap(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>()

        for (i in 0..s.length - 1) {
            val sc = s[i]
            val st = t[i]

            if (map[sc] == null) {
                map[sc] = st
            } else {
                if (map[sc] != st)
                    return false
            }
        }

        return map.values.toSet().size == map.keys.size
    }

    private data class Input(val s:String, val t:String)
}
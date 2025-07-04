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
            val output = isomorphicStrings.execute(input.s, input.t)
            println("Output: $output")
            println()
        }
    }

    fun execute(s: String, t: String): Boolean {
        if (s.length != t.length)
            return false

        val sToT = IntArray(128)
        val tToS = IntArray(128)
        for (i in s.indices) {
            val sc = s[i].code
            val tc = t[i].code

            when {
                sToT[sc] != 0 && sToT[sc] != tc -> return false
                tToS[tc] != 0 && tToS[tc] != sc -> return false
                else -> {
                    sToT[sc] = tc
                    tToS[tc] = sc
                }
            }
        }

        return true
    }

    private data class Input(val s:String, val t:String)
}
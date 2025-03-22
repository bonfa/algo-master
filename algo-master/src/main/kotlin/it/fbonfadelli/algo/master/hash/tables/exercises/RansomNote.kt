package it.fbonfadelli.algo.master.hash.tables.exercises

class RansomNote {

    companion object {
        private val ransomNote = RansomNote()

        fun main() {
            println("RANSOM NOTE")

            val inputs = listOf(
                Input("a", "b"),
                Input("aa", "ab"),
                Input("aa", "aab"),
                Input("a", "ba"),
                Input("aba", "cxzbaaa"),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = ransomNote.canConstruct(input.ransomNote, input.magazine)
            println("Output: $output")
            println()
        }
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val availability: MutableMap<Char, Int> = mutableMapOf()
        magazine.forEach { char ->
            if (availability[char] == null)
                availability[char] = 1
            else {
                availability[char] = availability[char]!! + 1
            }
        }

        ransomNote.forEach { char ->
            if (availability[char] == null || availability[char] == 0)
                return false
            else {
                availability[char] = availability[char]!! - 1
            }
        }

        return true
    }

    private data class Input(val ransomNote:String, val magazine:String)
}
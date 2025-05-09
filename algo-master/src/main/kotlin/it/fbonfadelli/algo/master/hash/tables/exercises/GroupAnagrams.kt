package it.fbonfadelli.algo.master.hash.tables.exercises

import it.fbonfadelli.algo.master.utils.printable

class GroupAnagrams {

    companion object {
        private val groupAnagrams = GroupAnagrams()

        fun main() {
            println("GROUP ANAGRAMS")

            val inputs = listOf(
                arrayOf("eat","tea","tan","ate","nat","bat"),
                arrayOf(""),
                arrayOf("a"),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Array<String>) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = groupAnagrams.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(strs: Array<String>): List<List<String>> {
        val map: MutableMap<String, MutableList<String>> = mutableMapOf()
        for (str in strs) {
            val f = freq(str)
            if (map.containsKey(f)) {
                map[f]!!.add(str)
            } else {
                map[f] = mutableListOf(str)
            }
        }
        return map.values.toList()
    }

    private fun freq(str:String): String {
        val freq = IntArray(26)

        for (i in str.indices) {
            freq[str[i]-'a']++
        }

        val builder = StringBuilder()
        for (i in 0 until freq.size) {
            if (freq[i] > 0) {
                builder.append((i + 'a'.code).toChar())
                builder.append(freq[i])
                builder.append("#")
            }
        }

        return builder.toString()
    }
}
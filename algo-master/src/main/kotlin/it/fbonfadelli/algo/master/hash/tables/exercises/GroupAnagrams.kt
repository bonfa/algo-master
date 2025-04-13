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
            val output = groupAnagrams.groupAnagrams(input)
            println("Output: $output")
            println()
        }
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return version2(strs)
    }

    fun version2(strs: Array<String>): List<List<String>> {
        val charFrequencies = mutableMapOf<List<Int>, MutableList<String>>()
        strs.forEach { str ->
            val charFrequency = charFrequency(str)
            if (charFrequencies.containsKey(charFrequency)) {
                charFrequencies[charFrequency]!!.add(str)
            } else {
                charFrequencies[charFrequency] = mutableListOf(str)
            }
        }

        return charFrequencies.values.map { it.toList() }
    }

    private fun charFrequency(str: String): List<Int> {
        val frequencies = IntArray(26)
        for (i in str.indices) {
            frequencies[str[i]-'a']++
        }
        return frequencies.toList()
    }

    private fun version1(strs: Array<String>): List<List<String>> {
        val map: MutableMap<CharacterMap, MutableList<String>> = mutableMapOf()

        for (str in strs) {
            val charMap = str.characterMap()
            if (map[charMap] == null) {
                map[charMap] = mutableListOf(str)
            } else {
                map[charMap]!!.add(str)
            }
        }

        return map.values.map { it.toList() }
    }

    private fun String.characterMap(): CharacterMap {
        val map: MutableMap<Char, Int> = mutableMapOf()
        for (i in 0..this.length-1) {
            val char = this[i]
            if (map[char] == null)
                map[char] = 1
            else
                map[char] = map[char]!! + 1
        }
        return CharacterMap(map)
    }

    @JvmInline
    private value class CharacterMap(val value: Map<Char, Int>)
}
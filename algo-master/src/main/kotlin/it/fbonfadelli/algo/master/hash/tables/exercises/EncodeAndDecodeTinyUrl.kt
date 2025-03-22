package it.fbonfadelli.algo.master.hash.tables.exercises

import java.util.Random

class EncodeAndDecodeTinyUrl {

    companion object {
        private val codec = Codec()

        fun main() {
            println("ENCODE AND DECODE TINY URL")

            val inputs = listOf(
                "https://leetcode.com/problems/design-tinyurl"
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: String) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val encoded = codec.encode(input)
            val decoded = codec.decode(encoded)
            println("Output: $decoded")
            println()
        }
    }

    private class Codec {
        private val map: MutableMap<String, String> = mutableMapOf()

        fun encode(longUrl: String): String {
            var entered = false
            var key: String
            do {
                key = generateKey()
                if (map[key] == null) {
                    map.put(key, longUrl)
                    entered = true
                }

            } while (entered == false)

            return "http://tinyurl.com/" + key
        }

        fun decode(shortUrl: String): String {
            val key = shortUrl.drop(19)
            return map[key] ?: "ERROR"
        }

        private fun generateKey(): String {
            val random = Random(128)
            val keyBuilder = StringBuilder()
            for (i in 0..5) {
                keyBuilder.append(random.nextInt().toChar())
            }

            return keyBuilder.toString()
        }
    }
}
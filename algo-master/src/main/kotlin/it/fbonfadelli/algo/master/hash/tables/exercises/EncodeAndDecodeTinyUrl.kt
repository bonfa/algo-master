package it.fbonfadelli.algo.master.hash.tables.exercises

import java.util.Random

class EncodeAndDecodeTinyUrl {

    companion object {
        private val codec = CodecV2()

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

    private class CodecV2 {
        private val BASE = "http://tinyurl.com/"
        private val CHARS = "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz1234567890"
        private val urlMap = mutableMapOf<String, String>()

        // Encodes a URL to a shortened URL.
        fun encode(longUrl: String): String {
            val key = randomStringOfLengthSix()
            urlMap[key] = longUrl
            return BASE + key
        }

        // Decodes a shortened URL to its original URL.
        fun decode(shortUrl: String): String {
            return urlMap[shortUrl.drop(BASE.length)]!!
        }

        private fun randomStringOfLengthSix(): String {
            val builder = StringBuilder()
            for (i in 0 until 6) {
                builder.append(CHARS.random())
            }
            return builder.toString()
        }
    }

    private class CodecV1 {
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
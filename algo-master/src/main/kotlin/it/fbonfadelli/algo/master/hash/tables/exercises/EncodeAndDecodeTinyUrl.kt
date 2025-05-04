package it.fbonfadelli.algo.master.hash.tables.exercises

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

    class Codec() {

        private val map: MutableMap<String, String> = mutableMapOf()

        fun encode(longUrl: String): String {
            var key = createRandomString()
            while(map.containsKey(key)) {
                key = createRandomString()
            }

            map[key] = longUrl
            return "$TINY_URL_PREFIX$key"
        }

        fun decode(shortUrl: String): String {
            val key = shortUrl.removePrefix(TINY_URL_PREFIX)
            return map[key]!!
        }

        private fun createRandomString(): String {
            val builder = StringBuilder()

            var i = 0
            while (i < KEY_SIZE) {
                builder.append(ALPHABET.random())
                i++
            }

            return builder.toString()
        }

        companion object {
            private const val TINY_URL_PREFIX = "http://tinyurl.com/"
            private const val ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
            private const val KEY_SIZE = 6
        }
    }
}
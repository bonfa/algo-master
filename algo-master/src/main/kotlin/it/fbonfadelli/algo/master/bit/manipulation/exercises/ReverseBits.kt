package it.fbonfadelli.algo.master.bit.manipulation.exercises

class ReverseBits {
    companion object {
        private val reverseBits = ReverseBits()

        fun main() {
            println("REVERSE BITS")

            val inputs: List<UInt> = listOf(
                0b00000010_10010100_00011110_10011100u,
                0b11111111_11111111_11111111_11111101u,
                0b00000000_00000000_00000000_00000101u,
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: UInt) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = reverseBits.reverseBits(input)
            println("Output: ${output}")
            println()
        }
    }

    fun reverseBits(n:UInt):UInt { //different from Leet-code as the signature there is Int and not UInt
        var uN = n.toUInt()
        var reversed: UInt = 0u

        for(i in 0 until 32) {
            val leastSignificantBit = uN and 1u
            reversed += leastSignificantBit
            if (i < 31) {
                reversed = reversed shl 1
            }
            uN = uN shr 1
        }

        return reversed
    }
}
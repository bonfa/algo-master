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
        return version2(n)
    }

    private fun version2(n: UInt): UInt {
        var num: UInt = n.toUInt()
        var res: UInt = 0u

        for(i in 0..31) {

            val leastSignificantBit = num and 1u

            num = num shr 1

            if (leastSignificantBit == 1u)
                res = res + (leastSignificantBit shl 31-i)
        }

        return res
    }

    private fun version1(n: UInt): UInt {
        val arr = UIntArray(32)
        var num: UInt = n
        for (i in 0..31) {
            arr[31 - i] = num and 1u
            num = num shr 1
        }

        var reversed: UInt = 0u
        for (i in 0..31) {
            if (arr[i] == 1u) {
                val incr: UInt = 1u shl i
                reversed = reversed + incr
            }
        }

        return reversed
    }
}
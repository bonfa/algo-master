package it.fbonfadelli.algo.master.exercises.bits

class BitwiseAndOfRange {
    companion object {
        private val bitwiseAndOfRange = BitwiseAndOfRange()

        fun main() {
            println("BITWISE_AND_OF_RANGE")

            val inputs: List<Input> = listOf(
                Input(0,0),
                Input(1,2),
                Input(1,2147483647),
                Input(3,4),
                Input(5,5),
                Input(5,7),
                Input(6,7),
                Input(12,14),
                Input(2147483646,2147483647),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = bitwiseAndOfRange.rangeBitwiseAnd(input.min, input.max)
            println("Output: $output")
            println()
        }
    }

    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        if (left == right)
            return left

        var num = 0u
        var myLeft = left.toUInt()
        var myRight = right.toUInt()
        while(true) {
            val mostSignificantBitInLeft: UInt = mostSignificantBitIn(myLeft.toUInt())
            val mostSignificantBitInRight: UInt = mostSignificantBitIn(myRight.toUInt())

            if (mostSignificantBitInRight == mostSignificantBitInLeft) {
                num = num + mostSignificantBitInLeft
                myLeft = myLeft - mostSignificantBitInLeft
                myRight = myRight - mostSignificantBitInRight
            } else {
                break
            }
        }

        return num.toInt()
    }

    private fun mostSignificantBitIn(num:UInt): UInt {
        if (num == 0u)
            return 0u

        var msb = 1u
        while ((msb shl 1) <= num) {
            msb = msb shl 1
        }

        return msb
    }

    private data class Input(val min:Int, val max:Int)
}
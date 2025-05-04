package it.fbonfadelli.algo.master.bit.manipulation.exercises

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
        var uLeft = left
        var uRight = right

        var shiftCount = 0
        while(uRight != 0 && uRight != uLeft) {
            uLeft = uLeft shr 1
            uRight = uRight shr 1
            shiftCount++
        }

        return uRight shl shiftCount
    }

    private data class Input(val min:Int, val max:Int)
}
package it.fbonfadelli.algo.master.linked.list.fast.slow.pointers.exercises

class HappyNumber {

    companion object {
        private val happyNumber = HappyNumber()

        fun main() {
            println("HAPPY NUMBER")

            val inputs = listOf(
                19,
                2
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Int) {
            println("CASE ${index + 1}:")
            println("Input: $input")
            val output = happyNumber.execute(input)
            println("Output: $output")
            println()
        }
    }

    private fun execute(n: Int): Boolean {
        val encounteredSumOfSquares = mutableSetOf<Int>()
        var num = n
        do {
            num = getNext(num)

            if (num == 1) {
                return true
            } else if (encounteredSumOfSquares.contains(num)) {
                return false
            }

            encounteredSumOfSquares.add(num)

        } while(true)
    }

    private fun getNext(n:Int): Int {
        if (n == 0)
            return 0

        var tot = 0
        var num = n
        while(num > 0) {
            val digit = num % 10
            tot += digit * digit
            num = num / 10
        }
        return tot
    }
}
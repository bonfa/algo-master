package it.fbonfadelli.algo.master.custom.exercises

class BinarySearchEvolved {

    companion object {
        private val binarySearch = BinarySearchEvolved()

        fun main() {
            println("BINARY SEARCH - EVOLVED")

            val inputs = listOf(
                Input(intArrayOf(1,2,3,4,5,6,7), 4),
                Input(intArrayOf(1,2,3,5,6,7), 4),
                Input(intArrayOf(), 4),
                Input(intArrayOf(3), 4),
                Input(intArrayOf(4), 4),
                Input(intArrayOf(5), 4),
                Input(intArrayOf(4,5,6,7), 4),
                Input(intArrayOf(1,2,3,4), 4),
                Input(intArrayOf(5,6,7), 4),
                Input(intArrayOf(1,2,3), 4),
            )

            inputs.forEachIndexed { index, probl -> execute(index, probl) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = binarySearch.binarySearch(input.array, input.target)
            println("Output: $output")
            println("Expected output: ${javaUtilBinarySearchResponse(input)}")
            println()
        }

        private fun javaUtilBinarySearchResponse(input: Input): Int =
            java.util.Collections.binarySearch(input.array.toList(), input.target).let {
                if (it < 0)
                    -it-1
                else
                    it
            }
    }

    fun binarySearch(array: IntArray, target: Int): Int {
        if (array.isEmpty())
            return 0

        var min = 0
        var max = array.size - 1

        while(min <= max) {
            val middle = (max + min) / 2
            when {
                array[middle] == target -> return middle
                array[middle] < target -> min = middle + 1
                array[middle] > target -> max = middle - 1
            }
        }

        return min
    }

    private data class Input(val array: IntArray, val target:Int)
}
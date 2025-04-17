package it.fbonfadelli.algo.master.custom.exercises

class BinarySearchSimple {

    companion object {
        private val binarySearch = BinarySearchSimple()

        fun main() {
            println("BINARY SEARCH - SIMPLE VERSION")

            val inputs = listOf(
                Problem(Input(intArrayOf(1,2,3,4,5,6,7), 4),3),
                Problem(Input(intArrayOf(1,2,3,5,6,7), 4),-1),
                Problem(Input(intArrayOf(), 4),-1),
                Problem(Input(intArrayOf(3), 4),-1),
                Problem(Input(intArrayOf(4), 4),0),
                Problem(Input(intArrayOf(5), 4),-1),
                Problem(Input(intArrayOf(4,5,6,7), 4),0),
                Problem(Input(intArrayOf(1,2,3,4), 4),3),
                Problem(Input(intArrayOf(5,6,7), 4),-1),
                Problem(Input(intArrayOf(1,2,3), 4),-1),
            )

            inputs.forEachIndexed { index, probl -> execute(index, probl) }
        }

        private fun execute(index: Int, problem: Problem) {
            println("CASE ${index+1}:")
            println("Input: ${problem.input}")
            val output = binarySearch.binarySearch(problem.input.array, problem.input.target)
            println("Output: $output")
            println("Expected output: ${problem.expectedOutput}")
            println()
        }
    }

    fun binarySearch(array: IntArray, target: Int): Int {
        if (array.isEmpty())
            return -1

        var min = 0
        var max = array.size

        while(min < max) {
            val middle = (max + min) / 2
            when {
                array[middle] == target -> return middle
                array[middle] < target -> min = middle + 1
                array[middle] > target -> max = middle
            }
        }

        return -1
    }

    private data class Problem(val input: Input, val expectedOutput: Int)

    private data class Input(val array: IntArray, val target:Int)
}
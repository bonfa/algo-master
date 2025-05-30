package it.fbonfadelli.algo.master.hash.tables.exercises

class ContainsDuplicateII {

    companion object {
        private val containsDuplicateII = ContainsDuplicateII()

        fun main() {
            println("CONTAINS DUPLICATE II")

            val inputs = listOf(
                Input(intArrayOf(1,2,3,1), 3),
                Input(intArrayOf(1,0,1,1), 1),
                Input(intArrayOf(1,2,3,1,2,3), 2),
                Input(intArrayOf(1,0,1,1), 2),
                Input(intArrayOf(1,0,1,1), 0),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val output = containsDuplicateII.execute(input.nums, input.k)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums: IntArray, k: Int): Boolean {
        val numsLastIndex = mutableMapOf<Int, Int>()

        nums.forEachIndexed { index, num ->
            if (numsLastIndex.containsKey(num)) {
                if (index - numsLastIndex[num]!! <= k)
                    return true
                else
                    numsLastIndex[num] = index
            } else {
                numsLastIndex[num] = index
            }
        }

        return false
    }

    private data class Input(val nums: IntArray, val k: Int)
}
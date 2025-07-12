package it.fbonfadelli.algo.master.two.pointers.exercises

import it.fbonfadelli.algo.master.utils.printable

class ContainerWithMostWater {

    companion object {
        private val containerWithMostWater = ContainerWithMostWater()

        fun main() {
            println("CONTAINER WITH MOST WATER")

            val inputs = listOf(
                intArrayOf(1,8,6,2,5,4,8,3,7),
                intArrayOf(1,1),
                intArrayOf(7,8,6,2,5,4,8,3,1),
                intArrayOf(1,3,2,5,25,24,5),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = containerWithMostWater.execute(input)
            println("Output: $output")
            println()
        }
    }

    fun execute(height: IntArray): Int {
        var maxArea = 0
        var low = 0
        var high = height.size - 1

        while (low < high) {
            maxArea = Math.max(maxArea, (high-low) * Math.min(height[low], height[high]))
            if (height[low] > height[high]) {
                high--
            } else
                low++
        }

        return maxArea
    }
}
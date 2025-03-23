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
            val output = containerWithMostWater.maxArea(input)
            println("Output: $output")
            println()
        }
    }

    fun maxArea(height: IntArray): Int {
        var p1 = 0
        var p2 = height.size - 1
        var maxArea = 0

        while (p1 < p2) {
            maxArea = Math.max(maxArea, (p2-p1) * Math.min(height[p1], height[p2]))

            if (height[p1] < height[p2])
                p1++
            else
                p2--
        }

        return maxArea
    }
}
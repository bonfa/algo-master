package it.fbonfadelli.algo.master.two.pointers.exercises

import it.fbonfadelli.algo.master.utils.printable

class TrappingRainWater {

    companion object {
        private val trappingRainWater = TrappingRainWater()

        fun main() {
            println("TRAPPING RAIN WATER")

            val inputs = listOf(
                intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1),
                intArrayOf(4,2,0,3,2,5),
                intArrayOf(5,4,1,2),
                intArrayOf(5,5,1,7,1,1,5,2,7,6),
                intArrayOf(6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3),
                intArrayOf(0,0,0),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: IntArray) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = trappingRainWater.execute(input)
            println("Output: $output")
            println()
        }
    }

    private val INCREASING = 1
    private val DECREASING = 2
    private val UNKNOWN = 0

    fun execute(height: IntArray): Int {
        if (height.size == 1)
            return 0

        val localMaxes = mutableListOf<Int>()

        var i = 0
        var slope = UNKNOWN
        while(i < height.size - 1) {
            if (height[i + 1] > height[i]) {
                if (slope != INCREASING) {
                    slope = INCREASING
                }
            } else if (height[i + 1] < height[i]) {
                if (slope != DECREASING) {
                    localMaxes.add(i)
                    slope = DECREASING
                }
            }
            i++
        }

        if (slope == INCREASING && height[i] >= height[i-1]) {
            localMaxes.add(i)
        }

        if (localMaxes.size <= 1)
            return 0

        if (localMaxes.size > 2) {
            var j = 0
            while (j < localMaxes.size - 1) {
                val sortedByValue = localMaxes.sortedByDescending { height[it] }
                val first = sortedByValue[j]
                val second = sortedByValue[j+1]
                val min = Math.min(first, second)
                val max = Math.max(first, second)
                val minHeight = Math.min(height[first], height[second])
                localMaxes.removeAll{ it in (min+1) until max && height[it] < minHeight }

                j++
            }
        }


        var area = 0
        var i1 = 0
        var i2 = 1
        do {
            val key1 = localMaxes[i1]
            val key2 = localMaxes[i2]
            val minMax = Math.min(height[key1], height[key2])

            for (i in (key1 + 1) until key2) {
                area += if (height[i] > minMax) 0 else minMax - height[i]
            }
            i1++
            i2++
        } while (i2 < localMaxes.size)

        return area
    }
}
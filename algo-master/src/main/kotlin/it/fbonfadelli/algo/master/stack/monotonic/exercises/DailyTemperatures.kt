package it.fbonfadelli.algo.master.stack.monotonic.exercises

import it.fbonfadelli.algo.master.utils.printable

class DailyTemperatures {

    companion object {
        private val dailyTemperatures = DailyTemperatures()

        fun main() {
            println("DAILY TEMPERATURES")

            val inputs = listOf(
                Input(intArrayOf(73,74,75,71,69,72,76,73)),
                Input(intArrayOf(30,40,50,60)),
                Input(intArrayOf(30,60,90)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: " + "s='${input.temperatures.printable()}'")
            val output = dailyTemperatures.execute(input.temperatures)
            println("Output: ${output.printable()}")
            println()
        }
    }

    fun execute(temperatures: IntArray): IntArray {
        val answers = IntArray(temperatures.size) { 0 }
        val stack = mutableListOf<Int>()
        for (i in 0 until temperatures.size) {
            while(stack.isNotEmpty() && temperatures[stack.last()] < temperatures[i]) {
                val last = stack.removeLast()
                answers[last] = i - last
            }
            stack.add(i)
        }
        return answers
    }

    private data class Input(val temperatures: IntArray)
}
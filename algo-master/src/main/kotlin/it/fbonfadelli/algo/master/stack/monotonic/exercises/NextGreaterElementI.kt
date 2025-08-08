package it.fbonfadelli.algo.master.stack.monotonic.exercises

class NextGreaterElementI {

    companion object {
        private val nextGreaterElementI = NextGreaterElementI()

        fun main() {
            println("NEXT GREATER ELEMENT I")

            val inputs = listOf(
                Input(intArrayOf(4,1,2), intArrayOf(1,3,4,2)),
                Input(intArrayOf(2,4), intArrayOf(1,2,3,4)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: " + "s='${input}'")
            val output = nextGreaterElementI.execute(input.nums1, input.nums2)
            println("Output: $output")
            println()
        }
    }

    fun execute(nums1: IntArray, nums2: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        val nums2GreaterElementByValue = IntArray(10_001) { -1 }

        for (j in 0 until nums2.size) {
            while (stack.isNotEmpty() && nums2[j] > stack.last()) {
                nums2GreaterElementByValue[stack.removeLast()] = nums2[j]
            }
            stack.add(nums2[j])
        }

        for (i in 0 until nums1.size) {
            nums1[i] = nums2GreaterElementByValue[nums1[i]]
        }

        return nums1
    }

    private data class Input(val nums1: IntArray, val nums2: IntArray)
}
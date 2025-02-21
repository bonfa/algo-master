package it.fbonfadelli.arrays

class MajorityElement {

    companion object {
        fun main() {
            val solution = MajorityElement()
            val input1 = intArrayOf(3,2,3)
            val input2 = intArrayOf(2,2,1,1,1,2,2)

            println("MAJORITY ELEMENT")

            println("CASE 1:")
            println("Input: [" + input1.joinToString((",")) + "]")
            val majorityElement1 = solution.majorityElement(input1)
            println("Output: [" + majorityElement1 + "]")

            println()

            println("CASE 2:")
            println("Input: [" + input2.joinToString((",")) + "]")
            val majorityElement2 = solution.majorityElement(input2)
            println("Output: [" + majorityElement2 + "]")
        }
    }

    fun majorityElement(nums: IntArray): Int {
        return boyerMooreVotingAlgorithm(nums)
    }

    private fun boyerMooreVotingAlgorithm(nums: IntArray): Int {
        var candidate = nums[0]
        var count = 1
        for (i in 1..nums.size-1) {
            if (count == 0)
                candidate = nums[i]

            if (nums[i] == candidate)
                count++
            else
                count--
        }

        return candidate
    }

    private fun mapBased(nums: IntArray): Int {
        val counts = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            if (counts[num] == null)
                counts[num] = 1
            else
                counts[num] = counts[num]!! + 1
        }

        val key = counts.entries.maxBy { (k, v) -> v }.key

        return key
    }
}
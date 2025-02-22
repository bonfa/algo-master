package it.fbonfadelli.arrays

class RemoveDuplicates {

    companion object {
        fun main() {
            val removeDuplicates = RemoveDuplicates()
            val input1 = intArrayOf(1,1,2)
            val input2 = intArrayOf(0,0,1,1,1,2,2,3,3,4)

            println("MOVE ZEROES")

            println("CASE 1:")
            println("Input: [" + input1.joinToString((",")) + "]")
            val length1 = removeDuplicates.removeDuplicates(input1)
            println("Output: [" + input1.take(length1).joinToString((",")) + "]")

            println()

            println("CASE 2:")
            println("Input: [" + input2.joinToString((",")) + "]")
            val length2 = removeDuplicates.removeDuplicates(input2)
            println("Output: [" + input2.take(length2).joinToString((",")) + "]")
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        var positionToOverride = 0
        var currentPosition = 1
        while (true) {
            if (currentPosition >= nums.size)
                break

            if (nums[positionToOverride] == nums[currentPosition]) {
                currentPosition++
            } else {
                positionToOverride++
                nums[positionToOverride] = nums[currentPosition]
                currentPosition++
            }
        }

        return positionToOverride+1
    }
}
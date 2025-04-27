package it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises

class MaxConsecutiveOnes3 {

    companion object {
        private val maxConsecutiveOnes3 = MaxConsecutiveOnes3()

        fun main() {
            println("MAX CONSECUTIVE ONES III")

            val inputs = listOf(
                Input(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), 2),
                Input(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1), 3),
                Input(intArrayOf(0,0), 2),
                Input(intArrayOf(0,0,0), 2),
                Input(intArrayOf(1,1), 2),
                Input(intArrayOf(0,0,1,1,1,0,0), 0),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = maxConsecutiveOnes3.longestOnes(input.nums, input.k)
            println("Output: $output")
            println()
        }
    }

    fun longestOnes(nums: IntArray, k: Int): Int {
        if (nums.size == 1) {
            if (k <= 1 || nums[0] == 1)
                return 1
            else
                return 0
        } else if (k >= nums.size) {
            return k
        } else {
            return execute(nums, k)
        }
    }

    private fun execute(nums: IntArray, k: Int): Int {
        var l = 0
        var r = 0
        var maxLength = 0
        var availableFlips = k

        while(r < nums.size) {
            val num = nums[r]
            if (num == 1) {
                maxLength = Math.max(maxLength, r + 1 - l)
                r++
            } else if (num == 0 && availableFlips > 0) {
                maxLength = Math.max(maxLength, r + 1 - l)
                r++
                availableFlips--
            } else { //(num == 0 && availableFlips == 0)
                while (l < r) {
                    if (nums[l] == 0 && availableFlips < k) {
                        availableFlips++
                        l++
                        break
                    } else {
                        l++
                    }
                }

                if (availableFlips > 0) {
                    maxLength = Math.max(maxLength, r + 1 - l)
                    r++
                    availableFlips--
                } else {
                    r++
                    l = Math.max(l+1, r)
                }
            }
        }

        return maxLength
    }

    private data class Input(val nums: IntArray, val k: Int)
}
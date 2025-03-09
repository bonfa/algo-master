package it.fbonfadelli.algo.master.exercises.arrays

import it.fbonfadelli.algo.master.utils.printable

class RotateArray {

    companion object {
        private val rotateArray = RotateArray()

        fun main() {
            println("ROTATE ARRAY")

            val inputs = listOf(
                Input(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3),
                Input(intArrayOf(-1, -100, 3, 99), 2),
                Input(intArrayOf(1, 2, 3), 4),
                Input(intArrayOf(1, 2, 3,4,5), 2),
                Input(intArrayOf(1, 2, 3,4), 2),
                Input(intArrayOf(1, 2, 3), 2),
                Input(intArrayOf(1, 2, 3, 4, 5, 6), 3),
                Input(intArrayOf(1), 0),
                Input(intArrayOf(1,2), 0),
                Input(intArrayOf(1,2), 2),
                Input(
                    intArrayOf(
                        1,
                        2,
                        3,
                        4,
                        5,
                        6,
                        7,
                        8,
                        9,
                        10,
                        11,
                        12,
                        13,
                        14,
                        15,
                        16,
                        17,
                        18,
                        19,
                        20,
                        21,
                        22,
                        23,
                        24,
                        25,
                        26,
                        27,
                        28,
                        29,
                        30,
                        31,
                        32,
                        33,
                        34,
                        35,
                        36,
                        37,
                        38,
                        39,
                        40,
                        41,
                        42,
                        43,
                        44,
                        45,
                        46,
                        47,
                        48,
                        49,
                        50,
                        51,
                        52,
                        53,
                        54
                    ), 45
                ),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index + 1}:")
            println("Input: " + input.array.printable() + "   k=${input.k}")
            rotateArray.rotate(input.array, input.k)
            println("Output: " + input.array.printable())
            println()
        }
    }

    fun rotate(nums: IntArray, k: Int): Unit {
        version2(nums, k)
    }

    private fun version2(nums: IntArray, k: Int): Unit {
        val myK = k % nums.size
        if (nums.size <= 1 || myK == 0)
            return

        invert(nums)
        invertFirstElements(nums, myK)
        invertLatestElements(nums, nums.size - myK)
    }

    private fun invert(nums: IntArray) {
        for (i in 0..(nums.size) / 2 - 1) {
            val temp = nums[nums.size - 1 - i]
            nums[nums.size - 1 - i] = nums[i]
            nums[i] = temp
        }
    }

    private fun invertFirstElements(nums: IntArray, x: Int) {
        for (i in 0..(x - 1) / 2) {
            val temp = nums[x - 1 - i]
            nums[x - 1 - i] = nums[i]
            nums[i] = temp
        }
    }

    private fun invertLatestElements(nums: IntArray, x: Int) {
        for (i in 0..(x - 1) / 2) {
            val temp = nums[nums.size - x + i]
            nums[nums.size - x + i] = nums[nums.size - 1 - i]
            nums[nums.size - 1 - i] = temp
        }
    }

    private fun version1(nums: IntArray, k: Int): Unit {
        val size = nums.size
        val sanitisedK = k % size //eventually the max value of rotation is the size of the array
        if (sanitisedK == 0) return //no need to rotate

        val dest = IntArray(nums.size)

        for (i in 0..size - 1) {
            val newIndex = (i + sanitisedK) % size
            dest[newIndex] = nums[i]
        }

        for (i in 0..size - 1) {
            nums[i] = dest[i]
        }
    }


    fun customLinkedListBased(nums: IntArray, k: Int): Unit {
        if (nums.size == 1 || k == 0)
            return

        //create circular linkedList
        val head = arrayToCircularLinkedList(nums)

        // rotation
        val gap = if (nums.size > k)
            nums.size - k
        else
            nums.size - (k % nums.size)
        val newHead = rotate(head, gap)

        // linked list to array
        var node: Node? = newHead
        var i = 0
        while (i < nums.size) {
            nums[i] = node!!.value
            node = node?.next
            i++
        }
    }

    private fun arrayToCircularLinkedList(nums: IntArray): Node {
        var head: Node? = null
        var previousNode: Node? = null
        for (i in 0..(nums.size - 1)) {
            val node = Node(value = nums[i], next = null)
            if (head == null)
                head = node

            if (previousNode == null)
                previousNode = node
            else {
                previousNode?.next = node
                previousNode = previousNode?.next
            }
        }

        previousNode?.next = head

        return head!!
    }

    private fun rotate(head: Node, steps: Int): Node {
        var newHead: Node = head
        for (i in 0..steps - 1) {
            newHead = newHead!!.next!!
        }

        return newHead!!
    }

    class Node(
        val value: Int,
        var next: Node? = null
    )

    private data class Input(val array: IntArray, val k: Int)
}
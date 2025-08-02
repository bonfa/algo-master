package it.fbonfadelli.algo.master.linked.list.fast.slow.pointers.exercises

import it.fbonfadelli.algo.master.linked.list.util.ListNode

class LinkedListCycleII {

    companion object {
        private val linkedListCycleII = LinkedListCycleII()

        fun main() {
            println("LINKED LIST - CYCLE 2")

            val inputs = listOf(
                Input(intArrayOf(3, 2, 0, -4), 1),
                Input(intArrayOf(1, 2), 0),
                Input(intArrayOf(1), -1),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index + 1}:")
            println("Input: $input")
            val output = linkedListCycleII.execute(input.linkedList())
            println("Output: ${output?.`val`}")
            println()
        }
    }

    private fun execute(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        val seen = mutableSetOf<ListNode>()

        while(fast != null) {
            seen.add(slow!!)

            slow = slow.next

            if (seen.contains(slow))
                return slow

            if (fast.next != null && seen.contains(fast.next))
                return fast.next

            if (fast.next?.next != null && seen.contains(fast.next!!.next))
                return fast.next!!.next

            fast = fast.next?.next
        }

        return null
    }

    private data class Input(private val array: IntArray, private val indexOfTheStartOfTheCycle: Int) {
        fun linkedList(): ListNode? {
            if (array.isEmpty()) return null

            val head = ListNode(array.first())
            var tail = head
            var startOfCycle: ListNode? = if (indexOfTheStartOfTheCycle == 0) head else null

            for (i in 1 until array.size) {
                val newNode = ListNode(array[i])
                if (i == indexOfTheStartOfTheCycle) {
                    startOfCycle = newNode
                }
                tail.next = newNode
                tail = newNode
            }

            if (startOfCycle != null) {
                tail.next = startOfCycle
            }

            return head
        }
    }
}
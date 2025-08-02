package it.fbonfadelli.algo.master.linked.list.fast.slow.pointers.exercises

import it.fbonfadelli.algo.master.linked.list.util.ListNode

class MiddleOfTheLinkedList {

    companion object {
        private val middleOfTheLinkedList = MiddleOfTheLinkedList()

        fun main() {
            println("MIDDLE OF THE LINKED LIST")

            val inputs = listOf(
                Input(intArrayOf(1, 2, 3, 4, 5)),
                Input(intArrayOf(1, 2, 3, 4, 5, 6)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index + 1}:")
            println("Input: $input")
            val output = middleOfTheLinkedList.execute(input.linkedList())
            println("Output: ${output?.printable()}")
            println()
        }
    }

    private fun execute(head: ListNode?): ListNode? {
        if (head?.next == null)
            return head

        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }

    private data class Input(private val array: IntArray) {
        fun linkedList(): ListNode? {
            if (array.isEmpty()) return null

            val head: ListNode? = ListNode(array.first())
            var node = head
            for (i in 1 until array.size) {
                node!!.next = ListNode(array[i])
                node = node.next
            }
            return head!!
        }
    }
}
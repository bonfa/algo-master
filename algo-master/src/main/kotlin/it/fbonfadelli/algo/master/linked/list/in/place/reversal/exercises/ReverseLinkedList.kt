package it.fbonfadelli.algo.master.linked.list.`in`.place.reversal.exercises

import it.fbonfadelli.algo.master.linked.list.base.util.ListNode

class ReverseLinkedList {

    companion object {
        private val reverseLinkedList = ReverseLinkedList()

        fun main() {
            println("REVERSE LINKED LIST")

            val inputs = listOf(
                Input(intArrayOf(1,2,3,4,5)),
                Input(intArrayOf(1,2)),
                Input(intArrayOf()),
                Input(intArrayOf(1)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index + 1}:")
            println("Input: $input")
            val output = reverseLinkedList.execute(input.linkedList())
            println("Output: ${output?.printable()}")
            println()
        }
    }

    private fun execute(head: ListNode?): ListNode? {
        if (head == null || head.next == null)
            return head

        var prev: ListNode? = null
        var node: ListNode? = head
        while (node != null) {
            val following = node.next
            node.next = prev
            prev = node
            node = following
        }

        return prev
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
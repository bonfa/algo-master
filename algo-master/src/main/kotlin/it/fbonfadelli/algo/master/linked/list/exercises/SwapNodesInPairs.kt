package it.fbonfadelli.algo.master.linked.list.exercises

import it.fbonfadelli.algo.master.linked.list.util.ListNode

class SwapNodesInPairs {

    companion object {
        private val swapNodesInPairs = SwapNodesInPairs()

        fun main() {
            println("SWAP NODES IN PAIRS")

            val inputs = listOf(
                Input(intArrayOf(1,2,3,4)),
                Input(intArrayOf()),
                Input(intArrayOf(1)),
                Input(intArrayOf(1,2,3)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = swapNodesInPairs.execute(input.linkedList())
            println("Output: ${output?.printable() ?: "[]"}")
            println()
        }
    }

    private fun execute(head: ListNode?): ListNode? {
        if (head?.next == null)
            return head

        //at least one node

        val dummy = ListNode(1000)
        dummy.next = head

        var node: ListNode? = dummy
        while(node?.next?.next != null) {
            //node -> n2 -> n3 -> n4
            //node -> n3 -> n2 -> n4

            val n2 = node.next
            val n3 = node.next?.next

            val n4 = n3?.next

            node.next = n3
            n3?.next = n2
            n2?.next = n4

            node = n2
        }

        return dummy.next
    }

    private data class Input(private val array: IntArray) {
        fun linkedList(): ListNode? {
            if (array.isEmpty())
                return null

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
package it.fbonfadelli.algo.master.linked.list.base.exercises

import it.fbonfadelli.algo.master.linked.list.base.util.ListNode

class RemoveNthFromEndOfList {

    companion object {
        private val removeNthFromEndOfList = RemoveNthFromEndOfList()

        fun main() {
            println("REMOVE Nth FROM END OF LINKED LIST")

            val inputs = listOf(
                Input(intArrayOf(1,2,3,4,5), 2),
                Input(intArrayOf(1), 1),
                Input(intArrayOf(1, 2), 1),
                Input(intArrayOf(1, 2), 2),
                Input(intArrayOf(1,2,3,4,5), 3),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = removeNthFromEndOfList.execute(input.linkedList(), input.n)
            println("Output: ${output?.printable()}")
            println()
        }
    }

    fun execute(head: ListNode?, n: Int): ListNode? {
        val fakeHead: ListNode? = ListNode(-1)
        fakeHead?.next = head

        var k = n
        var node = fakeHead
        while (k > 0) {
            node = node?.next
            k--
        }

        var prevToRemove = fakeHead
        while(node?.next != null) {
            node = node.next
            prevToRemove = prevToRemove?.next
        }

        prevToRemove?.next = prevToRemove.next?.next

        return fakeHead?.next
    }

    private data class Input(private val array: IntArray, val n: Int) {
        fun linkedList(): ListNode {
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
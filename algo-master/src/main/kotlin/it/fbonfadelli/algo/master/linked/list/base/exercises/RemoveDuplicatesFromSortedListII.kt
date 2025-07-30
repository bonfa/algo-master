package it.fbonfadelli.algo.master.linked.list.base.exercises

import it.fbonfadelli.algo.master.linked.list.base.util.ListNode

class RemoveDuplicatesFromSortedListII {

    companion object {
        private val removeDuplicatesFromSortedListII = RemoveDuplicatesFromSortedListII()

        fun main() {
            println("REMOVE DUPLICATES FROM SORTED LIST II")

            val inputs = listOf(
                Input(intArrayOf(1,2,3,4,5)),
                Input(intArrayOf(1,2,3,3,4,4,5)),
                Input(intArrayOf(1,1,1,2,3)),
                Input(intArrayOf(1,2,2)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = removeDuplicatesFromSortedListII.execute(input.linkedList())
            println("Output: ${output?.printable()}")
            println()
        }
    }

    fun execute(head: ListNode?): ListNode? {
        val fakeHead: ListNode? = ListNode(-1000)
        fakeHead?.next = head

        var prev: ListNode? = fakeHead
        var valueToRemove = -2000
        while (prev?.next != null) {
            val curr = prev.next!!
            val currVal = curr.`val`
            if (curr.`val` == valueToRemove) {
                prev.next = curr.next
            } else if (currVal == curr.next?.`val`) {
                valueToRemove = curr.`val`
                prev.next = curr.next
            } else {
                prev = prev.next
            }
        }

        return fakeHead?.next
    }

    private data class Input(private val array: IntArray) {
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
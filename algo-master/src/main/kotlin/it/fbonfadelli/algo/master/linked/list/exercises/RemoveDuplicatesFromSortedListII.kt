package it.fbonfadelli.algo.master.linked.list.exercises

import it.fbonfadelli.algo.master.linked.list.util.ListNode

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
        var node = head
        var newHead: ListNode? = null
        var prev: ListNode? = null
        while (node != null) {
            val value = node.`val`
            if (node.next?.`val` == value) { //value has to be removed
                var firstNodeWithDifferentValue = node
                while (firstNodeWithDifferentValue?.`val` == value) {
                    firstNodeWithDifferentValue = firstNodeWithDifferentValue.next
                }

                node = firstNodeWithDifferentValue

                if (node == null)
                    prev?.next = null

            } else { //value has to be kept
                if (newHead == null) {
                    newHead = node
                }

                if (prev == null) {
                    prev = node
                } else {
                    prev.next = node
                    prev = prev.next
                }

                node = node.next
            }
        }

        return newHead
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
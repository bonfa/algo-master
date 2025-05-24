package it.fbonfadelli.algo.master.linked.list.exercises

import it.fbonfadelli.algo.master.linked.list.util.ListNode

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
        val size = size(head)

        if (size == n)
            return head?.next

        val indexToRemove = size - n
        val indexOfPredecessor = indexToRemove - 1

        var index = 0
        var node = head
        while(node != null) {
            if (index == indexOfPredecessor) {
                break
            }
            node = node.next
            index++
        }

        node?.next = node.next?.next

        return head
    }

    private fun size(head: ListNode?): Int {
        var size = 0
        var node = head

        while(node != null) {
            size++
            node = node.next
        }

        return size
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
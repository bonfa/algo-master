package it.fbonfadelli.algo.master.linked.list.base.exercises

import it.fbonfadelli.algo.master.linked.list.util.ListNode

class PartitionList {

    companion object {
        private val partitionList = PartitionList()

        fun main() {
            println("PARTITION LIST")

            val inputs = listOf(
                Input(intArrayOf(1,4,3,2,5,2), 3),
                Input(intArrayOf(2,1), 2),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = partitionList.execute(input.linkedList(), input.x)
            println("Output: ${output?.printable()}")
            println()
        }
    }

    fun execute(head: ListNode?, x: Int): ListNode? {
        var smallerHead: ListNode? = ListNode(-1000)
        var otherHead: ListNode? = ListNode(-1000)

        var node = head
        var smallerNode = smallerHead!!
        var otherNode = otherHead!!
        while(node != null) {
            if (node.`val` < x) {
                smallerNode.next = node
                smallerNode = smallerNode.next!!
            } else { // >= x
                otherNode.next = node
                otherNode = otherNode.next!!
            }

            node = node.next
        }

        smallerHead = smallerHead.next
        otherHead = otherHead.next

        if (smallerHead == null)
            return otherHead
        else if (otherHead == null)
            return smallerHead
        else {
            smallerNode.next = otherHead
            otherNode.next = null
            return smallerHead
        }
    }

    private data class Input(private val array: IntArray, val x: Int) {
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
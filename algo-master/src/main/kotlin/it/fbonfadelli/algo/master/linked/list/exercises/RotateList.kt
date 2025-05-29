package it.fbonfadelli.algo.master.linked.list.exercises

import it.fbonfadelli.algo.master.linked.list.util.ListNode

class RotateList {

    companion object {
        private val rotateList = RotateList()

        fun main() {
            println("ROTATE LIST")

            val inputs = listOf(
                Input(intArrayOf(1,2,3,4,5), 2),
                Input(intArrayOf(0,1,2), 4),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = rotateList.execute(input.linkedList(), input.k)
            println("Output: ${output?.printable()}")
            println()
        }
    }

    fun execute(head: ListNode?, k: Int): ListNode? {
        var size = 0
        var node = head
        while (node?.next != null) {
            size++
            node = node.next
        }
        size++

        node?.next = head

        val realK = k % size
        var numberOfShifts = size - realK

        node = head
        while(numberOfShifts > 1) {
            node = node?.next
            numberOfShifts--
        }
        val newHead = node?.next

        node?.next = null

        return newHead
    }

    private data class Input(private val array: IntArray, val k: Int) {
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
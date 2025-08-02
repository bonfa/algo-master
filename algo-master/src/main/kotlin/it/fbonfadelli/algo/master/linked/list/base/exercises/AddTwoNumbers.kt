package it.fbonfadelli.algo.master.linked.list.base.exercises

import it.fbonfadelli.algo.master.linked.list.util.ListNode

class AddTwoNumbers {

    companion object {
        private val addTwoNumbers = AddTwoNumbers()

        fun main() {
            println("ADD TWO NUMBERS")

            val inputs = listOf(
                Input(intArrayOf(2,4,3), intArrayOf(5,6,4)),
                Input(intArrayOf(0), intArrayOf(0)),
                Input(intArrayOf(9,9,9,9,9,9,9), intArrayOf(9,9,9,9)),
                Input(intArrayOf(2,4,9), intArrayOf(5,6,4,9)),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = addTwoNumbers.execute(input.linkedList1(), input.linkedList2())
            println("Output: ${output?.printable()}")
            println()
        }
    }

    fun execute(l1: ListNode?, l2: ListNode?): ListNode? {
        var n1 = l1
        var n2 = l2

        var remainder = 0
        var countN1 = 0
        var countN2 = 0
        while(true) {
            val sum = (n1?.`val` ?: 0) + (n2?.`val` ?: 0) + remainder
            n1?.`val`  = sum % 10
            n2?.`val`  = sum % 10
            remainder = sum / 10

            if (n1 != null) countN1++
            if (n2 != null) countN2++
            if (n1?.next == null && n2?.next == null) {
                break
            }

            n1 = n1?.next
            n2 = n2?.next
        }

        if (remainder == 1) {
            n1?.next = ListNode(1)
            n2?.next = ListNode(1)
        }

        return if (countN1 > countN2) l1 else l2
    }

    private data class Input(private val array1: IntArray, private val array2: IntArray) {
        fun linkedList1(): ListNode = linkedList(array1)
        fun linkedList2(): ListNode = linkedList(array2)

        private fun linkedList(array: IntArray): ListNode {
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
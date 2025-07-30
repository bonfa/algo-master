package it.fbonfadelli.algo.master.linked.list.base.exercises

import it.fbonfadelli.algo.master.linked.list.base.util.ListNode

class IntersectionOfTwoLinkedLists {

    companion object {
        private val intersectionOfTwoLinkedLists = IntersectionOfTwoLinkedLists()

        fun main() {
            println("INTERSECTION OF TWO LINKED LISTS")

            val inputs = listOf(
                Input(8, listOf(4,1,8,4,5), listOf(5,6,1,8,4,5), 2, 3),
                Input(2, listOf(1,9,1,2,4), listOf(3,2,4), 3, 1),
                Input(0, listOf(2,6,4), listOf(1,5), 3, 2),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val (headA, headB) = input.getLinkedLists()
            val output = intersectionOfTwoLinkedLists.execute(headA, headB)
            println("Output: ${output?.printable()}")
            println()
        }
    }

    fun execute(headA:ListNode?, headB:ListNode?): ListNode? {
        var aSize = size(headA)
        var bSize = size(headB)

        var a = headA
        var b = headB

        while(a != b) {
            if (aSize > bSize) {
                a = a?.next
                aSize--
            } else if (bSize > aSize) {
                b = b?.next
                bSize--
            } else { // a.size == b.size
                a = a?.next
                b = b?.next
            }
        }

        return a
    }


    private fun size(headNode: ListNode?): Int {
        var count = 0

        var node = headNode
        while(node != null) {
            count++
            node = node.next
        }

        return count
    }

    private data class Input(val intersectVal: Int, val list1: List<Int>, val list2: List<Int>, val skip1: Int, val skip2: Int) {
        fun getLinkedLists(): Pair<ListNode?, ListNode?> {
            val l1 = list1.take(skip1)
            val l2 = list2.take(skip2)
            val tail1 = list1.drop(skip1)
            val tail2 = list2.drop(skip2)

            assert(tail1.containsAll(tail2))
            assert(tail2.containsAll(tail1))
            assert((tail1.firstOrNull() ?: 0) == intersectVal)

            val head1 = ListNode(l1.first())
            var prev1: ListNode? = head1
            for (i in 1 until l1.size) {
                prev1!!.next = ListNode(l1[i])
                prev1 = prev1.next
            }

            val head2 = ListNode(l2.first())
            var prev2: ListNode? = head2
            for (i in 1 until l2.size) {
                prev2!!.next = ListNode(l2[i])
                prev2 = prev2.next
            }

            if (tail2.isNotEmpty()) {
                var commonNode = ListNode(tail2.first())
                prev1!!.next = commonNode
                prev2!!.next = commonNode

                for (num in tail2.drop(1)) {
                    commonNode.next = ListNode(num)
                    commonNode = commonNode.next!!
                }
            }

            return Pair(head1, head2)
        }
    }
}
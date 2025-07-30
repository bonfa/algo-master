package it.fbonfadelli.algo.master.linked.list.base.util

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun printable(): String {
        val builder = StringBuilder()
        builder.append("[")

        var node: ListNode? = this
        while(node != null) {
            builder.append(node.`val`)
            node = node.next
            if (node != null) {
                builder.append(",")
            }
        }

        builder.append("]")
        return builder.toString()
    }
}
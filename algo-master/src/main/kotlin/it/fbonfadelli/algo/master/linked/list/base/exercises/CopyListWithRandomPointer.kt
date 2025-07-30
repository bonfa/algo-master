package it.fbonfadelli.algo.master.linked.list.base.exercises

import kotlin.collections.get

class CopyListWithRandomPointer {

    companion object {
        private val copyListWithRandomPointer = CopyListWithRandomPointer()

        fun main() {
            println("COPY LIST WITH RANDOM POINTER")

            val inputs = listOf(
                Input(arrayOf(Pair(7, null), Pair(13, 0), Pair(11, 4), Pair(10, 2), Pair(1, 0))),
                Input(arrayOf(Pair(1, 1), Pair(2, 1))),
                Input(arrayOf(Pair(3, null), Pair(3, 0), Pair(3, null))),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input.printable()}")
            val output = copyListWithRandomPointer.execute(input.linkedListWithRandom())
            println("Output: ${output?.printable() ?: "null"}")
            println()
        }
    }

    private fun execute(node: Node?): Node? {
        val nodeMap = mutableMapOf<Node, Node>()
        var originalNode: Node? = node
        var newNode: Node? = null
        var newHead: Node? = null
        while(originalNode != null) {
            val temp = Node(originalNode.`val`)
            if (newHead == null) {
                newHead = temp
                newNode = temp
            }
            else {
                newNode?.next = temp
                newNode = newNode?.next
            }

            nodeMap[originalNode] = temp
            originalNode = originalNode.next
        }

        originalNode = node
        newNode = newHead
        while (originalNode != null) {
            if (originalNode.random != null) {
                newNode?.random = nodeMap[originalNode.random]!!
            }

            newNode = newNode?.next
            originalNode = originalNode.next
        }

        return newHead
    }

    private data class Node(val `val`: Int) {
        var next: Node? = null
        var random: Node? = null

        fun printable(): String {
            var node: Node? = this
            val list = mutableListOf<Node>()
            while (node != null) {
               list.add(node)
               node = node.next
            }

            val pairs = list.map { Pair(it.`val`, it.random?.let { r -> list.indexOf(r) }) }

            val builder = StringBuilder()
            builder.append("[")
            pairs.forEach{p -> builder.append("(${p.first}, ${p.second ?: "null"})")}
            builder.append("]")
            return builder.toString()
        }
    }


    private data class Input(private val array: Array<Pair<Int, Int?>>) {
        fun linkedListWithRandom(): Node? {
            val nodes = array.map { it.first }.map { Node(it) }

            nodes.forEachIndexed { i, n ->
                n.next = if (i + 1 < nodes.size) nodes[i + 1] else null
                n.random = array[i].second?.let { idx -> nodes[idx] }
            }

            return nodes.firstOrNull()
        }

        fun printable(): String = array.joinToString(",")

    }
}
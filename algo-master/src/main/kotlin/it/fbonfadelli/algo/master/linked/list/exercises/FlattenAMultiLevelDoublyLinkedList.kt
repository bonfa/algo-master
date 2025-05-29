package it.fbonfadelli.algo.master.linked.list.exercises

class FlattenAMultiLevelDoublyLinkedList {

    companion object {
        private val flattenAMultiLevelDoublyLinkedList = FlattenAMultiLevelDoublyLinkedList()

        fun main() {
            println("FLATTEN A MULTI LEVEL DOUBLY LINKED LIST")

            val inputs = listOf(
                Input(arrayOf(1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12)),
                Input(arrayOf(1,2,null,3)),
                Input(arrayOf()),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index + 1}:")
            println("Input: ${input.printable()}")
            val output = flattenAMultiLevelDoublyLinkedList.execute(input.doublyLinkedList())
            println("Output: ${output?.printWithoutChildren() ?: "[]"}")
            println()
        }
    }

    private fun execute(root: Node?): Node? =
        flatten(root)

    private fun flatten(root: Node?): Node? {
        if (root == null)
            return null

        var node = root
        while (node != null) {
            if (node.child == null) {
                node = node.next
            } else { //node.child != null
                val flattenedChild: Node? = this.flatten(node.child)

                var tail: Node? = flattenedChild
                while (tail?.next != null) {
                    tail = tail.next
                }

                tail?.next = node.next
                node.next?.prev = tail
                node.child = null
                flattenedChild?.prev = node
                node.next = flattenedChild

                node = tail?.next
            }
        }

        return root
    }

    private class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null

        fun printWithoutChildren(): String {
            var node: Node? = this
            val list = mutableListOf<Int>()
            while (node != null) {
                list.add(node.`val`)
                node = node.next
            }

            return "[" + list.joinToString(",") + "]"
        }
    }

    private data class Input(private val array: Array<Int?>) {
        fun printable(): String = array.joinToString(",")

        fun doublyLinkedList(): Node? = createMultiLevelDoublyLinkedList(array)

        private fun buildLevel(arr: Array<Int?>, start: Int): Pair<Node?, Int> {
            var index = start
            if (index >= arr.size) return Pair(null, index)

            var head: Node? = null
            var tail: Node? = null
            val levelNodes = mutableListOf<Node>()

            while (index < arr.size && arr[index] != null) {
                val newNode = Node(arr[index]!!)
                if (head == null) {
                    head = newNode
                    tail = newNode
                } else {
                    tail?.next = newNode
                    newNode.prev = tail
                    tail = newNode
                }
                levelNodes.add(newNode)
                index++
            }

            if (index < arr.size && arr[index] == null) {
                var nullCount = 0
                while (index < arr.size && arr[index] == null) {
                    nullCount++
                    index++
                }
                if (nullCount > 0 && nullCount <= levelNodes.size) {
                    val parentNode = levelNodes[nullCount - 1]
                    val (childHead, newIndex) = buildLevel(arr, index)
                    parentNode.child = childHead
                    index = newIndex
                }
            }
            return Pair(head, index)
        }

        private fun createMultiLevelDoublyLinkedList(arr: Array<Int?>): Node? {
            val (head, _) = buildLevel(arr, 0)
            return head
        }
    }


}
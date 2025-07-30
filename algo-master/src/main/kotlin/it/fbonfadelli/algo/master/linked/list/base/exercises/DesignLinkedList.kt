package it.fbonfadelli.algo.master.linked.list.base.exercises

class DesignLinkedList {

    companion object {
        private val designLinkedList = DesignLinkedList()

        fun main() {
            println("DESIGN LINKED LIST")

            val inputs = listOf(
                Input(
                    commands = listOf(
                        CreateLinkedList,
                        AddAtHead(1),
                        AddAtTail(3),
                        AddAtIndex(1,2),
                        Get(1),
                        DeleteAtIndex(1),
                        Get(1),
                    )
                ),
                Input(
                    commands = listOf(
                        CreateLinkedList,
                        AddAtHead(1),
                        AddAtTail(3),
                        AddAtIndex(1,2),
                        Get(1),
                        DeleteAtIndex(0),
                        Get(0),
                    ),
                ),
                Input(
                    commands = listOf(
                        CreateLinkedList,
                        AddAtIndex(0,10),
                        AddAtIndex(0,20),
                        AddAtIndex(1,30),
                        Get(0),
                    ),
                ),
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: $input")
            val output = designLinkedList.execute(input.commands)
            println("Output: $output")
            println()
        }
    }

    private fun execute(commands: List<Command>): List<String> {
        var linkedList: MyLinkedList? = null
        return commands.map { command ->
            when(command) {
                CreateLinkedList -> {
                    linkedList = MyLinkedList()
                    "null"
                }
                is AddAtHead -> {
                    linkedList!!.addAtHead(command.value)
                    "null"
                }
                is AddAtIndex -> {
                    linkedList!!.addAtIndex(command.index,command.value)
                    "null"
                }
                is AddAtTail -> {
                    linkedList!!.addAtTail(command.value)
                    "null"
                }
                is DeleteAtIndex -> {
                    linkedList!!.deleteAtIndex(command.index)
                    "null"
                }
                is Get -> {
                    linkedList!!.get(command.index).toString()
                }
            }
        }
    }


    class MyLinkedList() {

        private var head: Node? = null

        fun get(index: Int): Int {
            return nodeAt(index)?.value ?: -1
        }

        fun addAtHead(`val`: Int) {
            val newHead = Node(`val`)
            newHead.next = head
            head = newHead
        }

        fun addAtTail(`val`: Int) {
            if (head == null)
                head = Node(`val`)
            else {
                tail()!!.next = Node(`val`)
            }

        }

        fun addAtIndex(index: Int, `val`: Int) {
            if (index == 0) {
                addAtHead(`val`)
            } else {
                val prev = nodeAt(index - 1)

                if (prev != null) {
                    val toAdd = Node(`val`)
                    toAdd.next = prev.next
                    prev.next = toAdd
                }
            }
        }

        fun deleteAtIndex(index: Int) {
            if (index == 0) {
                head = head?.next
            }
            else {
                val prev = nodeAt(index - 1)
                val following = prev?.next?.next
                prev?.next = following
            }
        }

        private fun tail(): Node? {
            var node: Node? = head

            while(node?.next != null) {
                node = node.next
            }

            return node
        }

        private fun nodeAt(index: Int): Node? {
            var node: Node? = head

            for (i in 0 until index) {
                node = node?.next
                if (node == null)
                    break
            }

            return node
        }
    }

    private class Node(val value: Int) {
        var next: Node? = null
    }

    private data class Input(val commands: List<Command>)

    private sealed interface Command
    private data object CreateLinkedList: Command
    private data class Get(val index: Int): Command
    private data class AddAtHead(val value: Int): Command
    private data class AddAtTail(val value: Int): Command
    private data class AddAtIndex(val index: Int, val value: Int): Command
    private data class DeleteAtIndex(val index: Int): Command
}
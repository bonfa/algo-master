package it.fbonfadelli.algo.master.exercises.hash.tables

class DesignHashMap {

    companion object {
        fun main() {
            println("DESIGN HASH MAP")

            val inputs = listOf(
                Input(
                    commands = listOf(
                        Command.Put(1,1),
                        Command.Put(2,2),
                        Command.Get(1),
                        Command.Get(3),
                        Command.Put(2,1),
                        Command.Get(2),
                        Command.Delete(2),
                        Command.Get(2),
                    ),
                )
            )

            inputs.forEachIndexed { index, input -> execute(index, input) }
        }

        private fun execute(index: Int, input: Input) {
            println("CASE ${index+1}:")
            println("Input: ${input}")
            val hashMap = MyHashMap()
            val output = input.commands.map {
                when (it) {
                    is Command.Delete -> {
                        hashMap.remove(it.key)
                        "null"
                    }

                    is Command.Get -> {
                        val value = hashMap.get(it.key)
                        value.toString()
                    }
                    is Command.Put -> {
                        hashMap.put(it.key, it.value)
                        "null"
                    }
                }
            }
            println("Output: $output")
            println()
        }
    }

    private class MyHashMap {

        private val EMPTY = -1
        private val arr = IntArray(1_000_001) { EMPTY }

        fun put(key: Int, value: Int) {
            arr[key] = value
        }

        fun get(key: Int): Int {
            return arr[key]
        }

        fun remove(key: Int) {
            arr[key] = EMPTY
        }
    }

    private data class Input(val commands: List<Command>)

    private sealed interface Command {
        data class Put(val key: Int, val value: Int): Command
        data class Get(val key: Int): Command
        data class Delete(val key: Int): Command
    }
}
package it.fbonfadelli.algo.master.custom.exercises

import java.util.PriorityQueue

class PriorityQueueUsageExample {

    companion object {
        private val priorityQueueUsageExample = PriorityQueueUsageExample()

        fun main() {
            println("PRIORITY QUEUE - USAGE EXAMPLE")

            val students = listOf(
                Student(1, 65),
                Student(2, 59),
                Student(3, 86),
                Student(4, 100),
                Student(5, 99),
                Student(6, 44),
                Student(7, 85),
                Student(8, 46),
                Student(9, 34),
                Student(10, 87),
            )

            val inputs = listOf(
                Problem(students, 1..100, 4),
                Problem(students,40..60, 2),
                Problem(students,60..70, 1),
                Problem(students,70..80, -1),
                Problem(students,80..90, 10),
                Problem(students,90..99, 5),
            )

            inputs.forEachIndexed { index, probl -> execute(index, probl) }
        }

        private fun execute(index: Int, problem: Problem) {
            println("CASE ${index+1}:")
            println("Input: ${problem.students}")
            val output = priorityQueueUsageExample.execute(problem.students, problem.range)
            println("Output: $output")
            println("Expected output: ${problem.expectedOutput}")
            println()
        }
    }

    private fun execute(students: List<Student>, range: IntRange): Int {
        val priorityQueue = PriorityQueue({ a: Student, b: Student -> b.examScore - a.examScore })
        priorityQueue.addAll(students)

        while(priorityQueue.isNotEmpty()) {
            val candidate = priorityQueue.poll()
            if (candidate.examScore in range)
                return candidate.id
        }

        return -1
    }

    private data class Problem(val students: List<Student>, val range:IntRange, val expectedOutput: Int)

    private data class Student(val id: Int, val examScore: Int)
}
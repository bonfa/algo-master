package it.fbonfadelli

import it.fbonfadelli.arrays.MajorityElement
import it.fbonfadelli.arrays.MoveZeroes
import kotlin.system.exitProcess

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("WELCOME TO MY ALGO MASTER SOLUTIONS")
    println("For the moment I have only exercises for arrays but I hope to add more sections very soon")

    println("At the moment I can just execute the following exercises:")
    println("[1] - Move Zeroes")
    println("[2] - Majority Element")
    println("You can always terminate the program by writing EXIT")
    println("For which exercise do you want to see the solution? (Choose between the above options)")


    val input = readlnOrNull()
    when (input?.trim()) {
        "1" -> MoveZeroes.main()
        "2" -> MajorityElement.main()
        "EXIT" -> exitProcess(0)
        else -> println("Unfortunately, I do not recognize the command. Please try again:")
    }
}
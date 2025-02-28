package it.fbonfadelli

import it.fbonfadelli.arrays.*
import kotlin.system.exitProcess


fun main() {
    println("WELCOME TO MY ALGO MASTER SOLUTIONS")
    println("For the moment I have only exercises for arrays but I hope to add more sections very soon")

    println("At the moment I can just execute the following exercises:")
    println("[1] - Move Zeroes")
    println("[2] - Majority Element")
    println("[3] - Remove Duplicates")
    println("[4] - Max Profit")
    println("[5] - Rotate Array")
    println("[6] - Max Profit II")
    println("[7] - NumberOfZeroFilledSubArrays")
    println("You can always terminate the program by writing EXIT")
    println("For which exercise do you want to see the solution? (Choose between the above options)")


    val input = readlnOrNull()
    when (input?.trim()) {
        "1" -> MoveZeroes.main()
        "2" -> MajorityElement.main()
        "3" -> RemoveDuplicates.main()
        "4" -> MaxProfit.main()
        "5" -> RotateArray.main()
        "6" -> MaxProfitII.main()
        "7" -> NumberOfZeroFilledSubArrays.main()
        "EXIT" -> exitProcess(0)
        else -> println("Unfortunately, I do not recognize the command. Please try again:")
    }
}
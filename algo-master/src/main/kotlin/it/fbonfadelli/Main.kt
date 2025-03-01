package it.fbonfadelli

import it.fbonfadelli.arrays.*
import it.fbonfadelli.strings.IsPalindrome
import it.fbonfadelli.strings.IsSubsequence
import it.fbonfadelli.strings.LongestCommonPrefix
import kotlin.system.exitProcess


fun main() {
    println("WELCOME TO MY ALGO MASTER SOLUTIONS")

    printMainMenu()
}

private fun printMainMenu() {
    println("Choose the category of exercise:")
    println("[1] - Arrays")
    println("[2] - Strings")
    val input = readlnOrNull()
    when (input?.trim()) {
        "1" -> printArrayExercises()
        "2" -> printStringsExercises()
        "EXIT" -> println("Bye bye!").also { exitProcess(0) }
        else -> println("Unfortunately, I do not recognize the command. I am quitting because I am lazy and I do not want to give you a second chance to decide what to do. Anyway, you can run me again :)").also {
            exitProcess(
                0
            )
        }
    }
}

private fun printArrayExercises() {
    println("At the moment I can just execute the following exercises:")
    println("[1] - Move Zeroes")
    println("[2] - Majority Element")
    println("[3] - Remove Duplicates")
    println("[4] - Max Profit")
    println("[5] - Rotate Array")
    println("[6] - Max Profit II")
    println("[7] - Number Of Zero Filled Sub Arrays")
    println("[8] - Increasing Triplet")
//    println("[9] - WIP")
    println()
    println("Additionally, you can execute the two following commands:")
    println("[EXIT] - To terminate me (don't worry, it is not forever. You can always restart me)")
    println("[BACK] - To come back to the main menu")
    println("What do you want to do? (Choose between the above options)")

    val input = readlnOrNull()
    when (input?.trim()) {
        "1" -> MoveZeroes.main()
        "2" -> MajorityElement.main()
        "3" -> RemoveDuplicates.main()
        "4" -> MaxProfit.main()
        "5" -> RotateArray.main()
        "6" -> MaxProfitII.main()
        "7" -> NumberOfZeroFilledSubArrays.main()
        "8" -> IncreasingTriplet.main()
        "EXIT" -> exitProcess(0)
        "BACK" -> printMainMenu()
        else -> println("Unfortunately, I do not recognize the command. I am quitting because I am lazy and I do not want to give you a second chance to decide what to do. Anyway, you can run me again :)").also {
            exitProcess(
                0
            )
        }
    }
}

private fun printStringsExercises() {
    println("At the moment I can execute the following exercises:")
    println("[1] - Is Subsequence")
    println("[2] - Is Palindrome")
    println("[3] - Longest Common Prefix")
    println()
    println("Additionally, you can execute the two following commands:")
    println("[EXIT] - To terminate me (don't worry, it is not forever. You can always restart me)")
    println("[BACK] - To come back to the main menu")
    println("What do you want to do? (Choose between the above options)")

    val input = readlnOrNull()
    when (input?.trim()) {
        "1" -> IsSubsequence.main()
        "2" -> IsPalindrome.main()
        "3" -> LongestCommonPrefix.main()
        "EXIT" -> exitProcess(0)
        "BACK" -> printMainMenu()
        else -> println("Unfortunately, I do not recognize the command. I am quitting because I am lazy and I do not want to give you a second chance to decide what to do. Anyway, you can run me again :)").also {
            exitProcess(
                0
            )
        }
    }
}
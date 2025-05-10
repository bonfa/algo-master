package it.fbonfadelli.algo.master.sliding.window.fixed.size.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.FindAllAnagramsInAString
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.MaximumAverageSubArrayI
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.MaximumSumOfDistinctSubArraysOfLengthK
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.PermutationInString
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.SubStringWithConcatenationOfAllWords

object SlidingWindowFixedSizeMenuPrinter {

    fun execute() {
        println("SLIDING WINDOW FIXED SIZE OPTIONS:")
        println("[1] - Maximum Average SubArray I")
        println("[2] - Find All Anagrams in a String")
        println("[3] - Permutation in String")
        println("[4] - Maximum Sum of Distinct SubArrays With Length K")
        println("[5] - Substring with Concatenation of All Words")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> MaximumAverageSubArrayI.main()
            "2" -> FindAllAnagramsInAString.main()
            "3" -> PermutationInString.main()
            "4" -> MaximumSumOfDistinctSubArraysOfLengthK.main()
            "5" -> SubStringWithConcatenationOfAllWords.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






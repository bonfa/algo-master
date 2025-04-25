package it.fbonfadelli.algo.master.sliding.window.dynamic.size.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises.LongestSubstringWithoutRepeatingCharacters
import it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises.MinimumSizeSubArraySum
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.FindAllAnagramsInAString
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.MaximumAverageSubArrayI
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.MaximumSumOfDistinctSubArraysOfLengthK
import it.fbonfadelli.algo.master.sliding.window.fixed.size.exercises.PermutationInString

object SlidingWindowDynamicSizeMenuPrinter {

    fun execute() {
        println("SLIDING WINDOW DYNAMIC SIZE OPTIONS:")
        println("[1] - Longest Substring Without Repeating Characters")
        println("[3] - Minimum Size Subarray Sum")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> LongestSubstringWithoutRepeatingCharacters.main()
            "3" -> MinimumSizeSubArraySum.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






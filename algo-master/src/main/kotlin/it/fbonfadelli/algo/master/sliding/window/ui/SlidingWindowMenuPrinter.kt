package it.fbonfadelli.algo.master.sliding.window.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.prefix.sum.exercises.*
import it.fbonfadelli.algo.master.sliding.window.exercises.FindAllAnagramsInAString
import it.fbonfadelli.algo.master.sliding.window.exercises.MaximumAverageSubArrayI

object SlidingWindowMenuPrinter {

    fun execute() {
        println("SLIDING WINDOW OPTIONS:")
        println("[1] - Maximum Average Subarray I")
        println("[2] - Find All Anagrams in a String")
//        println("[3] - Permutation in String")
//        println("[4] - Maximum Sum of Distinct Subarrays With Length K")
//        println("[5] - Substring with Concatenation of All Words")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> MaximumAverageSubArrayI.main()
            "2" -> FindAllAnagramsInAString.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






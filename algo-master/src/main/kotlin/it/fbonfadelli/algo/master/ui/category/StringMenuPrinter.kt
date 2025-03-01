package it.fbonfadelli.algo.master.ui.category

import it.fbonfadelli.algo.master.exercises.strings.IsPalindrome
import it.fbonfadelli.algo.master.exercises.strings.IsSubsequence
import it.fbonfadelli.algo.master.exercises.strings.LongestCommonPrefix
import it.fbonfadelli.algo.master.ui.Common

object StringMenuPrinter {

    fun execute() {
        println("STRING OPTIONS:")
        println("[1] - Is Subsequence")
        println("[2] - Is Palindrome")
        println("[3] - Longest Common Prefix")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = Common.Actions.readInputAndSanitizeIt()

        when (input) {
            "1" -> IsSubsequence.main()
            "2" -> IsPalindrome.main()
            "3" -> LongestCommonPrefix.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
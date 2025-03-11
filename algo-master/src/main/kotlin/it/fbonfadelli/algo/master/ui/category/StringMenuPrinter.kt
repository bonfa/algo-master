package it.fbonfadelli.algo.master.ui.category

import it.fbonfadelli.algo.master.exercises.strings.*
import it.fbonfadelli.algo.master.ui.Common

object StringMenuPrinter {

    fun execute() {
        println("STRING OPTIONS:")
        println("[1] - Is Subsequence")
        println("[2] - Is Palindrome")
        println("[3] - Longest Common Prefix")
        println("[4] - Zig Zag Conversion")
        println("[5] - Reverse Words")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = Common.Actions.readInputAndSanitizeIt()

        when (input) {
            "1" -> IsSubsequence.main()
            "2" -> ValidPalindrome.main()
            "3" -> LongestCommonPrefix.main()
            "4" -> ZigZagConversion.main()
            "5" -> ReverseWords.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
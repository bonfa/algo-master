package it.fbonfadelli.algo.master.sliding.window.dynamic.size.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises.LongestSubstringWithoutRepeatingCharacters
import it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises.MaxConsecutiveOnesIII
import it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises.MinimumSizeSubArraySum
import it.fbonfadelli.algo.master.sliding.window.dynamic.size.exercises.MinimumWindowSubString

object SlidingWindowDynamicSizeMenuPrinter {

    fun execute() {
        println("SLIDING WINDOW DYNAMIC SIZE OPTIONS:")
        println("[1] - Longest Substring Without Repeating Characters")
        println("[3] - Minimum Size Subarray Sum")
        println("[4] - Max Consecutive Ones III")
        println("[5] - Minimum Window Sub String")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> LongestSubstringWithoutRepeatingCharacters.main()
            "3" -> MinimumSizeSubArraySum.main()
            "4" -> MaxConsecutiveOnesIII.main()
            "5" -> MinimumWindowSubString.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






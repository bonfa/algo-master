package it.fbonfadelli.algo.master.stack.monotonic.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.stack.generic.exercises.RemoveAllAdjacentDuplicatesInString
import it.fbonfadelli.algo.master.stack.generic.exercises.RemovingStarsFromAString
import it.fbonfadelli.algo.master.stack.generic.exercises.ValidParentheses
import it.fbonfadelli.algo.master.stack.monotonic.exercises.NextGreaterElementI

object MonotonicStackMenuPrinter {

    fun execute() {
        println("MONOTONIC STACK OPTIONS:")
        println("1. Next Greater Element I")
//        println("2. Daily Temperatures")
//        println("3. Online Stock Span")
//        println("4. 132 Pattern")
//        println("5. Number of Visible People in a Queue")
//        println("6. Largest Rectangle in Histogram")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> NextGreaterElementI.main()

            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






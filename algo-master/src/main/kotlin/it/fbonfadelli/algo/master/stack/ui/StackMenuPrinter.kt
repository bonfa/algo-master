package it.fbonfadelli.algo.master.stack.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.stack.exercises.RemoveAllAdjacentDuplicatesInString
import it.fbonfadelli.algo.master.stack.exercises.ValidParentheses

object StackMenuPrinter {

    fun execute() {
        println("SLIDING WINDOW FIXED SIZE OPTIONS:")
        println("1. Valid Parentheses")
        println("2. Remove All Adjacent Duplicates In String")
//        println("3. Min Stack")
//        println("4. Remove Duplicate Letters")
//        println("5. Removing Stars From a String")
//        println("6. Evaluate Reverse Polish Notation")
//        println("7. Basic Calculator II")
//        println("8. Longest Valid Parentheses")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> ValidParentheses.main()
            "2" -> RemoveAllAdjacentDuplicatesInString.main()

            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






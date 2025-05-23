package it.fbonfadelli.algo.master.linked.list.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.linked.list.exercises.IntersectionOfTwoLinkedLists

object LinkedListMenuPrinter {

    fun execute() {
        println("LINKED LIST OPTIONS:")
        println("[1] - Intersection Of Two Linked Lists")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> IntersectionOfTwoLinkedLists.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






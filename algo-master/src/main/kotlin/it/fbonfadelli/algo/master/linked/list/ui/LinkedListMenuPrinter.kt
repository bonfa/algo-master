package it.fbonfadelli.algo.master.linked.list.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.linked.list.exercises.DesignLinkedList
import it.fbonfadelli.algo.master.linked.list.exercises.IntersectionOfTwoLinkedLists
import it.fbonfadelli.algo.master.linked.list.exercises.RemoveNthFromEndOfList

object LinkedListMenuPrinter {

    fun execute() {
        println("LINKED LIST OPTIONS:")
        println("[1] - Intersection Of Two Linked Lists")
        println("[2] - Design Linked List")
        println("[3] - Remove Nth From End Of List")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> IntersectionOfTwoLinkedLists.main()
            "2" -> DesignLinkedList.main()
            "3" -> RemoveNthFromEndOfList.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






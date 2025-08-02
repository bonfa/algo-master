package it.fbonfadelli.algo.master.linked.list.fast.slow.pointers.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.linked.list.base.exercises.AddTwoNumbers
import it.fbonfadelli.algo.master.linked.list.base.exercises.CopyListWithRandomPointer
import it.fbonfadelli.algo.master.linked.list.base.exercises.DesignLinkedList
import it.fbonfadelli.algo.master.linked.list.base.exercises.FlattenAMultiLevelDoublyLinkedList
import it.fbonfadelli.algo.master.linked.list.base.exercises.IntersectionOfTwoLinkedLists
import it.fbonfadelli.algo.master.linked.list.base.exercises.PartitionList
import it.fbonfadelli.algo.master.linked.list.base.exercises.RemoveDuplicatesFromSortedListII
import it.fbonfadelli.algo.master.linked.list.base.exercises.RemoveNthFromEndOfList
import it.fbonfadelli.algo.master.linked.list.base.exercises.RotateList
import it.fbonfadelli.algo.master.linked.list.base.exercises.SwapNodesInPairs
import it.fbonfadelli.algo.master.linked.list.fast.slow.pointers.exercises.MiddleOfTheLinkedList
import it.fbonfadelli.algo.master.linked.list.fast.slow.pointers.exercises.HappyNumber
import it.fbonfadelli.algo.master.linked.list.`in`.place.reversal.exercises.ReverseLinkedList

object LinkedListFastAndSlowPointersMenuPrinter {

    fun execute() {
        println("LINKED LIST - FAST AND SLOW POINTERS - OPTIONS:")
        println("[1] - Middle Of The Linked List")
        println("[2] - Happy Number")

        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> MiddleOfTheLinkedList.main()
            "2" -> HappyNumber.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






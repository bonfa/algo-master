package it.fbonfadelli.algo.master.linked.list.`in`.place.reversal.ui

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
import it.fbonfadelli.algo.master.linked.list.`in`.place.reversal.exercises.ReverseLinkedList

object LinkedListInPlaceReversalMenuPrinter {

    fun execute() {
        println("LINKED LIST - IN PLACE REVERSAL - OPTIONS:")
        println("[1] - Palindrome Linked List")
        println("[2] - Reverse Linked List")
        println("[3] - Reverse Linked List II")
        println("[4] - Reverse Nodes in k-Group")

        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "2" -> ReverseLinkedList.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






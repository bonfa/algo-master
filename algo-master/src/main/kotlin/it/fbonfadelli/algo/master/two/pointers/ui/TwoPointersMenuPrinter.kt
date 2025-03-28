package it.fbonfadelli.algo.master.two.pointers.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.two.pointers.exercises.ContainerWithMostWater
import it.fbonfadelli.algo.master.two.pointers.exercises.MergeSortedArrays
import it.fbonfadelli.algo.master.two.pointers.exercises.TwoSumII

object TwoPointersMenuPrinter {

    fun execute() {
        println("TWO POINTERS OPTIONS:")
        println("[1] - Merge Sorted Arrays")
        println("[2] - Two Sum II - Input Array Is Sorted")
        println("[3] - Container With Most Water")
//        println("[4] - Max Profit")
//        println("[5] - Rotate Array")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> MergeSortedArrays.main()
            "2" -> TwoSumII.main()
            "3" -> ContainerWithMostWater.main()
//            "4" -> MaxProfit.main()
//            "5" -> RotateArray.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
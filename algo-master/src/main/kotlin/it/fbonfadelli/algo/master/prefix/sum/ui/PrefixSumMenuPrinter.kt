package it.fbonfadelli.algo.master.prefix.sum.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.prefix.sum.exercises.RangeSumQueryImmutable
import it.fbonfadelli.algo.master.two.pointers.exercises.ContainerWithMostWater
import it.fbonfadelli.algo.master.two.pointers.exercises.MergeSortedArrays
import it.fbonfadelli.algo.master.two.pointers.exercises.ThreeSum
import it.fbonfadelli.algo.master.two.pointers.exercises.TwoSumII

object PrefixSumMenuPrinter {

    fun execute() {
        println("PREFIX SUM OPTIONS:")
        println("[1] - Range Sum Query - Immutable")
        println("[2] - Subarray Sum Equals K")
//        println("[3] - Container With Most Water")
//        println("[4] - 3Sum")
//        println("[5] - Trapping Rain Water")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> RangeSumQueryImmutable.main()
//            "2" -> TwoSumII.main()
//            "3" -> ContainerWithMostWater.main()
//            "4" -> ThreeSum.main()
//            "5" -> TrappingRainWater.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
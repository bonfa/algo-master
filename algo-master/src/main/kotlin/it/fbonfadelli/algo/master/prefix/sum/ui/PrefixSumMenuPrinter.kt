package it.fbonfadelli.algo.master.prefix.sum.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.prefix.sum.exercises.RangeSumQueryImmutable
import it.fbonfadelli.algo.master.prefix.sum.exercises.SubArraySumEqualsK

object PrefixSumMenuPrinter {

    fun execute() {
        println("PREFIX SUM OPTIONS:")
        println("[1] - Range Sum Query - Immutable")
        println("[2] - SubArray Sum Equals K")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> RangeSumQueryImmutable.main()
            "2" -> SubArraySumEqualsK.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
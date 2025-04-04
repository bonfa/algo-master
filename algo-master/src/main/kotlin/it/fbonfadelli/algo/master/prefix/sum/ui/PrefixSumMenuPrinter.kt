package it.fbonfadelli.algo.master.prefix.sum.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.prefix.sum.exercises.*

object PrefixSumMenuPrinter {

    fun execute() {
        println("PREFIX SUM OPTIONS:")
        println("[1] - Range Sum Query - Immutable")
        println("[2] - SubArray Sum Equals K")
        println("[3] - SubArray Sum Divisible By K")
        println("[4] - Continuous SubArray Sum")
        println("[5] - Contiguous Array")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> RangeSumQueryImmutable.main()
            "2" -> SubArraySumEqualsK.main()
            "3" -> SubArraySumDivisibleByK.main()
            "4" -> ContinuousSubArraySum.main()
            "5" -> ContinguousArray.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
package it.fbonfadelli.algo.master.kadane.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.kadane.exercises.MaximumSubarray

object KadanesAlgorithmMenuPrinter {

    fun execute() {
        println("KADANE'S ALGORITHM OPTIONS:")
        println("[1] - Maximum SubArray")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> MaximumSubarray.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}






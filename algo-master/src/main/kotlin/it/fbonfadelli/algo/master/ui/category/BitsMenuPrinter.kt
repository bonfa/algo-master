package it.fbonfadelli.algo.master.ui.category

import it.fbonfadelli.algo.master.exercises.bits.CountingBits
import it.fbonfadelli.algo.master.ui.Common

object BitsMenuPrinter {

    fun execute() {
        println("BIT MANIPULATION OPTIONS:")
        println("[3] - Counting Bits")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = Common.Actions.readInputAndSanitizeIt()

        when (input) {
            "3" -> CountingBits.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
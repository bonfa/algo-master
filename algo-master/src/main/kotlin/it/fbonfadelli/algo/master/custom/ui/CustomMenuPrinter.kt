package it.fbonfadelli.algo.master.custom.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.custom.exercises.BinarySearchEvolved
import it.fbonfadelli.algo.master.custom.exercises.BinarySearchSimple

object CustomMenuPrinter {

    fun execute() {
        println("CUSTOM EXERCISES:")
        println("[1] - BINARY SEARCH SIMPLE")
        println("[2] - BINARY SEARCH EVOLVED")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> BinarySearchSimple.main()
            "2" -> BinarySearchEvolved.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
package it.fbonfadelli.algo.master.ui

import it.fbonfadelli.algo.master.ui.category.ArrayMenuPrinter
import it.fbonfadelli.algo.master.ui.category.BitManipulationMenuPrinter
import it.fbonfadelli.algo.master.ui.category.StringMenuPrinter

object MainMenuPrinter {

    fun execute() {
        println("WELCOME TO MY ALGO MASTER SOLUTIONS")
        printMainMenu()
    }

    private fun printMainMenu() {
        println("EXERCISE CATEGORIES:")
        println("[1] - Arrays")
        println("[2] - Strings")
        println("[3] - Bit Manipulation")
        println()
        println(Common.Messages.EXIT)

        val input = Common.Actions.readInputAndSanitizeIt()

        when (input) {
            "1" -> ArrayMenuPrinter.execute()
            "2" -> StringMenuPrinter.execute()
            "3" -> BitManipulationMenuPrinter.execute()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            else -> Common.Actions.exitWithError()
        }
    }
}
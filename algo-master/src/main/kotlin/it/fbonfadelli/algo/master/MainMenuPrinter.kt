package it.fbonfadelli.algo.master

import it.fbonfadelli.algo.master.arrays.ui.ArrayMenuPrinter
import it.fbonfadelli.algo.master.bit.manipulation.ui.BitManipulationMenuPrinter
import it.fbonfadelli.algo.master.hash.tables.ui.HashTablesMenuPrinter
import it.fbonfadelli.algo.master.strings.ui.StringMenuPrinter
import it.fbonfadelli.algo.master.two.pointers.ui.TwoPointersMenuPrinter

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
        println("[4] - Hash Tables")
        println("[5] - Two Pointers")
        println()
        println(Common.Messages.EXIT)

        val input = Common.Actions.readInputAndSanitizeIt()

        when (input) {
            "1" -> ArrayMenuPrinter.execute()
            "2" -> StringMenuPrinter.execute()
            "3" -> BitManipulationMenuPrinter.execute()
            "4" -> HashTablesMenuPrinter.execute()
            "5" -> TwoPointersMenuPrinter.execute()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            else -> Common.Actions.exitWithError()
        }
    }
}
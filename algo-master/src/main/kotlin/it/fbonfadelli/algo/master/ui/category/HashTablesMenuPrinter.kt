package it.fbonfadelli.algo.master.ui.category

import it.fbonfadelli.algo.master.exercises.hash.tables.IsomorphicStrings
import it.fbonfadelli.algo.master.exercises.hash.tables.MaxNumberOfBalloons
import it.fbonfadelli.algo.master.exercises.hash.tables.NumberOfGoodPairs
import it.fbonfadelli.algo.master.ui.Common

object HashTablesMenuPrinter {

    fun execute() {
        println("HASH TABLES:")
        println("[2] - Max Number Of Balloons")
        println("[3] - Number of good pairs")
        println("[4] - Isomorphic Strings")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "2" -> MaxNumberOfBalloons.main()
            "3" -> NumberOfGoodPairs.main()
            "4" -> IsomorphicStrings.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
package it.fbonfadelli.algo.master.ui.category

import it.fbonfadelli.algo.master.exercises.arrays.*
import it.fbonfadelli.algo.master.ui.Common

object ArrayMenuPrinter {

    fun execute() {
        println("ARRAY OPTIONS:")
        println("[1] - Move Zeroes")
        println("[2] - Majority Element")
        println("[3] - Remove Duplicates")
        println("[4] - Max Profit")
        println("[5] - Rotate Array")
        println("[6] - Max Profit II")
        println("[7] - Number Of Zero Filled Sub Arrays")
        println("[8] - Increasing Triplet")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> MoveZeroes.main()
            "2" -> MajorityElement.main()
            "3" -> RemoveDuplicates.main()
            "4" -> MaxProfit.main()
            "5" -> RotateArray.main()
            "6" -> MaxProfitII.main()
            "7" -> NumberOfZeroFilledSubArrays.main()
            "8" -> IncreasingTriplet.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
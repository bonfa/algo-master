package it.fbonfadelli.algo.master.bit.manipulation.ui

import it.fbonfadelli.algo.master.bit.manipulation.exercises.*
import it.fbonfadelli.algo.master.Common

object BitManipulationMenuPrinter {

    fun execute() {
        println("BIT MANIPULATION OPTIONS:")
        println("[1] - Single Number")
        println("[2] - Number of 1 Bits")
        println("[3] - Counting Bits")
        println("[4] - Reverse Bits")
        println("[5] - Bitwise AND of number range")
        println("[6] - Single Number III")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = Common.Actions.readInputAndSanitizeIt()

        when (input) {
            "1" -> SingleNumber.main()
            "2" -> NumberOf1Bits.main()
            "3" -> CountingBits.main()
            "4" -> ReverseBits.main()
            "5" -> BitwiseAndOfRange.main()
            "6" -> SingleNumberIII.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
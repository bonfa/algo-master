package it.fbonfadelli.algo.master.matrix.ui

import it.fbonfadelli.algo.master.Common
import it.fbonfadelli.algo.master.matrix.exercises.SpiralMatrix
import it.fbonfadelli.algo.master.prefix.sum.exercises.*

object MatrixMenuPrinter {

    fun execute() {
        println("MATRIX (2D ARRAYS):")
        println("[1] - Spiral matrix")

        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "1" -> SpiralMatrix.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
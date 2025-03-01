package it.fbonfadelli.algo.master.ui

import kotlin.system.exitProcess

object Common {
    object Commands {
        const val EXIT = "EXIT"
        const val BACK = "BACK"
    }

    object Messages {
        const val EXIT = "[${Commands.EXIT}] - Terminate me (don't worry, it is not forever. You can always restart me)"
        const val BACK = "[${Commands.BACK}] - Come back to the main menu"
        const val ASK_FOR_COMMAND = "Type the command between brackets to execute the proper action:"
    }

    object Actions {
        val sayGoodByeAndExit: () -> Unit = {
            println("Bye bye!")
            exitProcess(0)
        }
        val goBackToMainMenu: () -> Unit = {
            MainMenuPrinter.execute()
        }
        val exitWithError: () -> Unit = {
            println("Unfortunately, I do not recognize the command. I am quitting because I am lazy and I do not want to give you a second chance to decide what to do. Anyway, you can run me again :)")
            exitProcess(1)
        }

        val readInputAndSanitizeIt: () -> String? = {
            readlnOrNull()?.trim()?.uppercase()
        }
    }
}
package it.fbonfadelli.algo.master.ui.category

import it.fbonfadelli.algo.master.exercises.hash.tables.*
import it.fbonfadelli.algo.master.ui.Common

object HashTablesMenuPrinter {

    fun execute() {
        println("HASH TABLES:")
        println("[2] - Max Number Of Balloons")
        println("[3] - Number of good pairs")
        println("[4] - Isomorphic Strings")
        println("[5] - Ransom note")
        println("[6] - Contains Duplicates II")
        println("[7] - Group Anagrams")
        println("[8] - Encode And Decode Tiny URL")
        println("[9] - Reorganize String")
        println("[10] - Longest Consecutive Sequence")
        println()
        println(Common.Messages.EXIT)
        println(Common.Messages.BACK)
        println(Common.Messages.ASK_FOR_COMMAND)

        val input = readlnOrNull()?.trim()?.uppercase()

        when (input) {
            "2" -> MaxNumberOfBalloons.main()
            "3" -> NumberOfGoodPairs.main()
            "4" -> IsomorphicStrings.main()
            "5" -> RansomNote.main()
            "6" -> ContainsDuplicateII.main()
            "7" -> GroupAnagrams.main()
            "8" -> EncodeAndDecodeTinyUrl.main()
            "9" -> ReorganizeString.main()
            "10" -> LongestConsecutiveSequence.main()
            Common.Commands.EXIT -> Common.Actions.sayGoodByeAndExit()
            Common.Commands.BACK -> Common.Actions.goBackToMainMenu()
            else -> Common.Actions.exitWithError()
        }
    }
}
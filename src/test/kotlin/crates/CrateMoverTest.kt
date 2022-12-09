package crates

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class CrateMoverTest {
    @Test
    fun canMoveOneCrate() {
        val stacksText = "[C] [D]\n[A] [B]\n 1   2\n"
        val procedures = "move 1 from 2 to 1"
        val topLetters = CrateMover.move(stacksText, procedures)
        assertEquals("DB", topLetters)
    }

    @Test
    fun canMoveOneCrateTheOtherWay() {
        val stacksText = "[C] [D]\n[A] [B]\n 1   2\n"
        val procedures = "move 1 from 1 to 2"
        val topLetters = CrateMover.move(stacksText, procedures)
        assertEquals("AC", topLetters)
    }

    @Test
    fun canMoveTwoCrates() {
        val stacksText = "[C] [D]\n[A] [B]\n 1   2\n"
        val proceduresText = "move 2 from 2 to 1"
        val topLetters = CrateMover.move(stacksText, proceduresText)
        assertEquals("D", topLetters)
    }

    @Test
    fun canMoveCratesManyTimes() {
        val stacksText = "    [D]    \n" + "[N] [C]    \n" + "[Z] [M] [P]\n" + " 1   2   3 "
        val proceduresText = "move 1 from 2 to 1\n" + "move 3 from 1 to 3\n" + "move 2 from 2 to 1\n" + "move 1 from 1 to 2"
        val topLetters = CrateMover.move(stacksText, proceduresText)
        assertEquals("MCD", topLetters)
    }

    @Test
    fun canGetOutcomeOfActualProcedure() {
        val stacksText = Files
            .readAllLines(Path("src/test/resources/crates.txt"))
            .joinToString("\n")
        val proceduresText = Files
            .readAllLines(Path("src/test/resources/rearrangementProcedure.txt"))
            .joinToString("\n")
        val topLetters = CrateMover.move(stacksText, proceduresText)
        assertEquals("JNRSCDWPP", topLetters)
    }

    @Test
    fun canGetOutcomeOfActualStacksAndFirstThreeProcedures() {
        val stacksText = Files
            .readAllLines(Path("src/test/resources/crates.txt"))
            .joinToString("\n")
        val proceduresText = "move 6 from 6 to 5\n" + "move 2 from 5 to 9\n" + "move 8 from 9 to 1"
        val topLetters = CrateMover.move(stacksText, proceduresText)
        assertEquals("BHJLWHLT", topLetters)
    }
}

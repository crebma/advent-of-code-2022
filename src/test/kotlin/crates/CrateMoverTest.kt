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
        assertEquals(listOf('D', 'B'), topLetters)
    }

    @Test
    fun canMoveOneCrateTheOtherWay() {
        val stacksText = "[C] [D]\n[A] [B]\n 1   2\n"
        val procedures = "move 1 from 1 to 2"
        val topLetters = CrateMover.move(stacksText, procedures)
        assertEquals(listOf('A', 'C'), topLetters)
    }

    @Test
    fun canMoveTwoCrates() {
        val stacksText = "[C] [D]\n[A] [B]\n 1   2\n"
        val proceduresText = "move 2 from 2 to 1"
        val topLetters = CrateMover.move(stacksText, proceduresText)
        assertEquals(listOf('B'), topLetters)
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
        assertEquals(listOf('T', 'W', 'S', 'G', 'Q', 'H', 'N', 'H', 'L'), topLetters)
    }

}

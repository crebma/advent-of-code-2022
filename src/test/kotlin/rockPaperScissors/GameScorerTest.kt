package rockPaperScissors

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class GameScorerTest {
    @Test
    fun canScoreAGameWithOneRound() {
        val score = GameScorer().score("A Y")
        assertEquals(4, score)
    }

    @Test
    fun canScoreAGameWithTwoRounds() {
        val score = GameScorer().score("A Y\nB X")
        assertEquals(5, score)
    }

    @Test
    fun canScoreAGameWithThreeRounds() {
        val score = GameScorer().score("A Y\nB X\nC Z")
        assertEquals(12, score)
    }

    @Test
    fun canScoreTheStrategyGuide() {
        val input = Files.readAllLines(
            Path("src/test/resources/rockPaperScissors.txt")
        ).joinToString("\n")
        val score = GameScorer().score(input)
        assertEquals(9541, score)
    }
}

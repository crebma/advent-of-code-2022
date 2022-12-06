package rockPaperScissors

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class GameScorerTest {
    @Test
    fun canScoreAGameWithOneRound() {
        val score = GameScorer().score("A Y")
        assertEquals(8, score)
    }

    @Test
    fun canScoreAGameWithTwoRounds() {
        val score = GameScorer().score("A Y\nB X")
        assertEquals(9, score)
    }

    @Test
    fun canScoreAGameWithThreeRounds() {
        val score = GameScorer().score("A Y\nB X\nC Z")
        assertEquals(15, score)
    }

    @Test
    fun canScoreTheStrategyGuide() {
        val input = Files.readAllLines(
            Path("src/test/resources/rockPaperScissors.txt")
        ).joinToString("\n")
        val score = GameScorer().score(input)
        assertEquals(10595, score)
    }
}

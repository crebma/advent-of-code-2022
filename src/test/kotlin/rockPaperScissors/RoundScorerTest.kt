package rockPaperScissors

import kotlin.test.Test
import kotlin.test.assertEquals

internal class RoundScorerTest {

    @Test
    fun canScoreRockDraw() {
        val score = RoundScorer().score("A Y")
        assertEquals(4, score)
    }

    @Test
    fun canScoreRockLoss() {
        val score = RoundScorer().score("A X")
        assertEquals(3, score)
    }

    @Test
    fun canScoreRockWin() {
        val score = RoundScorer().score("A Z")
        assertEquals(8, score)
    }

    @Test
    fun canScorePaperDraw() {
        val score = RoundScorer().score("B Y")
        assertEquals(5, score)
    }

    @Test
    fun canScorePaperLoss() {
        val score = RoundScorer().score("B X")
        assertEquals(1, score)
    }

    @Test
    fun canScorePaperWin() {
        val score = RoundScorer().score("B Z")
        assertEquals(9, score)
    }

    @Test
    fun canScoreScissorsDraw() {
        val score = RoundScorer().score("C Y")
        assertEquals(6, score)
    }

    @Test
    fun canScoreScissorsLoss() {
        val score = RoundScorer().score("C X")
        assertEquals(2, score)
    }

    @Test
    fun canScoreScissorsWin() {
        val score = RoundScorer().score("C Z")
        assertEquals(7, score)
    }

}

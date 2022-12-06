package rockPaperScissors

import kotlin.test.Test
import kotlin.test.assertEquals

internal class RoundScorerTest {

    @Test
    fun canScoreRockVsPaper() {
        val score = RoundScorer().score("A Y")
        assertEquals(8, score)
    }

    @Test
    fun canScoreRockVsRock() {
        val score = RoundScorer().score("A X")
        assertEquals(4, score)
    }

    @Test
    fun canScoreRockVsScissors() {
        val score = RoundScorer().score("A Z")
        assertEquals(3, score)
    }

    @Test
    fun canScorePaperVsPaper() {
        val score = RoundScorer().score("B Y")
        assertEquals(5, score)
    }

    @Test
    fun canScorePaperVsRock() {
        val score = RoundScorer().score("B X")
        assertEquals(1, score)
    }

    @Test
    fun canScorePaperVsScissors() {
        val score = RoundScorer().score("B Z")
        assertEquals(9, score)
    }

    @Test
    fun canScoreScissorsVsPaper() {
        val score = RoundScorer().score("C Y")
        assertEquals(2, score)
    }

    @Test
    fun canScoreScissorsVsRock() {
        val score = RoundScorer().score("C X")
        assertEquals(7, score)
    }

    @Test
    fun canScoreScissorsVsScissors() {
        val score = RoundScorer().score("C Z")
        assertEquals(6, score)
    }

}

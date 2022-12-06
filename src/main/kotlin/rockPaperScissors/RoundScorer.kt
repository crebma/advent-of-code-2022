package rockPaperScissors

import rockPaperScissors.Move.*
import rockPaperScissors.RoundOutcome.*

class RoundScorer {
    private val winWith = mapOf(
        Rock to Paper, Paper to Scissors, Scissors to Rock
    )
    private val loseWith = mapOf(
        Rock to Scissors, Paper to Rock, Scissors to Paper
    )

    fun score(round: String): Int {
        val plays = round.split(" ")
        val theirMove = Move.fromLetter(plays[0])
        val roundOutcome = RoundOutcome.fromLetter(plays[1])
        val myMove = when (roundOutcome) {
            Draw -> theirMove
            Win -> winWith[theirMove]
            else -> loseWith[theirMove]
        }
        return myMove!!.value + roundOutcome.value
    }
}

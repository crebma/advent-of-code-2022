package rockPaperScissors

import rockPaperScissors.Move.*
import rockPaperScissors.RoundOutcome.*

class RoundScorer {
    fun score(round: String): Int {
        val plays = round.split(" ")
        val theirMove = Move.fromLetter(plays[0])
        val roundOutcome = RoundOutcome.fromLetter(plays[1])
        val myMove = when (roundOutcome) {
            Draw -> {
                theirMove
            }
            Win -> {
                when(theirMove) {
                    Rock -> Paper
                    Paper -> Scissors
                    Scissors -> Rock
                }
            }
            else -> {
                when(theirMove) {
                    Rock -> Scissors
                    Paper -> Rock
                    Scissors -> Paper
                }
            }
        }
        return myMove.value + roundOutcome.value
    }
}

package rockPaperScissors

import rockPaperScissors.Move.*
import rockPaperScissors.RoundOutcome.*

class RoundScorer {
    fun score(round: String): Int {
        val (theirMove, myMove) = getMoves(round)
        return myMove.value + roundValue(theirMove, myMove)
    }

    private fun getMoves(round: String): Pair<Move, Move> {
        val plays = round.split(" ")
        val theirMove = Move.fromLetter(plays[0])
        val myMove = Move.fromLetter(plays[1])
        return Pair(theirMove, myMove)
    }

    private fun roundValue(them: Move, me: Move): Int {
        return when {
            them == me -> { Draw }
            iWin(them, me) -> { Win }
            else -> Lose
        }.value
    }

    private fun iWin(them: Move, me: Move) =
        paperBeatsRock(them, me) ||
        scissorsBeatPaper(them, me) ||
        rockBeatsScissors(them, me)

    private fun rockBeatsScissors(them: Move, me: Move) =
        them == Scissors && me == Rock

    private fun scissorsBeatPaper(them: Move, me: Move) =
        them == Paper && me == Scissors

    private fun paperBeatsRock(them: Move, me: Move) =
        them == Rock && me == Paper
}
